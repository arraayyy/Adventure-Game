package package01;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window;
    JPanel titlenamePanel, startButtonPanel,mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpNumLabel, weaponLabel, weaponName;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 69);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);

    public void createUI(Game.choiceHandler cHandler) {

        // WINDOW
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        // TITLE SCREEN
        titlenamePanel = new JPanel();
        titlenamePanel.setBounds(100, 100, 600, 150);
        titlenamePanel.setBackground(Color.black);

        titleNameLabel = new JLabel("<html>ADVENTURE<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GAME</html>\", SwingConstants.CENTER");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        titlenamePanel.add(titleNameLabel);

        // START BUTTON
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");

        startButtonPanel.add(startButton);

        window.add(titlenamePanel);
        window.add(startButtonPanel);

        // GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("bla bla bla bla");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtonPanel);

            // CHOICE 1
        choice1 = new JButton("Option 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");

            // CHOICE 2
        choice2 = new JButton("Option 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");

            // CHOICE 3
        choice3 = new JButton("Option 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");


            // CHOICE 4
        choice4 = new JButton("Option 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");

            // PLAYER
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        window.add(playerPanel);

            // HP
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);

            // HP NUMBER
        hpNumLabel = new JLabel();
        hpNumLabel.setFont(normalFont);
        hpNumLabel.setForeground(Color.white);

            // WEAPON
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);

            // WEAPON NUMBER
        weaponName = new JLabel();
        weaponName.setFont(normalFont);
        weaponName.setForeground(Color.white);

        playerPanel.add(hpLabel);
        playerPanel.add(hpNumLabel);
        playerPanel.add(weaponLabel);
        playerPanel.add(weaponName);

        window.setVisible(true);
    }
}
