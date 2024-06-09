package PerlinNoise;

import java.util.Random;
import Utility.*;

public class Noise2DMap {

    /*  Take multiple variable and return a procedural perlin noise map
	 *  @param MAP_WIDTH the width of the map
	 *  @param MAP_HEIGHT the height of the map
     * 	@param seed seed of the map who gonna make differance
	 *  @param scale zoom on the map
     * 	@param octaves the number of time we gonna reproduce the algorithme
	 *  @param persistance the power with which we will smooth the ground
     * 	@param lacunarity the power to which we will round the shapes
	 *  @param offset shifts it in x and y
	 *  @return the grid of the map with all the nessesary value of the perlin noise
	 */
    public static float[][] GenerateNoiseMap(int MAP_WIDTH, int MAP_HEIGHT, int seed, float scale, int octaves, float persistance, float lacunarity, Tuple<Float> offset) {
        // make a grid for the map
        float[][] noiseMap = new float[MAP_WIDTH][MAP_HEIGHT];

        Random prng = new Random(seed);
        @SuppressWarnings("unchecked")
        Tuple<Float>[] octaveOffsets = new Tuple[octaves];
        for ( int i = 0; i < octaves; i++) {
            float offsetX = prng.nextInt(200000) -100000 + offset.getFirst();
            float offsetY = prng.nextInt(200000) -100000 + offset.getSecond();
            octaveOffsets[i] = new Tuple<>(offsetX, offsetY);
        }

        // ensure that the scale won't be 0 or negative
        if ( scale <= 0) {
            scale = 0.0001f;
        }

        // find center for the scale
        float halfWidth = MAP_WIDTH / 2f;
        float halfheight = MAP_HEIGHT / 2f;

        for (int y = 0; y < MAP_HEIGHT ; y++ ) {
            for (int x = 0; x < MAP_WIDTH ; x++ ) {
                
                float amplitude = 1;
                float frequency = 1;
                float noiseHeight = 0;


                for (int i = 0 ; i < octaves ; i++ ) {
                    // find the coordinate of the point we looking at
                    float sampleX = (x - halfWidth) / scale * frequency + octaveOffsets[i].getFirst();
                    float sampleY = (y - halfheight) / scale * frequency + octaveOffsets[i].getSecond();

                    // get the perlin noise value
                    float perlinValue = (float) Noise.noise(sampleX, sampleY);

                    // modifie value
                    noiseHeight += perlinValue * amplitude;
                    amplitude *=  persistance;
                    frequency *= lacunarity;
                }
                // Ensure the noise is between 0 and 1 and add it the the grid
                noiseHeight = noiseHeight / 2 + 0.5f;
                if ( noiseHeight > 1) { noiseHeight = 1;}
                if ( noiseHeight < 0) { noiseHeight = 0;}
                noiseMap[x][y] = noiseHeight;
            }
        }

        return noiseMap;
    }


}
