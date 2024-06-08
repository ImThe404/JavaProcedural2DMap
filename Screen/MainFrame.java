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
    private JLabel label;
    private Regions regions;

    private Slider seed = new Slider(0, 100000, 0, "seed", this);
    private Slider scale = new Slider(0, 100, 27, "scale", this);
    private Slider octave = new Slider(0, 10, 4, "octave", this);
    private Slider persistance = new Slider(0, 10, 5, "persistance", this);
    private Slider lacunarity = new Slider(0, 100, 18, "lacunarity", this);
    private Slider offsetX= new Slider(0, 100, 0, "offsetX", this);
    private Slider offsetY= new Slider(0, 100, 0, "offsetY", this);

    private Bouton noiseMap = new Bouton("Noise Map", 540, 10, 200, this);
    private Bouton colorMap = new Bouton("Color Map", 760, 10, 200, this);

    private Tuple offset;

    public MainFrame() {
        super("Simple Procedural Map in Java");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // use to close the window on red cross
        this.setSize(1000, 560);                                 // size of the Window
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.contentPane = new JPanel();
        contentPane.setLayout(null);

        ArrayList<Slider> sliders = new ArrayList<Slider>(Arrays.asList(seed, scale, octave, persistance, lacunarity, offsetX, offsetY));
        for ( int i = 0 ; i < sliders.size() ; i++ ) {
            Slider s = sliders.get(i);
            s.setBounds(540, 100+(55*i), 210, 35);
            s.addToPanel(contentPane);
        }
        offset = new Tuple(offsetY.getValue(), offsetX.getValue());

        noiseMap.addToPanel(contentPane);
        colorMap.addToPanel(contentPane);

        // CREATING DEFAULT TERRAINTYPE
        TerrainType waterD = new TerrainType("Water Deep", 0.3f, new Color(18,153,235));
        TerrainType waterS = new TerrainType("Water Shallow", 0.4f, new Color(61,184,242));
        TerrainType sand = new TerrainType("Sand", 0.45f, new Color(229,242,70));
        TerrainType grassL = new TerrainType("Grass", 0.55f, new Color(116,227,48));
        TerrainType grassH = new TerrainType("High Grass", 0.6f, new Color(99,191,43));
        TerrainType rockL = new TerrainType("Rock", 0.7f, new Color(156,117,86));
        TerrainType rockH = new TerrainType("Montain", 0.9f, new Color(98,63,26));
        TerrainType snow = new TerrainType("Snow", 1f, new Color(238,238,238));
        regions = new Regions(new ArrayList<TerrainType>(Arrays.asList(waterD, waterS, sand, grassL, grassH, rockL, rockH, snow)));

        Image = new ImageLabel(100, 100, seed.getValue(), scale.getValue(), octave.getValue(), persistance.getValue()/10f, lacunarity.getValue()/10f, offset, regions);
        pannel = new JPanel();
        this.label = this.Image.Image;
        pannel.add(this.label);
        pannel.setBounds(10, 10, 500, 500);
        contentPane.add(pannel);

        for ( int i = 0 ; i < regions.getTerrainList().size() ; i++ ) {
            Terrain terrain = new Terrain(regions.getTerrainList().get(i), this);
            terrain.setBounds(760, 100+(50*i), 200, 40);
            terrain.addToPanel(contentPane);
        }
        this.add(contentPane);
    }

    public void afficher() {
        this.pannel.invalidate();
        this.pannel.removeAll();
        this.pannel.add(Image.Image);
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
            seed.changeValue(seed.getValue());
            Image.setseed(seed.getValue());
        } else if (source == scale.getSlider()) {
            scale.changeValue(scale.getValue());
            Image.setnoisescale(scale.getValue());
        } else if (source == octave.getSlider()) {
            octave.changeValue(octave.getValue());
            Image.setoctave(octave.getValue());
        } else if (source == persistance.getSlider()) {
            persistance.changeValue(persistance.getValue());
            Image.setpersistance(persistance.getValue()/10f);
        } else if (source == lacunarity.getSlider()) {
            lacunarity.changeValue(lacunarity.getValue());
            Image.setlacunarity(lacunarity.getValue()/10f);
        } else if (source == offsetX.getSlider()) {
            offsetX.changeValue(offsetX.getValue());
            Image.setoffsetX(offsetX.getValue());
        } else if (source == offsetY.getSlider()) {
            offsetY.changeValue(offsetY.getValue());
            Image.setoffsetY(offsetY.getValue());
        }
        this.afficher();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == noiseMap) {
            Image.toNoiseMap();
            this.afficher();
        } else if (e.getSource() == colorMap) { 
            Image.toColorMap();
            this.afficher();
        } else {
            for ( int i = 0 ; i < contentPane.getComponentCount() ; i++ ) {
                if ( contentPane.getComponent(i).getClass() == new Terrain().getClass() ) {
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