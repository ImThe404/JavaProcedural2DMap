package Screen;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Utility.Tuple;

public class MainFrame extends JFrame implements ChangeListener {

    private ImageLabel Image;
    private JPanel contentPane;
    private JPanel pannel;
    private JLabel label;

    private JSlider seed;
    private JSlider scale;
    private JSlider octave;
    private JSlider persistance;
    private JSlider lacunarity;
    private JSlider offsetX;
    private JSlider offsetY;

    private Tuple offset;

    public MainFrame() {
        super("Simple Procedural Map in Java");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // use to close the window on red cross
        this.setSize(1000, 560);                                 // size of the Window
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.contentPane = new JPanel();

        seed = new JSlider(0, 100000, 0);
        seed.setBounds(540, 50, 10, 10);
        seed.addChangeListener(this);
        contentPane.add(seed);

        scale = new JSlider(0, 100, 10);
        scale.setBounds(540, 100, 10, 10);
        scale.addChangeListener(this);
        contentPane.add(scale);

        octave = new JSlider(0, 10, 4);
        octave.setBounds(540, 150, 10, 10);
        octave.addChangeListener(this);
        contentPane.add(octave);

        persistance = new JSlider(0, 10, 5);
        persistance.setBounds(540, 200, 10, 10);
        persistance.addChangeListener(this);
        contentPane.add(persistance);

        lacunarity = new JSlider(0, 100, 18);
        lacunarity.setBounds(540, 250, 10, 10);
        lacunarity.addChangeListener(this);
        contentPane.add(lacunarity);

        offsetX = new JSlider(0, 100, 10);
        offsetX.setBounds(540, 500, 10, 10);
        offsetX.addChangeListener(this);
        contentPane.add(offsetX);

        offsetY = new JSlider(0, 100, 10);
        offsetY.setBounds(540, 600, 10, 10);
        offsetY.addChangeListener(this);
        contentPane.add(offsetY);

        offset = new Tuple(offsetX.getValue(), offsetY.getValue());

        Image = new ImageLabel(100, 100, seed.getValue(), scale.getValue(), octave.getValue(), persistance.getValue()/10f, lacunarity.getValue()/10f, offset);
        pannel = new JPanel();
        this.label = this.Image.Image;
        pannel.add(this.label);
        pannel.setBounds(10, 10, 200, 500);
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
        if (e.getSource() == seed) {
            Image.setseed(seed.getValue());
            this.afficher();
        } else if (e.getSource() == scale) {
            Image.setnoisescale(scale.getValue());
            this.afficher();
        } else if (e.getSource() == octave) {
            Image.setoctave(octave.getValue());
            this.afficher();
        } else if (e.getSource() == persistance) {
            Image.setpersistance(persistance.getValue());
            this.afficher();
        } else if (e.getSource() == lacunarity) {
            Image.setlacunarity(lacunarity.getValue());
            this.afficher();
        } else if (e.getSource() == offsetX) {
            Image.setoffsetX(offsetX.getValue());
            this.afficher();
        } else if (e.getSource() == offsetY) {
            Image.setoffsetY(offsetY.getValue());
            this.afficher();
        }
    }
}