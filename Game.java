import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Game{

    JFrame window;
    Container con;
    JPanel titlenamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titlenameLabel, hpLabel, hpLabelNum,  weaponLabel, weaponName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 69);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, bronzeRing;
    String weapon, position;
    

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler cHandler = new ChoiceHandler();

    public static void main(String args[]) {
        new Game();
    }

    public Game() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        con = window.getContentPane();

        // TITLE
        titlenamePanel = new JPanel();
        titlenamePanel.setBounds(100, 100, 600, 150);
        titlenamePanel.setBackground(Color.black);
        titlenameLabel = new JLabel("<html>ADVENTURE<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GAME</html>", SwingConstants.CENTER);
//        titlenameLabel.setHorizontalAlignment(JLabel.CENTER);
//        titlenameLabel.setVerticalAlignment(JLabel.CENTER);
        titlenameLabel.setForeground(Color.white);
        titlenameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        // BUTTON
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titlenamePanel.add(titlenameLabel);
        startButtonPanel.add(startButton);

        con.add(titlenamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen() {

        titlenamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("bla bla bla bla");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // BUTTON
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);

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



        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

        // HP
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);

        // HP NUMBER
        hpLabelNum = new JLabel();
        hpLabelNum.setFont(normalFont);
        hpLabelNum.setForeground(Color.white);

        // WEAPON
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);

        // WEAPON NUMBER
        weaponName = new JLabel();
        weaponName.setFont(normalFont);
        weaponName.setForeground(Color.white);

        playerPanel.add(hpLabel);
        playerPanel.add(hpLabelNum);
        playerPanel.add(weaponLabel);
        playerPanel.add(weaponName);

        playerSetUp();
    }

    public void playerSetUp() {
        playerHP = 20;
        monsterHP = 25;
        weapon = "Knife";

        weaponName.setText(weapon);
        hpLabelNum.setText("" + playerHP);

        townGate();
    }

    public void townGate() {
        position = "townGate";

        mainTextArea.setText("*Dizzy* Upon waking up, you remembered an\nunknown god took your sister. You ran desperately\nlooking for her.\n" +
                "\n" +
                "You find yourself in the front gate of a town.\nA guard is standing in front of you.");

        choice1.setText("Talk to the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("Exit");
    }

    // IF CHOICE 1
    public void talkGuard() {
        position = "talkGuard";

        mainTextArea.setText("Guard: Hello stranger. I have never seen your face.\n I'm sorry we cannot let a stranger " +
                "enter our town");

        choice1.setText("Go Back");
        choice2.setText("Let me in!");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void letMeIn() {
        position = "letMeIn";

        mainTextArea.setText("I said you cannot enter!\n" +
                "The guard hits you\n\n" +
                "(Damage: 3)");

        playerHP = playerHP - 3;
        hpLabelNum.setText("" + playerHP);

        choice1.setText("Run");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");

    }

    public void run() {
        position = "run";

        mainTextArea.setText("You are at the front of the town gate");

        choice1.setText("Go north");
        choice2.setText("Go east");
        choice3.setText("Go west");
        choice4.setText("-");
    }



    public void attackGuard() {
        position = "attackGuard";

        mainTextArea.setText("Guard: You wanna die?!!\n\n" +
                "The guard fought back and hit you\n\n" +
                "(Damage: 5)");

        playerHP = playerHP - 5;
        hpLabelNum.setText("" + playerHP);

        choice1.setText("Go Back");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void crossRoad() {
        position = "crossRoad";

        mainTextArea.setText("You are at a crossroad.\n" +
                "If you go south, you will go back to the town");

        choice1.setText("Go north");
        choice2.setText("Go east");
        choice3.setText("Go south");
        choice4.setText("Go west");
    }

    public void north() {
        position = "north";
        mainTextArea.setText("There is a river. Drink the water and rest\n\n " +
                "(HP: + 4)");

        playerHP += 4;
        hpLabelNum.setText("" + playerHP);

        choice1.setText("Go south");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void east() {
        position = "east";

        mainTextArea.setText("You walked into a cave and found a Sword.\n\n" +
                "(You obtained a Sword)");

        weapon = "Sword";
        weaponName.setText(weapon);

        choice1.setText("Go west");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void west() {
        position = "west";
        monsterHP = 25;

        mainTextArea.setText("You encountered a beast!");

        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void fight() {
        position = "fight";

        mainTextArea.setText("Monster HP:" + monsterHP + "\n\n" +
                "What do you want to do?");

        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void attack() {
        position = "atk";
        int playerDmg = 0;

        if(weapon.equals("Knife")) {
            playerDmg = new java.util.Random().nextInt(3);
        } else if(weapon.equals("Sword")) {
            playerDmg = new java.util.Random().nextInt(10);
        }

        mainTextArea.setText("You attacked the beast\n\n" +
                "(Damage:" + playerDmg +")");

        monsterHP -= playerDmg;

        choice1.setText("CONTINUE");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void monsterAtk() {
        position = "monsterAtk";

        int monsterDmg = 0;

        monsterDmg = new java.util.Random().nextInt(6);

        mainTextArea.setText("The beast attacked you\n\n" +
                "(Damage:" + monsterDmg  +")");

        playerHP -= monsterDmg;
        hpLabelNum.setText("" + playerHP);

        choice1.setText("CONTINUE");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void win() {
        position = "win";

        mainTextArea.setText("You won!\n\n" +
                "You obtained a Bronze Ring");

        bronzeRing = 1;

        choice1.setText("Go east");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");
    }

    public void lose() {
        position = "lose";

        mainTextArea.setText(" \n                            YOU LOST! :(\n\n" +
                "\n\n                          <GAME OVER>");

        choice1.setText("CONTINUE");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void ending() {
        position = "end";

        mainTextArea.setText("Guard: I heard the news.\n Thank You, you are our town's hero" +
                "\n\n< THE END >");

        choice1.setText("CONTINUE");
        choice2.setText("-");
        choice3.setText("-");
        choice4.setText("-");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }



    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String playerChoice = event.getActionCommand();

            switch (position) {

                // TOWN GATE CHOICE
                case "townGate":

                switch (playerChoice) {

                    // CHOICE 1
                    case "c1":
                        if(bronzeRing == 1) {
                            ending();
                        } else {
                            talkGuard();
                        }
                        break;

                    // CHOICE 2
                    case "c2":
                        attackGuard();
                        break;

                    // CHOICE 3
                    case "c3":
                        crossRoad();
                        break;

                    // CHOICE 4
                    case "c4":
                        System.exit(0);
                        break;
                }
                break;

                // TALK TO GUARD CHOICE
                case "talkGuard":
                    switch(playerChoice) {

                        case "c1":
                            townGate();
                            break;

                        case "c2":
                            letMeIn();
                            break;
                    }
                    break;

                case "letMeIn":
                   switch(playerChoice) {
                       case "c1":
                           run();
                           break;
                   }
                   break;

                case "run":
                    switch(playerChoice) {
                        case "c1":
                            north();
                            break;
                        case "c2":
                            east();
                            break;
                        case  "c3":
                            west();
                            break;
                    }
                    break;

                // ATTACK GUARD CHOICE
                case "attackGuard":
                    switch(playerChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;

                // LEAVE CHOICE
                case "crossRoad":
                    switch(playerChoice) {
                        case "c1":
                            north();
                            break;
                        case "c2":
                            east();
                            break;
                        case "c3":
                            townGate();
                            break;
                        case "c4":
                            west();
                            break;
                    }
                    break;

                case "north":
                    switch(playerChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;

                case "east":
                    switch(playerChoice) {
                        case "c1": crossRoad();
                        break;
                    }
                    break;

                case "west":
                    switch(playerChoice) {
                        case "c1":
                            fight();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;

                case "fight":
                    switch(playerChoice) {
                        case "c1":
                            attack();
                            break;

                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;

                case "atk":
                    switch(playerChoice) {
                        case "c1":
                            if(monsterHP < 1) {
                                win();
                            } else {
                                monsterAtk();
                            }
                            break;
                    }
                    break;

                case "monsterAtk":
                    switch(playerChoice) {
                        case "c1":
                            if(playerHP < 1) {
                                lose();
                            } else {
                                fight();
                                break;
                            }
                    }
                    break;

                case "win":
                    switch(playerChoice) {
                        case "c1":
                            crossRoad();
                    }
                    break;
            }

        }
    }
}
