package com.genceyalcin.utilSTL;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.genceyalcin.util3D.InvalidVectorIndexException;
import com.genceyalcin.util3D.Mesh;
import com.genceyalcin.util3D.Polygon;
import com.genceyalcin.util3D.Triangle;
import com.genceyalcin.util3D.Vector;
import com.genceyalcin.util3D.VectorUtils;

/**
 * A container class for STL utilization functions
 * 
 * @author genceyalcin
 * @version 5.9.2020
 */
public class STLUtils {

    /**
     * Creates a binary STL file given a mesh
     * 
     * @param fileName
     *            The name of the STL file
     * @param object
     *            The mesh to be turned into STL format
     * @throws IOException
     * @throws InvalidVectorIndexException
     */
    public static void createBinarySTLFile(String fileName, Mesh object)
            throws IOException, InvalidVectorIndexException {

        RandomAccessFile stlFile = new RandomAccessFile(fileName, "rw");
        stlFile.setLength(0);

        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(outputBuffer);

        byte[] header = new byte[80];
        dos.write(header);

        List<Polygon> polys = object.getPolygons();
        List<Triangle> tris = new ArrayList<Triangle>();

        for (Polygon p : polys) {
            for (Triangle t : p.triangulate()) {
                tris.add(t);
            }
        }

        System.out.println(tris.size());

        dos.write(intToLittleEndianByteArray(tris.size()));
        dos.flush();

        stlFile.write(outputBuffer.toByteArray());
        outputBuffer.reset();

        int counter = 0;
        for (Triangle t : tris) {

            // Flush every 180 triangles
            if (counter == 180) {
                dos.flush();
                stlFile.write(outputBuffer.toByteArray());
                outputBuffer.reset();
            }

            // Get the vertices for this triangle
            List<Vector> vertices = t.getVertices();

            // Calculate the normal vector
            Vector normal = VectorUtils.findNormalToPlane(vertices.get(0),
                    vertices.get(1), vertices.get(2));

            // Write normal
            dos.write(
                    floatToLittleEndianByteArray(normal.getN(0).floatValue()));
            dos.write(
                    floatToLittleEndianByteArray(normal.getN(1).floatValue()));
            dos.write(
                    floatToLittleEndianByteArray(normal.getN(2).floatValue()));

            // Write vertex 1
            Vector v1 = vertices.get(0);
            dos.write(floatToLittleEndianByteArray(v1.getN(0).floatValue()));
            dos.write(floatToLittleEndianByteArray(v1.getN(1).floatValue()));
            dos.write(floatToLittleEndianByteArray(v1.getN(2).floatValue()));

            // Write vertex 2
            Vector v2 = vertices.get(1);
            dos.write(floatToLittleEndianByteArray(v2.getN(0).floatValue()));
            dos.write(floatToLittleEndianByteArray(v2.getN(1).floatValue()));
            dos.write(floatToLittleEndianByteArray(v2.getN(2).floatValue()));

            // Write vertex 3
            Vector v3 = vertices.get(2);
            dos.write(floatToLittleEndianByteArray(v3.getN(0).floatValue()));
            dos.write(floatToLittleEndianByteArray(v3.getN(1).floatValue()));
            dos.write(floatToLittleEndianByteArray(v3.getN(2).floatValue()));

            // Attribute byte count
            dos.write(shortToLittleEndianByteArray((short) 0));

            counter++;

        }

        if (counter != 0) {
            dos.flush();
            stlFile.write(outputBuffer.toByteArray());
        }

        stlFile.close();
        outputBuffer.close();
    }

    /**
     * Converts a short to a little-endian byte array
     * 
     * @param value
     *            The short to be converted
     * @return A byte array representing the short in little-endian
     */
    private static byte[] shortToLittleEndianByteArray(short value) {
        return new byte[] { (byte) (value), (byte) (value >> 8) };
    }

    /**
     * Converts an integer to a little-endian byte array
     * 
     * @param value
     *            The integer to be converted
     * @return A byte array representing the integer in little-endian
     */
    private static byte[] intToLittleEndianByteArray(int value) {
        return new byte[] { (byte) (value), (byte) (value >> 8),
                (byte) (value >> 16), (byte) (value >> 24) };
    }

    /**
     * Converts a float to a little-endian byte array
     * 
     * @param value
     *            The float to be converted
     * @return A byte array representing the float in little-endian
     */
    private static byte[] floatToLittleEndianByteArray(float value) {
        int intBits = Float.floatToIntBits(value);
        return new byte[] { (byte) (intBits), (byte) (intBits >> 8),
                (byte) (intBits >> 16), (byte) (intBits >> 24) };
    }

}
