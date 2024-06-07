package Screen;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;

/**
 * La classe Bouton représente un bouton personnalisé qui étend la classe JButton.
 * Il possède des coordonnées et une taille, et peut être utilisé dans différentes fenêtres.
 */
public class Bouton extends JButton {
    Coordonnee coord;
    int size;

    /**
     * Constructeur de la classe Bouton.
     * @param name le nom du bouton
     * @param size la taille du bouton
     * @param coord les coordonnées du bouton
     * @param windows la fenêtre à laquelle le bouton est associé
     */
    public Bouton(String name, int size, Coordonnee coord, MyWindow windows) {
        super(name);
        this.coord = coord;
        this.size = size;
        this.Build();
        this.addActionListener(windows);
    }

    /**
     * Constructeur de la classe Bouton.
     * @param name le nom du bouton
     * @param size la taille du bouton
     * @param coord les coordonnées du bouton
     * @param windows la fenêtre à laquelle le bouton est associé
     */
    public Bouton(String name, int size, Coordonnee coord, Settings windows) {
        super(name);
        this.coord = coord;
        this.size = size;
        this.Build();
        this.addActionListener(windows);
    }
    
    /**
     * Construit le bouton en définissant sa position et sa couleur.
     */
    private void Build() {
        this.setBounds(this.coord.GetX(), this.coord.GetY(), this.size, 50);
        Color blue = new Color(20, 0, 100);
        this.setBackground(blue);
        Color white = new Color(255, 255, 255);
        this.setForeground(white);
    }

    /**
     * Ajoute le bouton à un JPanel.
     * @param contentPane le JPanel auquel le bouton doit être ajouté
     */
    public void addToPanel(JPanel contentPane) {
        contentPane.add(this);
    }

    /**
     * Retourne les coordonnées du bouton.
     * @return les coordonnées du bouton
     */
    public Coordonnee getCoordonnee() {
        return this.coord;
    }

    /**
     * Définit les nouvelles coordonnées du bouton.
     * @param coord les nouvelles coordonnées du bouton
     */
    public void setCoordonnee(Coordonnee coord) {
        this.coord = coord;
        this.setBounds(coord.GetX(), coord.GetY(), this.size, 50);
    }
}
