package package01;

import package02.*;

public class Plot {

    Game game;
    UI ui;
    Visibility v;
    Player player = new Player();
    Monster monster = new Monster();

    int silverRing;

    public Plot(Game g, UI userInterface, Visibility vm) {

        game = g;
        ui = userInterface;
        v = vm;
    }

    public void defaultSetup() {

        // PLAYER HP
        player.hp = 15;
        ui.hpNumLabel.setText("" + player.hp);

        // PLAYER WEAPON
        player.currentWeap = new weaponKnife();
        ui.weaponName.setText(player.currentWeap.name);

        silverRing = 0;
    }

    public void Position(String pos){

        switch(pos) {
            case "townGate": townGate(); break;
            case "talkGuard": talkGuard(); break;
            case "attackGuard": attackGuard(); break;
            case "crossRoad": crossRoad(); break;
            case "exit": exit(); break;
            case "north": north(); break;
            case "east": east(); break;
            case "west": west(); break;
            case "fight": fight(); break;
            case "ending": ending(); break;
            case "toTitle": toTitle(); break;
            case "playerAtk": playerAtk(); break;
            case "monsterAtk": monsterAtk(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "letMeIn": letMeIn(); break;
            case "run": run(); break;
        }
    }

    public void townGate() {

        ui.mainTextArea.setText("You find yourself in the front gate of a town.\nA guard is standing in front of you.");

        ui.choice1.setText("Talk to the guard");
        ui.choice2.setText("Attack the guard");
        ui.choice3.setText("Leave");
        ui.choice4.setText("Exit");

        game.pos1 = "talkGuard";
        game.pos2 = "attackGuard";
        game.pos3 = "crossRoad";
        game.pos4 = "exit";

    }

    public void exit() {
        System.exit(0);
    }

    public void talkGuard() {

        ui.mainTextArea.setText("Guard: Hello stranger. I have never seen your face.\n I'm sorry we cannot let a stranger " +
                "enter our town");

        if(silverRing == 0) {

            ui.choice1.setText("Go Back");
            ui.choice2.setText("Let me in!");
            ui.choice3.setText("-");
            ui.choice4.setText("-");

            game.pos1 = "townGate";
            game.pos2 = "letMeIn";
            game.pos3 = "";
            game.pos4 = "";
        } else if(silverRing == 1) {
            ending();
        }
    }

    public void letMeIn() {

        ui.mainTextArea.setText("I said you cannot enter!\n" +
                "The guard hits you\n\n" +
                "(Damage: 3)");

        player.hp -= 3;
        ui.hpNumLabel.setText("" + player.hp);

        ui.choice1.setText("Run");
        ui.choice2.setText("-");
        ui.choice3.setText("-");
        ui.choice4.setText("-");

        game.pos1 = "run";
        game.pos2 = "";
        game.pos3 = "";
        game.pos4 = "";
    }

    public void run() {

        ui.mainTextArea.setText("You are at a crossroad");

        ui.choice1.setText("Go north");
        ui.choice2.setText("Go east");
        ui.choice3.setText("Go south");
        ui.choice4.setText("Go west");

        game.pos1 = "north";
        game.pos2 = "east";
        game.pos3 = "townGate";
        game.pos4 = "west";
    }

    public void attackGuard() {

        ui.mainTextArea.setText("You wanna die?!\n\n" +
                "The guard fought back and hit you\n\n" +
                "(Damage: 5)");

        player.hp = player.hp - 3;
        ui.hpNumLabel.setText("" + player.hp);

        ui.choice1.setText("Run");
        ui.choice2.setText("-");
        ui.choice3.setText("-");
        ui.choice4.setText("-");

        game.pos1 = "townGate";
        game.pos2 = "letMeIn";
        game.pos3 = "";
        game.pos4 = "";
    }

    public void crossRoad() {

        ui.mainTextArea.setText("You are at a crossroad.\n" +
                "If you go south, you will go back to the town");

        ui.choice1.setText("Go north");
        ui.choice2.setText("Go east");
        ui.choice3.setText("Go south");
        ui.choice4.setText("Go west");

        game.pos1 = "north";
        game.pos2 = "east";
        game.pos3 = "townGate";
        game.pos4 = "west";

    }

    public void north() {

        ui.mainTextArea.setText("There is a river. Drink the water and rest\n\n " +
                "(HP: + 4)");

        player.hp += 4;
        ui.hpNumLabel.setText("" + player.hp);

        ui.choice1.setText("Go south");
        ui.choice2.setText("-");
        ui.choice3.setText("-");
        ui.choice4.setText("-");

        game.pos1 = "crossRoad";
        game.pos2 = "";
        game.pos3 = "";
        game.pos4 = "";
    }

    public void east() {

        ui.mainTextArea.setText("You walked into a cave and found a Sword.\n\n" +
                        "(You obtained a Sword)");

        player.currentWeap = new weaponSword();
        ui.weaponName.setText(player.currentWeap.name);

        ui.choice1.setText("Go west");
        ui.choice2.setText("-");
        ui.choice3.setText("-");
        ui.choice4.setText("-");

        game.pos1 = "crossRoad";
        game.pos2 = "";
        game.pos3 = "";
        game.pos4 = "";
    }

    public void west() {

        int i = new java.util.Random().nextInt(100) + 1;

        if(i < 60) {
            monster = new monsterGoblin();
        } else {
            monster = new monsterBeast();
        }

        ui.mainTextArea.setText("You encountered a " + monster.name + "!");

        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("-");
        ui.choice4.setText("-");

        game.pos1 = "fight";
        game.pos2 = "crossRoad";
        game.pos3 = "";
        game.pos4 = "";
    }

    public void fight() {

        ui.mainTextArea.setText(monster.name + ": " +  monster.hp + "\n\nWhat do you want to do?");

        ui.choice1.setText("Attack");
        ui.choice2.setText("Run");
        ui.choice3.setText("-");
        ui.choice4.setText("-");

        game.pos1 = "playerAtk";
        game.pos2 = "crossRoad";
        game.pos3 = "";
        game.pos4 = "";
    }

    public void playerAtk() {

        int playerDmg = new java.util.Random().nextInt(player.currentWeap.dmg);

        ui.mainTextArea.setText("You attacked the " + monster.name +
                "\n\n(Damage: " + playerDmg + ")");

        monster.hp -= playerDmg;

        ui.choice1.setText("CONTINUE");
        ui.choice2.setText("-");
        ui.choice3.setText("-");
        ui.choice4.setText("-");

        if(monster.hp > 0) {
            game.pos1 = "monsterAtk";
            game.pos2 = "";
            game.pos3 = "";
            game.pos4 = "";
        } else {
            game.pos1 = "win";
            game.pos2 = "";
            game.pos3 = "";
            game.pos4 = "";
        }
    }

    public void monsterAtk() {

        int monsterDmg = new java.util.Random().nextInt(monster.attack);

        ui.mainTextArea.setText(monster.atkMes + "(Damage: " + monsterDmg + ")");

        player.hp -= monsterDmg;
        ui.hpNumLabel.setText("" + player.hp);

        ui.choice1.setText("CONTINUE");
        ui.choice2.setText("-");
        ui.choice3.setText("-");
        ui.choice4.setText("-");

        if(player.hp > 0) {
            game.pos1 = "fight";
            game.pos2 = "";
            game.pos3 = "";
            game.pos4 = "";
        } else if(player.hp < 1) {
            game.pos1 = "lose";
            game.pos2 = "";
            game.pos3 = "";
            game.pos4 = "";
        }

    }

    public void win() {

        ui.mainTextArea.setText("You have defeated the " + monster.name + "!\n" +
                "The " + monster.name + "dropped a rare item\n\n" +
                "You obtained a Silver Ring");

        silverRing = 1;

        ui.choice1.setText("CONTINUE");
        ui.choice2.setText("-");
        ui.choice3.setText("-");
        ui.choice4.setText("-");

        game.pos1 = "crossRoad";
        game.pos2 = "";
        game.pos3 = "";
        game.pos4 = "";
    }

    public void lose() {

        ui.mainTextArea.setText(" \n\n\n                                   You died!\n\n\n" +
                "                               GAME OVER");

        ui.choice1.setText("CONTINUE");
        ui.choice2.setText("-");
        ui.choice3.setText("-");
        ui.choice4.setText("-");


        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        game.pos1 = "toTitle";
        game.pos2 = "";
        game.pos3 = "";
        game.pos4 = "";
    }

    public void ending() {

        ui.mainTextArea.setText("\n\nGuard: I heard the news! Thank You, you are our town's hero!\n\n" +
                "\n\n                                 THE END");

        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
    }

    public void toTitle() {

        defaultSetup();
        v.showTitleScreen();
    }

}
