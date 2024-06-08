package Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Utility.TerrainType;

public class ColorChooser extends JFrame implements ActionListener {
    private JButton OkButton;
    private JButton CancelButton;
    private JColorChooser chooser;
    private TerrainType terrain;

    private JButton ColorButton;
    private MainFrame frame;

    public ColorChooser(TerrainType terrain_, JButton ColorButton_, MainFrame frame_) {
        this.frame = frame_;
        this.ColorButton = ColorButton_;
        this.terrain = terrain_;
        this.setSize(500, 400);    
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);

        OkButton = new JButton("OK");
        CancelButton = new JButton("Cancel");
        OkButton.addActionListener(this);
        CancelButton.addActionListener(this);

        chooser = new JColorChooser(this.terrain.getColor());

        chooser.setBounds(0,0,500,300);
        OkButton.setBounds(150,310,100,40);
        CancelButton.setBounds(270,310,100,40);

        contentPane.add(chooser);
        contentPane.add(OkButton);
        contentPane.add(CancelButton);

        this.add(contentPane);
    }


        @Override
        public void actionPerformed(ActionEvent e) {
            if ( e.getSource() == OkButton ) {
                this.terrain.setColor(chooser.getColor());
                this.ColorButton.setBackground(chooser.getColor());
                this.frame.getImage().paint();
                this.frame.afficher();
            }
            this.setVisible(false);
            this.dispose();
        }
}
