package com.genceyalcin.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.genceyalcin.noise.NoiseFunction2D;
import com.genceyalcin.noise.RandomNoise2D;
import com.genceyalcin.util3D.Mesh;
import com.genceyalcin.util3D.Polygon;
import com.genceyalcin.util3D.Triangle;
import com.genceyalcin.util3D.Vector;
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
     *            The system arguments at runtime
     * @throws IOException
     *             If there is an error in creating the STL file
     */
    public static void main(String args[]) throws IOException {

        NoiseFunction2D noise = new RandomNoise2D(25, 25, "why");
        BufferedImage noiseImg = noise.getBufferedImage();
        ImageIO.write(noiseImg, "png", new File("testRandomNoise.png"));

        List<Polygon> polys = new ArrayList<Polygon>();
        
//        polys.add(new Triangle(new Vector3F(0,0,0), new Vector3F(0,0,1), new Vector3F(1,0,0)));
        
        float xScale = 5f;
        float zScale = 5f;
        
        float yDampener = 30.0f;
        
        for (int i = 0; i < noiseImg.getWidth() - 1; i++) {
            yDampener = 30.0f;
            for (int j = 0; j < noiseImg.getHeight() - 1; j++) {

                int upperLeft = noiseImg.getRGB(i, j);
                int upperRight = noiseImg.getRGB(i + 1, j);
                int lowerLeft = noiseImg.getRGB(i, j + 1);
                int lowerRight = noiseImg.getRGB(i + 1, j + 1);

                upperLeft /= 0x111111;
                upperRight /= 0x111111;
                lowerLeft /= 0x111111;
                lowerRight /= 0x111111;

                upperLeft &= 0x0f;
                upperRight &= 0x0f;
                lowerLeft &= 0x0f;
                lowerRight &= 0x0f;
               
                float newDampener = yDampener / 1.1f;
                
                Vector tri11 = new Vector3F(i * xScale, lowerLeft / newDampener, (j + 1) * zScale);
                Vector tri12 = new Vector3F((i + 1) * xScale, lowerRight / newDampener, (j + 1) * zScale);
                Vector tri13 = new Vector3F(i * xScale, upperLeft / yDampener, j * zScale);
                
                Polygon tri1 = new Triangle(tri11, tri12, tri13);
                
                Vector tri21 = new Vector3F((i + 1) * xScale, upperRight / yDampener, j * zScale);
                Vector tri22 = new Vector3F(i * xScale, upperLeft / yDampener, j * zScale);
                Vector tri23 = new Vector3F((i + 1) * xScale, lowerRight / newDampener, (j + 1) * zScale);
                
                yDampener = newDampener;
                
                Polygon tri2 = new Triangle (tri21, tri22, tri23);
                
                polys.add(tri1);
                polys.add(tri2);
                
            }
        }

        Mesh noiseTerrain = new Mesh(polys);
        STLUtils.createBinarySTLFile("test.stl", noiseTerrain);
    }

}
