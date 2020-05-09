package com.genceyalcin.util3D;

/**
 * Represents a vector in N dimensional space
 * 
 * @author genceyalcin
 * @version 5.9.2020
 */
public interface Vector {

    /**
     * @param index
     *            The index to get from
     * @return The Nth index of this vector
     */
    public Number getN(int index);

    /**
     * @return The magnitude or length of this vector
     */
    public Number getLength();

    /**
     * Set the Nth index of this vector to the entry
     * 
     * @param entry
     *            The number to insert into the vector
     * @param index
     *            The index to set
     */
    public void setN(Number entry, int index);

    /**
     * Scales the vector by a scalar factor
     * 
     * @param scalar
     *            The scalar factor
     */
    public void scaleVector(Number scalar);

    /**
     * Normalizes the vector (length = 1)
     */
    public void normalizeVector();

    /**
     * Calculates the dot product between this vector and another
     * 
     * @param other
     *            The other vector
     * @return The dot product of the two vectors
     */
    public Number dot(Vector other);

    /**
     * Sets this cross product to the cross product of the two given vectors
     * 
     * @param v1
     *            The first vector
     * @param v2
     *            The second vector
     * @return Cross product: v1 x v2
     */
    public void cross(Vector v1, Vector v2);

    /**
     * Calculates the angle between this vector and another
     * 
     * @param other
     *            The other vector
     * @return The angle between the two vectors
     */
    public Number angleTo(Vector other);

}
