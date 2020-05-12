package com.genceyalcin.util3D;

/**
 * An implementation of a 3 dimensional float based vector
 * 
 * @author genceyalcin, Hamza Butt
 * @version 5.9.2020
 */
public class Vector3F implements Vector {

	// Instance variables ///////////////////////////////////////
	private float[] vector;

	// Constructors /////////////////////////////////////////////

	/**
	 * Constructs a Vector3F object out of x y and z entries.
	 * 
	 * @param x The x entry
	 * @param y The y entry
	 * @param z The z entry
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
	 * @param vector The float array
	 */
	public Vector3F(float[] vector) {
		this.vector = vector;
	}

	// Methods //////////////////////////////////////////////////

    /**
     * @param index
     *            The index to get from
     * @return The Nth index of this vector
     */
    @Override
	public Number getN(int index) throws IndexOutOfBoundsException {
		
		if (index > 2 || index < 0) {
			throw new IndexOutOfBoundsException("Index must be less than 3. Your input: " + index);
		}
		
		return this.vector[index];
		
	}

	/**
     * @return The magnitude or length of this vector
     */
    @Override
    public Number getLength() {
    	
    	double squaredSum = 0;
    	
    	for(int i = 0; i < 3; i++) {
    		squaredSum += vector[i]*vector[i];
    	}
    	
    	return Math.sqrt(squaredSum);
    }

    /**
     * Set the Nth index of this vector to the entry
     * 
     * @param entry
     *            The number to insert into the vector
     * @param index
     *            The index to set
     */
    @Override
    public void setN(Number entry, int index) throws IndexOutOfBoundsException{
    	
    	if (index > 2 || index < 0) {
			throw new IndexOutOfBoundsException("Index must be less than 3. Your input: " + index);
		}
    	
    	vector[index] = entry.floatValue();
    	
    }

    /**
     * Scales the vector by a scalar factor
     * 
     * @param scalar
     *            The scalar factor
     */
    @Override
    public void scaleVector(Number scalar) {
    	
    	for(int i= 0; i < 3; i++) {
    		vector[i] *= scalar.floatValue();
    	}
    	
    }

    /**
     * Normalizes the vector (length = 1)
     */
    @Override
    public void normalizeVector() {
    	
    	float length = this.getLength().floatValue();
    	
    	for(int i= 0; i < 3; i++) {
    		vector[i] /= length;
    	}
    	
    }

    /**
     * Calculates the dot product between this vector and another
     * 
     * @param other
     *            The other vector
     * @return The dot product of the two vectors
     */
    @Override
    public Number dot(Vector other) throws InvalidVectorDimensionsException{
    	
    	if(!(other instanceof Vector3F)) {
    		throw new InvalidVectorDimensionsException("Vector passed in is not of type Vector3F");
    	}
    	
    	Vector3F inputVector = (Vector3F)other;
    	
    	float dotProduct = 0;
    	
    	for(int i = 0; i < 3; i++) {
    		dotProduct += inputVector.vector[i]*vector[i];
    	}
    	
    	return dotProduct;
    }

    /**
     * Sets this vector to the cross product of the two given vectors
     * 
     * @param v1
     *            The first vector
     * @param v2
     *            The second vector
     */
    @Override
    public void cross(Vector v1, Vector v2) throws InvalidVectorDimensionsException{
    	
    	if(!(v1 instanceof Vector3F)) {
    		throw new InvalidVectorDimensionsException("First Vector passed in is not of type Vector3F");
    	}
    	else if(!(v2 instanceof Vector3F)) {
    		throw new InvalidVectorDimensionsException("Second Vector passed in is not of type Vector3F");
    	}
    	
    	Vector3F A = (Vector3F)v1;
    	Vector3F B = (Vector3F)v2;
    	
    	float xNew, yNew, zNew;
    	
    	xNew = A.vector[1]*B.vector[2] - A.vector[2]*B.vector[1];
    	
    	yNew = -(A.vector[0]*B.vector[2] - A.vector[2]*B.vector[0]);
    	
    	zNew = A.vector[0]*B.vector[1] - A.vector[1]*B.vector[0];
    	
    	this.vector[0] = xNew;
    	this.vector[1] = yNew;
    	this.vector[2] = zNew;
    	
    }

    /**
     * Calculates the angle between this vector and another
     * 
     * @param other
     *            The other vector
     * @return The angle between the two vectors in radians
     */
    @Override
    public Number angleTo(Vector other) throws InvalidVectorDimensionsException{
    	
    	if(!(other instanceof Vector3F)) {
    		throw new InvalidVectorDimensionsException("Vector passed in is not of type Vector3F");
    	}
    	
    	Vector3F inputVector = (Vector3F) other;
    	
    	double dotProduct = this.dot(inputVector).doubleValue();
    	
    	double magProduct = this.getLength().doubleValue() * inputVector.getLength().doubleValue();
    	
    	float angle = (float)Math.acos(dotProduct/magProduct);
    	
    	
    	return angle;
    }

}
