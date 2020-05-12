package com.genceyalcin.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.genceyalcin.util3D.Mesh;
import com.genceyalcin.util3D.Polygon;
import com.genceyalcin.util3D.Triangle;
import com.genceyalcin.util3D.Vector3F;
import com.genceyalcin.utilSTL.STLUtils;

/**
 * Runs the driver code for the engine
 * 
 * @author genceyalcin
 * @version 5.9.2020
 */
public class Driver {

    /**
     * The main driver for the engine
     * 
     * @param args
     * @throws InvalidVectorIndexException
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {

        // Make meshes
        List<Polygon> myList = new ArrayList<Polygon>();

        // Front face
        myList.add(new Triangle(new Vector3F(0, 0, 0), new Vector3F(1, 0, 0),
                new Vector3F(0, 1, 0)));
        myList.add(new Triangle(new Vector3F(1, 1, 0), new Vector3F(0, 1, 0),
                new Vector3F(1, 0, 0)));

        Mesh cubeMesh = new Mesh(myList);

        STLUtils.createBinarySTLFile("test.stl", cubeMesh);

    }

}
