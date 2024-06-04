package PerlinNoise;

public class Noise2DMap {

    public static float[][] GenerateNoiseMap(int MAP_WIDTH, int MAP_HEIGHT, float scale, int octaves, float persistance, float lacunarity) {

        float[][] noiseMap = new float[MAP_WIDTH][MAP_HEIGHT];

        if ( scale <= 0) {
            scale = 0.0001f;
        }

        float maxNoiseHeight = -1;
        float minNoiseHeight = 1;

        for (int y = 0; y < MAP_HEIGHT ; y++ ) {
            for (int x = 0; x < MAP_WIDTH ; x++ ) {
                
                float amplitude = 1;
                float frequency = 1;
                float noiseHeight = 0;


                for (int i = 0 ; i < octaves ; i++ ) {
                    float sampleX = x / scale * frequency;
                    float sampleY = y / scale * frequency;

                    float perlinValue = (float) Noise.noise(sampleX, sampleY);
                    noiseHeight += perlinValue * amplitude;
                    amplitude *=  persistance;
                    frequency *= lacunarity;
                }
                /* 
                if ( maxNoiseHeight < noiseHeight) {
                    maxNoiseHeight = noiseHeight;
                } else if ( minNoiseHeight > noiseHeight) {
                    minNoiseHeight = noiseHeight;
                }*/
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
        }*/


        return noiseMap;
    }


}
