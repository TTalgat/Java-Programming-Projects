import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class BodyChart{
    private JFrame frame;
    private JPanel panel2;
    private JPanel container;
    private JLabel height;
    private JLabel weight;
    private JTextField heightField;
    private JSlider slider;
    private JLabel result;
    private JLabel bmi;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public BodyChart(){

        frame = new JFrame("YOUR BODY CHART:)");
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(2,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        height = new JLabel("Enter your height (cm): ");
        height.setFont(new Font("Serif", Font.BOLD, 14));
        height.setBounds(20, 20, 150, 30);
        frame.add(height);

        heightField = new JTextField();
        heightField.setBounds(180, 25, 50, 30);
        frame.add(heightField);

        weight = new JLabel("Mark your weight (kg): ");
        weight.setFont(new Font("Serif", Font.BOLD, 14));
        weight.setBounds(20, 70, 150, 30);
        frame.add(weight);


        panel2 = new JPanel(new GridLayout(1,1));
        panel2.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
        panel2.setBounds(20, 130, 450, 100);
        container = new JPanel(new GridLayout(2,1));

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setValue(100);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        slider.setForeground(Color.RED);

        result = new JLabel();
        result.setFont(new Font("Serif", Font.BOLD, 14));
        panel2.add(result);

        container.add(slider);
        panel2.add(container);
        container.add(result);
        frame.add(panel2);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double heightR = Double.parseDouble(heightField.getText());
                double weightR = Double.parseDouble(String.valueOf(slider.getValue()));

                double bmi = weightR / (heightR * heightR);
                if (bmi < 18.5) {
                    result.setText("You are in Underweight");
                } else if (bmi < 25) {
                    result.setText("You are in Normal");
                } else if (bmi < 30) {
                    result.setText("You are in Overweight");
                } else {
                    result.setText("Ops! Diet!!");
                }
            }
        });




        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] arguments){
        BodyChart slider = new BodyChart();

    }
}

