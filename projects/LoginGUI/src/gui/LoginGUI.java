package gui;

import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** LoginGUI, representa uma janela de interface gráfica de usuário (GUI) que serve como uma tela de login.
 * Ela é baseada na biblioteca Swing e estende a classe JFrame */
public class LoginGUI extends JFrame {
    public LoginGUI() {
        super(CommonConstants.APP_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);

        // OBS: setLocationRelativeTo(null) é chamado após setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]) pq a janela é centralizada com base no tamanho definido anteriormente.

        addGUIComponents();
    }

    public void addGUIComponents() {
        SpringLayout springLayout = new SpringLayout();

        JPanel loginPanel = new JPanel();

        loginPanel.setLayout(springLayout);

        // username

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 12));

        JTextField usernameText = new JTextField(CommonConstants.TEXTFIELD_SIZE);

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameText);

        springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 130, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, usernameLabel, 70, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, usernameText, 130, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, usernameText, 135, SpringLayout.WEST, loginPanel);

        // password

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 12));

        JPasswordField passwordText = new JPasswordField(CommonConstants.TEXTFIELD_SIZE);

        springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 160, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 70, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordText, 160, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, passwordText, 135, SpringLayout.WEST, loginPanel);


        loginPanel.add(passwordLabel);
        loginPanel.add(passwordText);

        // login button

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 15));

        springLayout.putConstraint(SpringLayout.NORTH, loginButton, 190, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, loginButton, 140, SpringLayout.WEST, loginPanel);

        loginPanel.add(loginButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usernameText.getText();
                String password = passwordText.getText();

                if(username.equals("username") && password.equals("password")) {
                    JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL!");
                } else {
                    JOptionPane.showMessageDialog(null,"LOGIN FAILED...");
                }

            }
        });

        this.getContentPane().add(loginPanel);
    }
}
