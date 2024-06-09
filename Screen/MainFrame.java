package Screen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Utility.Regions;
import Utility.TerrainType;
import Utility.Tuple;

public class MainFrame extends JFrame implements ChangeListener, ActionListener {
    private ImageLabel Image;
    private JPanel contentPane;
    private JPanel pannel;
    private Regions regions;

    // Creating all the sliders for variable
    private Slider seed = new Slider(0, 100000, 0, "seed", this);
    private Slider scale = new Slider(0, 100, 27, "scale", this);
    private Slider octave = new Slider(0, 10, 4, "octave", this);
    private Slider persistance = new Slider(0, 10, 5, "persistance", this);
    private Slider lacunarity = new Slider(0, 100, 18, "lacunarity", this);
    private Slider offsetX= new Slider(0, 1000, 0, "offsetX", this);
    private Slider offsetY= new Slider(0, 1000, 0, "offsetY", this);

    // Creating the 2 buttons to switch mode
    private Bouton noiseMap = new Bouton("Noise Map", 540, 10, 200, this);
    private Bouton colorMap = new Bouton("Color Map", 760, 10, 200, this);
    private Tuple<Float> offset;

    public MainFrame() {
        super("Simple Procedural Map in Java");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 560);                                
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.contentPane = new JPanel();
        this.contentPane.setLayout(null);

        // Add all the slider to the panel
        ArrayList<Slider> sliders = new ArrayList<Slider>(Arrays.asList(seed, scale, octave, persistance, lacunarity, offsetX, offsetY));
        for ( int i = 0 ; i < sliders.size() ; i++ ) {
            Slider s = sliders.get(i);
            s.setBounds(540, 100+(55*i), 210, 35);
            s.addToPanel(contentPane);
        }
        this.offset = new Tuple<>((float)offsetY.getValue(), (float)offsetX.getValue());

        this.noiseMap.addToPanel(contentPane);
        this.colorMap.addToPanel(contentPane);

        // Creating all default terrain
        TerrainType waterD = new TerrainType("Water Deep", 0.3f, new Color(18,153,235));
        TerrainType waterS = new TerrainType("Water Shallow", 0.4f, new Color(61,184,242));
        TerrainType sand = new TerrainType("Sand", 0.45f, new Color(229,242,70));
        TerrainType grassL = new TerrainType("Grass", 0.55f, new Color(116,227,48));
        TerrainType grassH = new TerrainType("High Grass", 0.6f, new Color(99,191,43));
        TerrainType rockL = new TerrainType("Rock", 0.7f, new Color(156,117,86));
        TerrainType rockH = new TerrainType("Montain", 0.9f, new Color(98,63,26));
        TerrainType snow = new TerrainType("Snow", 1f, new Color(238,238,238));
        this.regions = new Regions(new ArrayList<TerrainType>(Arrays.asList(waterD, waterS, sand, grassL, grassH, rockL, rockH, snow)));
        // Add all the terrain to the frame 
        for ( int i = 0 ; i < regions.getTerrainList().size() ; i++ ) {
            Terrain terrain = new Terrain(regions.getTerrainList().get(i), this);
            terrain.setBounds(760, 100+(50*i), 200, 40);
            terrain.addToPanel(contentPane);
        }

        // Making the first image of the map
        this.Image = new ImageLabel(100, 100, seed.getValue(), scale.getValue(), octave.getValue(), persistance.getValue()/10f, lacunarity.getValue()/10f, offset, regions);
        // Add the image to a pannel
        this.pannel = new JPanel();
        JLabel label = this.Image.getImage();
        this.pannel.add(label);
        this.pannel.setBounds(10, 10, 500, 500);
        this.contentPane.add(this.pannel);

        this.add(contentPane);
    }

    public void afficher() {
        // Remove the buffered image and add the new one
        this.pannel.invalidate();
        this.pannel.removeAll();
        this.pannel.add(Image.getImage());
        this.pannel.validate();
        this.pannel.repaint();
    }

    public ImageLabel getImage() {
        return this.Image;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (source == seed.getSlider()) {
            this.seed.changeValue(seed.getValue());
            this.Image.setseed(seed.getValue());
        } else if (source == scale.getSlider()) {
            this.scale.changeValue(scale.getValue());
            this.Image.setnoisescale(scale.getValue());
        } else if (source == octave.getSlider()) {
            this.octave.changeValue(octave.getValue());
            this.Image.setoctave(octave.getValue());
        } else if (source == persistance.getSlider()) {
            this.persistance.changeValue(persistance.getValue());
            this.Image.setpersistance(persistance.getValue()/10f);
        } else if (source == lacunarity.getSlider()) {
            this.lacunarity.changeValue(lacunarity.getValue());
            this.Image.setlacunarity(lacunarity.getValue()/10f);
        } else if (source == offsetX.getSlider()) {
            this.offsetX.changeValue(offsetX.getValue());
            this.Image.setoffsetX(offsetX.getValue());
        } else if (source == offsetY.getSlider()) {
            this.offsetY.changeValue(offsetY.getValue());
            this.Image.setoffsetY(offsetY.getValue());
        }
        this.afficher();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == noiseMap) {
            this.Image.toNoiseMap();
            this.afficher();
        } else if (e.getSource() == colorMap) { 
            this.Image.toColorMap();
            this.afficher();
        } else {
            // Trying to find witch button call the ColorChooser
            for ( int i = 0 ; i < contentPane.getComponentCount() ; i++ ) {
                if ( this.contentPane.getComponent(i).getClass() == new Terrain().getClass() ) {
                    Terrain t = (Terrain)contentPane.getComponent(i);
                    JButton b = (JButton)e.getSource();
                    if ( b == t.getButton() ) {
                        ColorChooser c = new ColorChooser(t.getTerrainType(), b, this); 
                        c.setVisible(true);
                    }
                }
            }
        }
    }
}