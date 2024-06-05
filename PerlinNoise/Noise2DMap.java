package PerlinNoise;

import java.util.Random;
import Utility.*;

public class Noise2DMap {

    public static float[][] GenerateNoiseMap(int MAP_WIDTH, int MAP_HEIGHT, int seed, float scale, int octaves, float persistance, float lacunarity, Tuple offset) {

        float[][] noiseMap = new float[MAP_WIDTH][MAP_HEIGHT];

        Random prng = new Random(seed);
        Tuple[] octavesOffsets = new Tuple[octaves];
        for ( int i = 0; i < octaves; i++) {
            float offsetX = prng.nextInt(200000) -100000 + offset.getFirst();
            float offsetY = prng.nextInt(200000) -100000 + offset.getSecond();
            octavesOffsets[i] = new Tuple(offsetX, offsetY);
        }


        if ( scale <= 0) {
            scale = 0.0001f;
        }

        float maxNoiseHeight = -100;
        float minNoiseHeight = 100;

        float halfWidth = MAP_WIDTH / 2f;
        float halfheight = MAP_HEIGHT / 2f;

        for (int y = 0; y < MAP_HEIGHT ; y++ ) {
            for (int x = 0; x < MAP_WIDTH ; x++ ) {
                
                float amplitude = 1;
                float frequency = 1;
                float noiseHeight = 0;


                for (int i = 0 ; i < octaves ; i++ ) {
                    float sampleX = (x - halfWidth) / scale * frequency + octavesOffsets[i].getFirst();
                    float sampleY = (y - halfheight) / scale * frequency + octavesOffsets[i].getSecond();

                    float perlinValue = (float) Noise.noise(sampleX, sampleY);
                    if ( perlinValue > 1 || perlinValue < -1 ) {
                        System.out.println(perlinValue);
                    }
                    noiseHeight += perlinValue * amplitude;
                    amplitude *=  persistance;
                    frequency *= lacunarity;
                }
                
                if ( maxNoiseHeight < noiseHeight) {
                    maxNoiseHeight = noiseHeight;
                } else if ( minNoiseHeight > noiseHeight) {
                    minNoiseHeight = noiseHeight;
                }
                noiseMap[x][y] = noiseHeight;
            }
        }
        /* 
        System.out.println(minNoiseHeight);
        System.out.println(maxNoiseHeight);
        for (int y = 0; y < MAP_HEIGHT ; y++ ) {
            for (int x = 0; x < MAP_WIDTH ; x++ ) {
                float value = (1.0f - noiseMap[x][y]) * minNoiseHeight + maxNoiseHeight * noiseMap[x][y];
                noiseMap[x][y] = ( (value - minNoiseHeight) / (maxNoiseHeight - minNoiseHeight) ); // Inverse Lerp
            }
        }
        System.out.println(minNoiseHeight);
        System.out.println(maxNoiseHeight);
*/

        return noiseMap;
    }


}
