package com.genceyalcin.util3D;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of a 3 dimensional float based vector
 * 
 * @author genceyalcin
 * @version 5.9.2020
 */
public class Vector3F implements Vector {

    // Instance variables ///////////////////////////////////////
    private float[] vector;

    // Constructors /////////////////////////////////////////////

    /**
     * Constructs a Vector3F object out of x y and z entries.
     * 
     * @param x
     *            The x entry
     * @param y
     *            The y entry
     * @param z
     *            The z entry
     */
    public Vector3F(float x, float y, float z) {
        vector = new float[3];
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
    }

    /**
     * Constructs a Vector3F object from a float array
     * 
     * @param vector
     *            The float array
     */
    public Vector3F(float[] vector) {
        this.vector = vector;
    }

    // Methods //////////////////////////////////////////////////

    @Override
    public Number getN() {

        return null;
    }

    @Override
    public Number getLength() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setN(Number entry) {
        // TODO Auto-generated method stub

    }

    @Override
    public void scaleVector(Number scalar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void normalizeVector() {
        // TODO Auto-generated method stub

    }

    @Override
    public Number dot(Vector other) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void cross(Vector v1, Vector v2) {
        // TODO Auto-generated method stub

    }

    @Override
    public Number angleTo(Vector other) {
        // TODO Auto-generated method stub
        return null;
    }

}
