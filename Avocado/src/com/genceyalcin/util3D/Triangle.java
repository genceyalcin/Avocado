package com.genceyalcin.util3D;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Triangle in 3D space
 * 
 * @author genceyalcin
 * @version 5.9.2020
 */
public class Triangle implements Polygon {

    // Instance Variables /////////////////////////////////////////////////////
    private Vector[] vertices;

    // Constructor ////////////////////////////////////////////////////////////

    /**
     * Constructs a triangle from 3 vectors (vertices)
     * 
     * @param v1
     *            First vertex
     * @param v2
     *            Second vertex
     * @param v3
     *            Third vertex
     */
    public Triangle(Vector v1, Vector v2, Vector v3) {
        vertices = new Vector[3];
        vertices[0] = v1;
        vertices[1] = v2;
        vertices[2] = v3;
    }

    // Public Methods /////////////////////////////////////////////////////////

    /**
     * @return A list of the vectors that make up the polygon
     */
    @Override
    public List<Vector> getVertices() {

        List<Vector> verticesList = new ArrayList<Vector>();

        for (Vector v : vertices) {
            verticesList.add(v);
        }

        return verticesList;
    }

    /**
     * Set the nth vertex of the polygon to a vector
     * 
     * @param vertex
     *            The vector that will replace the vertex
     * @param index
     *            The nth vertex
     */
    @Override
    public void setVertex(Vector vertex, int index)
            throws IndexOutOfBoundsException {

        // If the index for the vertex is not in bounds
        if (index < 0 || index > 2) {
            throw new IndexOutOfBoundsException(
                    "Vertex index was out of bounds");
        }
        
        vertices[index] = vertex; 
        
    }

    /**
     * @return The number of vertices of this polygon
     */
    @Override
    public int getNumVertices() {
        return vertices.length;
    }

    /**
     * @return A list of triangles that make up this polygon
     */
    @Override
    public List<Triangle> triangulate() {
        List<Triangle> triangles = new ArrayList<Triangle>();
        triangles.add(this);
        return triangles;
    }
    
    /**
     * Checks if this polygon is equal to another one
     * 
     * @param o
     *            The object being compared to
     * 
     * @return True if the polygon is equal to the passed in object (vertices
     *         match)
     */
    @Override
    public boolean equals(Object o) {
        
        if (!(o instanceof Triangle)) 
            return false;
                
        if (o == this) {
            return true;
        }
        
        Triangle tri = (Triangle) o;
       
        // TODO - IMPLEMENT THIS LATER
        
        return false;
        
    }
    
}
