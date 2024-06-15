package Screen;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Utility.TerrainType;

public class Terrain extends JLabel {
    private JTextField nameTexte;
    private JTextField heighttexte;
    private JButton squareColor;
    private TerrainType terrain;

    public Terrain() {}

    public Terrain(TerrainType terrain_, MainFrame frame) {
        this.terrain = terrain_;
        nameTexte = new JTextField(terrain.getName());
        heighttexte = new JTextField(Float.toString(terrain.getHeight()));
        squareColor = new JButton();
        squareColor.setBackground(terrain.getColor());
        squareColor.addActionListener(frame);
        heighttexte.addActionListener(frame);
        nameTexte.addActionListener(frame);
        nameTexte.setBounds(0, 0, 100, 20);
        heighttexte.setBounds(150, 0, 50, 20);
        squareColor.setBounds(0, 20, 200, 20);
        this.add(nameTexte);
        this.add(heighttexte);
        this.add(squareColor);
    }

    public void addToPanel(JPanel contentPane) {
        contentPane.add(this);
    }

    public JButton getButton() {
        return this.squareColor;
    }
    public JTextField getnameTexte() {
        return this.nameTexte;
    }
    public JTextField getheighttexte() {
        return this.heighttexte;
    }

    public TerrainType getTerrainType() {
        return this.terrain;
    }

}
