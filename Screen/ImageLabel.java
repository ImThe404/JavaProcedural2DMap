package Screen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import PerlinNoise.Noise2DMap;

public class ImageLabel {

    private BufferedImage bufferedImage;
    private Graphics2D g2d;

    private int MAP_WIDTH;
    private int MAP_HEIGHT;
    private float noiseScale;
    private int octaves;
    private float persistance;
    private float lacunarity;

    public ImageLabel(int width, int height, float scale, int oct, float persis, float lacun) {
        MAP_WIDTH = width;
        MAP_HEIGHT = height;
        noiseScale = scale;
        octaves = oct;
        persistance = persis;
        lacunarity = lacun;
        this.bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        this.g2d = bufferedImage.createGraphics();
        float[][] ArrayMap = Noise2DMap.GenerateNoiseMap(MAP_WIDTH, MAP_HEIGHT, noiseScale, octaves, persistance, lacunarity);
        for (int row = 0; row < MAP_HEIGHT; row++) {
			for (int col = 0; col < MAP_HEIGHT; col++) {
                float multiplicateur = ArrayMap[row][col] / 2 + 0.5f;
                //System.out.println(multiplicateur);
                if ( multiplicateur > 1) { multiplicateur = 1;}
                if ( multiplicateur < 0) { multiplicateur = 0;}
                Color c = new Color(multiplicateur, multiplicateur, multiplicateur);
                g2d.setColor(c);
                g2d.fillRect(col, row, 1, 1);
			}
		}
        g2d.dispose();
    }

    public JLabel LoadImage() {
        JLabel label = new JLabel(new ImageIcon(bufferedImage));
        return label;
    }

}
