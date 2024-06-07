package Screen;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;

/**
 * La classe Bouton représente un bouton personnalisé qui étend la classe JButton.
 * Il possède des coordonnées et une taille, et peut être utilisé dans différentes fenêtres.
 */
public class Bouton extends JButton {

    public Bouton(String name, int x, int y, int width, MainFrame frame) {
        super(name);
        this.setBounds(x, y, width, 50);
        Color blue = new Color(20, 0, 100);
        this.setBackground(blue);
        Color white = new Color(255, 255, 255);
        this.setForeground(white);
        this.addActionListener(frame);
    }

    public void addToPanel(JPanel contentPane) {
        contentPane.add(this);
    }
    
}
