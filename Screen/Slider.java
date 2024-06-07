package Screen;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Slider extends JLabel {
    private JLabel name; 
    private JLabel value;
    private JSlider slider;

    public Slider(Integer start, Integer end, Integer value_, String name_, MainFrame frame) {
        this.setSize(210, 35);   
        this.name = new JLabel(name_);
        this.value = new JLabel(value_.toString());
        this.slider = new JSlider(start, end, value_);
        this.slider.addChangeListener(frame);

        this.name.setBounds(5, 0, 100, 10);
        this.value.setBounds(175, 0, 40, 10);
        this.slider.setBounds(0, 17, 200, 20);

        this.add(name);
        this.add(value);
        this.add(slider);
        
    }

    public int getValue() {
        return this.slider.getValue();
    }

    public JSlider getSlider() {
        return this.slider;
    }

    public void changeValue(Integer newValue) {
        this.value.setText(newValue.toString());
    }

    public void addToPanel(JPanel contentPane) {
        contentPane.add(this);
    }

}
