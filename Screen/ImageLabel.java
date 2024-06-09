package Screen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import PerlinNoise.Noise2DMap;
import Utility.Regions;
import Utility.TerrainType;
import Utility.Tuple;

// Class use to make the image of the map ( Noise or color )
public class ImageLabel {

    private BufferedImage bufferedImage;
    private Graphics2D g2d;
    private int choice;

    private int MAP_WIDTH;
    private int MAP_HEIGHT;
    private int seed;
    private float noiseScale;
    private int octaves;
    private float persistance;
    private float lacunarity;
    private Tuple<Float> offset;
    private Regions regions;

    private JLabel Image;

    public ImageLabel(int width, int height, int seed_, float noiseScale_, int octaves_, float persistance_, float lacunarity_, Tuple<Float> offset_, Regions regions_) {
        MAP_WIDTH = width;
        MAP_HEIGHT = height;
        seed = seed_;
        noiseScale = noiseScale_;
        octaves = octaves_;
        persistance = persistance_;
        lacunarity = lacunarity_;
        offset = offset_;
        regions = regions_;
        
        choice = 0;
        this.paint();
    }

    public void paint() {
        this.bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        this.g2d = bufferedImage.createGraphics();
        // Call the Noise algorithm to have the grid
        float[][] ArrayMap = Noise2DMap.GenerateNoiseMap(MAP_WIDTH, MAP_HEIGHT, seed, noiseScale, octaves, persistance, lacunarity, offset);
        for (int row = 0; row < MAP_HEIGHT; row++) {
			for (int col = 0; col < MAP_HEIGHT; col++) {
                float multiplicateur = ArrayMap[row][col];
                Color c = new Color(0);
                if (choice == 0) {
                    // make the degree of black and white
                    c = new Color(multiplicateur, multiplicateur, multiplicateur);
                } else if (choice == 1) {
                    for ( TerrainType terrain : regions.getTerrainList() ) {
                        // try to find the lower color to put
                        if ( multiplicateur <= terrain.getHeight() ) {
                            c = terrain.getColor();
                            break; 
                        }
                    }
                }
                g2d.setColor(c);
                // the image is 500x500 but we want 100x100 pixel so we multiplie per 5
                g2d.fillRect(col*5, row*5, 5, 5);
			}
		}
        g2d.dispose();
        Image = new JLabel(new ImageIcon(bufferedImage));
    }
    public JLabel getImage() {
        return this.Image;
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
    public void setoffsetX(float value) {
        this.offset.setSecond(value);
        this.paint();
    }
    public void setoffsetY(float value) {
        this.offset.setFirst(value);
        this.paint();
    }
    public void toNoiseMap() {
        this.choice = 0;
        this.paint();
    }
    public void toColorMap() {
        this.choice = 1;
        this.paint();
    }

}
