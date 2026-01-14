package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class applicationform {
  private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                applicationform window = new applicationform();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public applicationform() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame("Sign In!");
        frame.setBounds(100, 100, 700, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // TITLE
        JLabel lblTitle = new JLabel("Sign In!");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblTitle.setBounds(250, 20, 200, 40);
        frame.getContentPane().add(lblTitle);

        // FIRST NAME
        JLabel lblFname = new JLabel("First Name");
        lblFname.setBounds(120, 80, 100, 20);
        frame.getContentPane().add(lblFname);

        JTextField txtFname = new JTextField();
        txtFname.setBounds(120, 100, 180, 25);
        frame.getContentPane().add(txtFname);

        // LAST NAME
        JLabel lblLname = new JLabel("Last Name");
        lblLname.setBounds(370, 80, 100, 20);
        frame.getContentPane().add(lblLname);

        JTextField txtLname = new JTextField();
        txtLname.setBounds(370, 100, 180, 25);
        frame.getContentPane().add(txtLname);

        // USERNAME
        JLabel lblUname = new JLabel("User Name");
        lblUname.setBounds(120, 140, 100, 20);
        frame.getContentPane().add(lblUname);

        JTextField txtUname = new JTextField();
        txtUname.setBounds(120, 160, 180, 25);
        frame.getContentPane().add(txtUname);

        // PASSWORD
        JLabel lblPass = new JLabel("Pass.");
        lblPass.setBounds(370, 140, 100, 20);
        frame.getContentPane().add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(370, 160, 180, 25);
        frame.getContentPane().add(txtPass);

        // SEX
        JLabel lblSex = new JLabel("Sex");
        lblSex.setBounds(120, 200, 50, 20);
        frame.getContentPane().add(lblSex);

        JRadioButton rdbMale = new JRadioButton("Male");
        rdbMale.setBounds(120, 220, 60, 25);

        JRadioButton rdbFemale = new JRadioButton("Female");
        rdbFemale.setBounds(180, 220, 80, 25);

        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(rdbMale);
        sexGroup.add(rdbFemale);

        frame.getContentPane().add(rdbMale);
        frame.getContentPane().add(rdbFemale);

        // AGE
        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(370, 200, 100, 20);
        frame.getContentPane().add(lblAge);

        JComboBox<String> ageBox = new JComboBox<>();
        for (int i = 1; i <= 100; i++) ageBox.addItem(String.valueOf(i));
        ageBox.setSelectedItem("11"); 
        ageBox.setBounds(370, 220, 80, 25);
        frame.getContentPane().add(ageBox);

        // SUBSCRIPTION
        JLabel lblSub = new JLabel("Subscription");
        lblSub.setBounds(120, 260, 120, 20);
        frame.getContentPane().add(lblSub);

        JRadioButton rdbFree = new JRadioButton("Free");
        rdbFree.setBounds(120, 280, 60, 25);

        JRadioButton rdbPremium = new JRadioButton("Premium");
        rdbPremium.setBounds(190, 280, 100, 25);

        ButtonGroup subGroup = new ButtonGroup();
        subGroup.add(rdbFree);
        subGroup.add(rdbPremium);

        frame.getContentPane().add(rdbFree);
        frame.getContentPane().add(rdbPremium);

        // SIGN IN BUTTON
        JButton btnSignIn = new JButton("Sign In");
        btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnSignIn.setBounds(370, 280, 120, 35);
        frame.getContentPane().add(btnSignIn);

        // ACTION
        btnSignIn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Sign-In Successful!");
        });
    }
}

