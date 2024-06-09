package Screen;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

// Simple class we use to avoid repetition
public class Bouton extends JButton {

    public Bouton(String name, int x, int y, int width, MainFrame frame) {
        super(name);
        this.setBounds(x, y, width, 50);
        this.setBackground(new Color(20, 0, 100));
        this.setForeground(new Color(255, 255, 255));
        this.addActionListener(frame);
    }

    public void addToPanel(JPanel contentPane) {
        contentPane.add(this);
    }
    
}
