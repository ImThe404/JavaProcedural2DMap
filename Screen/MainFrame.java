package Screen;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Utility.Tuple;

public class MainFrame extends JFrame implements ChangeListener, ActionListener {

    private ImageLabel Image;
    private JPanel contentPane;
    private JPanel pannel;
    private JLabel label;

    private Slider seed = new Slider(0, 100000, 0, "seed", this);
    private Slider scale = new Slider(0, 100, 27, "scale", this);
    private Slider octave = new Slider(0, 10, 4, "octave", this);
    private Slider persistance = new Slider(0, 10, 5, "persistance", this);
    private Slider lacunarity = new Slider(0, 100, 18, "lacunarity", this);
    private Slider offsetX= new Slider(0, 100, 0, "offsetX", this);
    private Slider offsetY= new Slider(0, 100, 0, "offsetY", this);

    private Bouton noiseMap = new Bouton("Noise Map", 540, 10, 200, this);
    private Bouton colorMap = new Bouton("Color Map", 750, 10, 200, this);

    private Tuple offset;

    public MainFrame() {
        super("Simple Procedural Map in Java");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // use to close the window on red cross
        this.setSize(1300, 560);                                 // size of the Window
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.contentPane = new JPanel();
        contentPane.setLayout(null);

        seed.setBounds(540, 100, 210, 35);
        seed.addToPanel(contentPane);
        scale.setBounds(540, 135, 210, 35);
        scale.addToPanel(contentPane);
        octave.setBounds(540, 170, 210, 35);
        octave.addToPanel(contentPane);
        persistance.setBounds(540, 205, 210, 35);
        persistance.addToPanel(contentPane);
        lacunarity.setBounds(540, 240, 210, 35);
        lacunarity.addToPanel(contentPane);
        offsetX.setBounds(540, 350, 210, 35);
        offsetX.addToPanel(contentPane);
        offsetY.setBounds(540, 385, 210, 35);
        offsetY.addToPanel(contentPane);
        offset = new Tuple(offsetY.getValue(), offsetX.getValue());

        noiseMap.addToPanel(contentPane);
        colorMap.addToPanel(contentPane);

        Image = new ImageLabel(100, 100, seed.getValue(), scale.getValue(), octave.getValue(), persistance.getValue()/10f, lacunarity.getValue()/10f, offset);
        pannel = new JPanel();
        this.label = this.Image.Image;
        pannel.add(this.label);
        pannel.setBounds(10, 10, 500, 500);
        contentPane.add(pannel);

        this.add(contentPane);
    }

    public void afficher() {
        this.pannel.invalidate();
        this.pannel.removeAll();
        this.pannel.add(Image.Image);
        this.pannel.validate();
        this.pannel.repaint();
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
    //JColorChooser

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == noiseMap) {
            Image.toNoiseMap();
        } else if (e.getSource() == colorMap) { 
            Image.toColorMap();
        } this.afficher();
    }
}