package Screen;

import javax.swing.*;

public class MainFrame extends JFrame {

    private ImageLabel Image;

    public MainFrame() {
        super("Simple Procedural Map in Java");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // use to close the window on red cross
        this.setSize(730, 560);                                 // size of the Window
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        Image = new ImageLabel(500, 500, 100f, 4, 0.5f, 2);
        this.add(Image.LoadImage());
    }
}