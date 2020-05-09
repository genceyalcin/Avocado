package com.genceyalcin.main;


import java.util.ArrayList;
import java.util.List;

import com.genceyalcin.util3D.Mesh;
import com.genceyalcin.util3D.Polygon;
import com.genceyalcin.util3D.Triangle;
import com.genceyalcin.util3D.Vector3F;

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
     */
    public static void main(String args[]) {
    	
    	
        // Make meshes
        List<Polygon> myList  = new ArrayList<Polygon>();
        // 
        myList.add(new Triangle(new Vector3F(1,0,0), new Vector3F(1,1,0), new Vector3F(1,1,1)));
        myList.add(new Triangle(new Vector3F(1,0,0), new Vector3F(1,0,1), new Vector3F(1,1,1)));
        //
        myList.add(new Triangle(new Vector3F(0,0,0), new Vector3F(0,0,1), new Vector3F(1,0,1)));
        myList.add(new Triangle(new Vector3F(0,0,0), new Vector3F(1,0,0), new Vector3F(1,0,1)));
        
        // bottom face
        myList.add(new Triangle(new Vector3F(0,0,0), new Vector3F(1,0,0), new Vector3F(1,1,0)));
        myList.add(new Triangle(new Vector3F(0,0,0), new Vector3F(0,1,0), new Vector3F(1,1,0)));
        //
        myList.add(new Triangle(new Vector3F(1,1,0), new Vector3F(1,1,1), new Vector3F(0,1,1)));
        myList.add(new Triangle(new Vector3F(1,1,0), new Vector3F(0,1,0), new Vector3F(0,1,1)));
        
        
        //
        myList.add(new Triangle(new Vector3F(0,0,0), new Vector3F(0,0,1), new Vector3F(0,1,1)));
        myList.add(new Triangle(new Vector3F(0,0,0), new Vector3F(0,1,0), new Vector3F(0,1,1)));
        
        // top face
        myList.add(new Triangle(new Vector3F(0,0,1), new Vector3F(0,1,1), new Vector3F(1,1,1)));
        myList.add(new Triangle(new Vector3F(0,0,1), new Vector3F(1,0,1), new Vector3F(1,1,1)));
        
        
        Mesh cubeMesh = new Mesh(myList);



        
    }

}
