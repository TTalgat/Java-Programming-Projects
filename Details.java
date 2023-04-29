import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Objects;

public class Details {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private JTextField textField;
    private JTextField textField2;
    private JPanel panel;
    private JButton clearJButton;
    private JButton calculateJButton;
    private JButton exitJButton;
    private JFrame frame;
    private JLabel label;
    private JLabel result;
    private JLabel bmiResult;
    private JLabel result2;
    private JLabel bmiImg;
    private BorderLayout borderLayout;
    private Icon icon1;
    private Icon icon2;
    private Icon icon3;
    private Icon icon4;

    public Details() {

        frame = new JFrame("BMI CALCULATOR");
        textField = new JTextField();
        panel = new JPanel();
        frame.setLayout(new FlowLayout());
        borderLayout = new BorderLayout(5, 5);

        label = new JLabel("Enter your details: ");
        label.setFont(new Font("Serif", Font.BOLD, 14));
        label.setBounds(30, 20, 200, 30);
        frame.add(label);

        label = new JLabel("Weight (kg): ");
        textField = new JTextField();
        label.setFont(new Font("Serif", Font.BOLD, 14));
        label.setBounds(30, 60, 200, 30);
        textField.setBounds(120, 65, 100, 30);
        frame.add(textField);
        frame.add(label);


        label = new JLabel("Height (cm): ");
        textField2 = new JTextField();
        label.setFont(new Font("Serif", Font.BOLD, 14));
        label.setBounds(30, 100, 200, 30);
        textField2.setBounds(120, 105, 100, 30);
        frame.add(textField2);
        frame.add(label);

        result = new JLabel("Result: ");
        result.setFont(new Font("Serif", Font.BOLD, 14));
        result.setBounds(300, 10, 200, 30);
        frame.add(result);

        bmiResult = new JLabel();
        bmiResult.setFont(new Font("Serif", Font.BOLD, 14));
        bmiResult.setBounds(305, 50, 600, 30);
        frame.add(bmiResult);

        result2 = new JLabel();
        result2.setFont(new Font("Serif", Font.BOLD, 14));
        result2.setBounds(305, 80, 600, 30);
        frame.add(result2);

        bmiImg = new JLabel();
        bmiImg.setBounds(200, 20, 130, 155);
        frame.add(bmiImg);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBounds(300, 40, 270, 150);
        frame.add(panel);

        clearJButton = new JButton("Clear");
        clearJButton.setBounds(50, 170, 90, 30);
        frame.add(clearJButton);

        clearJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
                textField2.setText("");
            }
        });

        calculateJButton = new JButton("Calculate");
        calculateJButton.setBounds(150, 170, 90, 30);
        frame.add(calculateJButton);

        calculateJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                double weight = Double.parseDouble(textField.getText());
                double height = Double.parseDouble(textField2.getText());

                double bmi = weight / (height * height);

                if (bmi < 18.5) {
                    bmiResult.setText("Your BMI Value: " +df.format(bmi));
                    result2.setText("Category: Underweight");
                    bmiImg.setIcon(icon1);
                } else if (bmi < 25) {
                    bmiResult.setText("Your BMI Value: " +df.format(bmi));
                    result2.setText("Category: Normal");
                    bmiImg.setIcon(icon2);
                } else if (bmi < 30) {
                    bmiResult.setText("Your BMI Value: " +df.format(bmi));
                    bmiResult.setText("Category: Overweight");
                    bmiImg.setIcon(icon3);
                } else {
                    bmiResult.setText("Your BMI Value: " + df.format(bmi));
                    result2.setText("Category: Obese");
                    bmiImg.setIcon(icon4);
                }
            }
        });

        exitJButton = new JButton("Exit");
        exitJButton.setBounds(450, 200, 90, 30);
        frame.add(exitJButton);

        exitJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                frame.dispose();
            }
        });

        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Details bmi = new Details();
    }

}
