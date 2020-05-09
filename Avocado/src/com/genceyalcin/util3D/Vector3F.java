package com.genceyalcin.util3D;

/**
 * An implementation of a 3 dimensional float based vector
 * 
 * @author genceyalcin
 * @version 5.9.2020
 */
public class Vector3F implements Vector {
    
    // Instance variables
    private float[] vector;
    
    // Constructors
    public Vector3F(float x, float y, float z) {
        vector = new float[3];
    }
    
    
    // Methods
    
    
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
