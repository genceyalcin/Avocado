package com.genceyalcin.noise;

import java.awt.image.BufferedImage;

/**
 * This interface represents a two dimensional noise function.
 * 
 * @author genceyalcin
 * @version 5.12.2020
 */
public interface NoiseFunction2D {

    /**
     * Creates noise. Run this if any changes are made to the properties of the
     * noise function so that it can regenerate under the new parameters.
     */
    public void generateNoise();

    /**
     * Default seed generation function. Generates random seed for the function,
     * and sets the seed to the randomly generated one.
     */
    public void generateRandomSeed();

    /**
     * @return Buffered Image of the 2D noise (gray-scale)
     */
    public BufferedImage getBufferedImage();

    /**
     * Sets the noise function's seed to the passed in parameter
     * 
     * @param seed
     *            The seed we want to use while generating the noise
     */
    public void setSeed(String seed);

    /**
     * @return The seed for this noise function
     */
    public String getSeed();

    /**
     * Set the height and width of the noise image
     * 
     * @param height
     *            The desired height of the image
     * @param width
     *            The desired width of the image
     */
    public void setDimensions(int height, int width);

    /**
     * @return The height of the image
     */
    public int getHeight();

    /**
     * @return The width of the image
     */
    public int getWidth();

}
