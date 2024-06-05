package Screen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import PerlinNoise.Noise2DMap;
import Utility.Tuple;

public class ImageLabel {

    private BufferedImage bufferedImage;
    private Graphics2D g2d;

    private int MAP_WIDTH;
    private int MAP_HEIGHT;
    private int seed;
    private float noiseScale;
    private int octaves;
    private float persistance;
    private float lacunarity;
    private Tuple offset;

    public JLabel Image;

    public ImageLabel(int width, int height, int seed_, float noiseScale_, int octaves_, float persistance_, float lacunarity_, Tuple offset_) {
        MAP_WIDTH = width;
        MAP_HEIGHT = height;
        seed = seed_;
        noiseScale = noiseScale_;
        octaves = octaves_;
        persistance = persistance_;
        lacunarity = lacunarity_;
        offset = offset_;
        
        this.paint();
    }

    private void paint() {
        this.bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        this.g2d = bufferedImage.createGraphics();
        float[][] ArrayMap = Noise2DMap.GenerateNoiseMap(MAP_WIDTH, MAP_HEIGHT, seed, noiseScale, octaves, persistance, lacunarity, offset);
        for (int row = 0; row < MAP_HEIGHT; row++) {
			for (int col = 0; col < MAP_HEIGHT; col++) {
                float multiplicateur = ArrayMap[row][col];
                if ( multiplicateur > 1) { multiplicateur = 1;}
                if ( multiplicateur < 0) { multiplicateur = 0;}
                Color c = new Color(multiplicateur, multiplicateur, multiplicateur);
                g2d.setColor(c);
                g2d.fillRect(col*5, row*5, 5, 5);
			}
		}
        g2d.dispose();
        Image = new JLabel(new ImageIcon(bufferedImage));
    }

    public void setseed(int value) {
        this.seed = value;
        this.paint();
    }
    public void setnoisescale(float value) {
        this.noiseScale = value;
        this.paint();
    }
    public void setoctave(int value) {
        this.octaves = value;
        this.paint();
    }
    public void setpersistance(float value) {
        this.persistance = value;
        this.paint();
    }
    public void setlacunarity(float value) {
        this.lacunarity = value;
        this.paint();
    }
    public void setoffsetX(int value) {
        this.offset.setFirst(value);
        this.paint();
    }
    public void setoffsetY(int value) {
        this.offset.setSecond(value);
        this.paint();
    }

}
