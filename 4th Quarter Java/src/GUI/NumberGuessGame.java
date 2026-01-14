package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessGame extends JFrame implements ActionListener {

    private JTextField txtGuess;
    private JLabel lblResult, lblAttempts;
    private JButton btnGuess, btnReset;

    private int number;
    private int attempts = 0;
    private Random rand = new Random();

    public NumberGuessGame() {
        setTitle("Number Guessing Game");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        number = rand.nextInt(100) + 1;

        add(new JLabel("Guess a number (1 - 100):", SwingConstants.CENTER));

        txtGuess = new JTextField();
        add(txtGuess);

        btnGuess = new JButton("Guess");
        btnGuess.addActionListener(this);
        add(btnGuess);

        lblResult = new JLabel(" ", SwingConstants.CENTER);
        add(lblResult);

        lblAttempts = new JLabel("Attempts: 0", SwingConstants.CENTER);
        add(lblAttempts);

        btnReset = new JButton("Reset Game");
        btnReset.addActionListener(e -> resetGame());
        add(btnReset);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(txtGuess.getText());
            attempts++;
            lblAttempts.setText("Attempts: " + attempts);

            if (guess < number) {
                lblResult.setText("Too Low!");
            } else if (guess > number) {
                lblResult.setText("Too High!");
            } else {
                lblResult.setText("Correct! You Win!");
            }
        } catch (NumberFormatException ex) {
            lblResult.setText("Enter a valid number.");
        }
        txtGuess.setText("");
    }

    private void resetGame() {
        number = rand.nextInt(100) + 1;
        attempts = 0;
        lblAttempts.setText("Attempts: 0");
        lblResult.setText(" ");
        txtGuess.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGuessGame().setVisible(true));
    }
}

