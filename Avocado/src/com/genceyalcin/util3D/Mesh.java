package com.genceyalcin.util3D;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a 3D mesh made up of Polygons
 * 
 * @author genceyalcin
 * @version 5.9.2020
 */
public class Mesh {

    // Instance Variables /////////////////////////////////////////////////////
    List<Polygon> polygons;

    // Constructor ////////////////////////////////////////////////////////////

    /**
     * Constructs an empty Mesh
     */
    public Mesh() {
        polygons = new ArrayList<Polygon>();
    }

    /**
     * Constructs a Mesh from a list of polygons
     * 
     * @param polys
     *            A list of polygons
     */
    public Mesh(List<Polygon> polys) {
        polygons = polys;
    }

    // Public Methods /////////////////////////////////////////////////////////

    /**
     * @param index
     *            The index of the polygon within the Mesh
     * @return The polygon at that index
     */
    public Polygon getPolygon(int index) {
        return polygons.get(0);
    }

    /**
     * @return The list of the
     */
    public List<Polygon> getPolygons() {
        return polygons;
    }

    /**
     * Add a polygon to the mesh
     * 
     * @param polygon
     *            The polygon to be added
     */
    public void addPolygon(Polygon polygon) {
        polygons.add(polygon);
    }

    /**
     * Remove a given polygon
     * 
     * @param polygon
     */
    public void removePolygon(Polygon polygon) {
        polygons.remove(polygon);
    }

    /**
     * Remove a polygon at a given index in the Mesh
     * 
     * @param index
     *            The index to remove from
     */
    public void removePolygonAtIndex(int index) {
        polygons.remove(index);
    }
}
