package com.genceyalcin.util3D;

import java.util.List;

/**
 * Represents a polygon
 * 
 * @author genceyalcin
 * @version 5.9.2020
 */
public interface Polygon {

    /**
     * @return A list of the vectors that make up the polygon
     */
    public List<Vector> getVertices();

    /**
     * Set the nth vertex of the polygon to a vector
     * 
     * @param vertex
     *            The vector that will replace the vertex
     * @param index
     *            The nth vertex
     */
    public void setVertex(Vector vertex, int index)
            throws IndexOutOfBoundsException;

    /**
     * @return The number of vertices of this polygon
     */
    public int getNumVertices();

    /**
     * @return A list of triangles that make up this polygon
     */
    public List<Triangle> triangulate();

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
    public boolean equals(Object o);
}
