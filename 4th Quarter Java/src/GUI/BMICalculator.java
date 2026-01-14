package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculator extends JFrame implements ActionListener {

    private JTextField txtWeight, txtHeight;
    private JLabel lblResult;

    public BMICalculator() {
        setTitle("BMI Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Weight (kg):"));
        txtWeight = new JTextField();
        add(txtWeight);

        add(new JLabel("Height (cm):"));
        txtHeight = new JTextField();
        add(txtHeight);

        JButton btnCalc = new JButton("Calculate BMI");
        btnCalc.addActionListener(this);
        add(btnCalc);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> clear());
        add(btnClear);

        lblResult = new JLabel(" ", SwingConstants.CENTER);
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblResult);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double weight = Double.parseDouble(txtWeight.getText());
            double heightCm = Double.parseDouble(txtHeight.getText());

            double heightM = heightCm / 100;
            double bmi = weight / (heightM * heightM);

            String status;
            if (bmi < 18.5)
                status = "Underweight";
            else if (bmi < 25)
                status = "Normal";
            else if (bmi < 30)
                status = "Overweight";
            else
                status = "Obese";

            lblResult.setText(String.format("BMI: %.2f (%s)", bmi, status));

        } catch (NumberFormatException ex) {
            lblResult.setText("Enter valid numbers.");
        }
    }

    private void clear() {
        txtWeight.setText("");
        txtHeight.setText("");
        lblResult.setText(" ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BMICalculator().setVisible(true));
    }
}

