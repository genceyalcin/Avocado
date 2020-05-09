package com.genceyalcin.util3D;

/**
 * A container class for static vector functions
 * 
 * @author genceyalcin
 * @version 5.9.2020
 */
public class VectorUtils {

    /**
     * Finds the normal to a plane defined by 3 vectors
     * 
     * 
     * @param v1
     *            The first plane vector
     * @param v2
     *            The second plane vector
     * @param v3
     *            The third plane vector
     * @return The normal vector to the given plane
     */
    public static Vector findNormalToPlane(Vector v1, Vector v2, Vector v3) {

        Vector plane1;
        Vector plane2;
        try {
            plane1 = new Vector3F(
                    v2.getN(0).floatValue() - v1.getN(0).floatValue(),
                    v2.getN(1).floatValue() - v1.getN(1).floatValue(),
                    v2.getN(2).floatValue() - v1.getN(2).floatValue());

            plane2 = new Vector3F(
                    v3.getN(0).floatValue() - v1.getN(0).floatValue(),
                    v3.getN(1).floatValue() - v1.getN(1).floatValue(),
                    v3.getN(2).floatValue() - v1.getN(2).floatValue());

            plane1.cross(plane1, plane2);

            return plane1;

        } catch (InvalidVectorIndexException
                | InvalidVectorDimensionsException e) {
            e.printStackTrace();
        }

        return null;
    }

}
