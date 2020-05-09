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

        dos.writeInt(tris.size());
        dos.flush();

        stlFile.write(outputBuffer.toByteArray());

        int counter = 0;
        for (Triangle t : tris) {

            // Flush every 180 triangles
            if (counter == 180) {
                dos.flush();
                stlFile.write(outputBuffer.toByteArray());
            }

            // Get the vertices for this triangle
            List<Vector> vertices = t.getVertices();

            // Calculate the normal vector
            Vector normal = VectorUtils.findNormalToPlane(vertices.get(0),
                    vertices.get(1), vertices.get(2));
            
            // Write normal
            dos.writeFloat(normal.getN(0).floatValue());
            dos.writeFloat(normal.getN(1).floatValue());
            dos.writeFloat(normal.getN(2).floatValue());
            
            // Write vertex 1
            Vector v1 = vertices.get(0);
            dos.writeFloat(v1.getN(0).floatValue());
            dos.writeFloat(v1.getN(1).floatValue());
            dos.writeFloat(v1.getN(2).floatValue());
            
            // Write vertex 2
            Vector v2 = vertices.get(1);
            dos.writeFloat(v2.getN(0).floatValue());
            dos.writeFloat(v2.getN(1).floatValue());
            dos.writeFloat(v2.getN(2).floatValue());
            
            // Write vertex 3
            Vector v3 = vertices.get(2);
            dos.writeFloat(v3.getN(0).floatValue());
            dos.writeFloat(v3.getN(1).floatValue());
            dos.writeFloat(v3.getN(2).floatValue());
            
            // Attribute byte count
            dos.writeShort(0);
            
            counter++;

        }

        stlFile.close();
    }

}
