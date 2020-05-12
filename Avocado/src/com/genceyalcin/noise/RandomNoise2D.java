package com.genceyalcin.noise;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class RandomNoise2D implements NoiseFunction2D {

    // Instance Variables /////////////////////////////////////////////////////

    private final int DEFAULT_HEIGHT = 100;
    private final int DEFAULT_WIDTH = 100;
    private final int DEFAULT_SEED_LENGTH = 8;

    private BufferedImage noiseImg;
    private String seed;
    private Random random;

    private int height;
    private int width;

    // Constructors ///////////////////////////////////////////////////////////

    /**
     * Creates a RandomNoise2D instance with a random seed and default
     * dimensions.
     */
    public RandomNoise2D() {

        noiseImg = new BufferedImage(DEFAULT_HEIGHT, DEFAULT_WIDTH,
                BufferedImage.TYPE_BYTE_GRAY);
        height = DEFAULT_HEIGHT;
        width = DEFAULT_WIDTH;

        generateRandomSeed();
        generateNoise();
    }

    /**
     * Creates a RandomNoise2D instance with a given seed and default
     * dimensions.
     * 
     * @param seed
     *            The desired seed for the noise generation function
     */
    public RandomNoise2D(String seed) {

        noiseImg = new BufferedImage(DEFAULT_HEIGHT, DEFAULT_WIDTH,
                BufferedImage.TYPE_BYTE_GRAY);
        height = DEFAULT_HEIGHT;
        width = DEFAULT_WIDTH;

        setSeed(seed);
        generateNoise();
    }

    /**
     * Creates a RandomNoise2D instance with a given seed and given dimensions.
     * 
     * @param height
     *            The desired height of the noise image
     * @param width
     *            The desired width of the noise image
     * @param seed
     *            The desired seed for the noise generation function
     */
    public RandomNoise2D(int height, int width, String seed) {

        noiseImg = new BufferedImage(height, width,
                BufferedImage.TYPE_BYTE_GRAY);
        this.height = height;
        this.width = width;

        setSeed(seed);
        generateNoise();
    }

    // Public Methods /////////////////////////////////////////////////////////

    /**
     * Creates noise. Run this if any changes are made to the properties of the
     * noise function so that it can regenerate under the new parameters.
     */
    @Override
    public void generateNoise() {

        // Go through each pixel in the image
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                noiseImg.setRGB(i, j, random.nextInt(0xffffff));
            }
        }

    }

    /**
     * Default seed generation function. Generates random seed for the function,
     * and sets the seed to the randomly generated one.
     */
    public void generateRandomSeed() {
        // Create a new random generator
        Random seedRandom = new Random();

        // Create an 8 byte seed using an individual digits method
        long seedNumber = 0;
        for (int i = 0; i < DEFAULT_SEED_LENGTH * 2 + 3; i++) {
            seedNumber += seedRandom.nextInt(10) * (Math.pow(10, i));
        }

        // Convert long to string
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        try {
            dos.writeLong(seedNumber);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] seedBytes = bos.toByteArray();

        // Set the seed and random generator of the class
        seed = new String(seedBytes);
        random = new Random(seedNumber);
    }

    /**
     * @return Buffered Image of the 2D noise (gray-scale)
     */
    @Override
    public BufferedImage getBufferedImage() {
        return noiseImg;
    }

    /**
     * Sets the noise function's seed to the passed in parameter
     * 
     * @param seed
     *            The seed we want to use while generating the noise
     */
    @Override
    public void setSeed(String seed) {
        // Set the String seed
        this.seed = seed;

        // Convert to byte array
        byte[] seedBytes = seed.getBytes();

        // If the byte array isn't long enough for our default seed size, we
        // need to copy its contents in a loop
        if (seed.length() < DEFAULT_SEED_LENGTH) {

            byte[] newBytes = new byte[DEFAULT_SEED_LENGTH];

            for (int i = 0; i < DEFAULT_SEED_LENGTH; i++) {
                newBytes[i] = seedBytes[i % seed.length()];
            }

            seedBytes = newBytes;
        }

        // Initialize seed number
        long seedNumber = 0;
        int skipFactor = seedBytes.length / DEFAULT_SEED_LENGTH;

        // Set the long seed bytes
        int shift = 0;
        for (int i = 0; i < DEFAULT_SEED_LENGTH; i += skipFactor) {
            seedNumber |= seedBytes[i] << shift;
            shift++;
        }

        // Re-instantiate the seed through
        random = new Random(seedNumber);
    }

    /**
     * @return The seed for this noise function
     */
    @Override
    public String getSeed() {
        return seed;
    }

    /**
     * Set the height and width of the noise image
     * 
     * @param height
     *            The desired height of the image
     * @param width
     *            The desired width of the image
     */
    @Override
    public void setDimensions(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /**
     * @return The height of the image
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * @return The width of the image
     */
    @Override
    public int getWidth() {
        return width;
    }

}
