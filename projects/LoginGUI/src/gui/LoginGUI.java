package gui;

import constants.CommonConstants;

import javax.swing.*;

public class LoginGUI extends JFrame {
    public LoginGUI() {
        super(CommonConstants.APP_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        setLocationRelativeTo(null);

        addGUIComponents();
    }

    public void addGUIComponents() {
        SpringLayout springLayout = new SpringLayout();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(springLayout);

    }
}
