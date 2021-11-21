package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    choiceHandler cHandler = new choiceHandler();
    UI ui = new UI();
    Visibility v = new Visibility(ui);
    Plot story = new Plot(this, ui, v);

    String pos1, pos2, pos3, pos4;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        ui.createUI(cHandler);
        v.showTitleScreen();
        story.defaultSetup();
    }

    public class choiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String playerChoice = event.getActionCommand();

            switch(playerChoice) {

                case "start":
                    v.TitletoTown();
                    story.townGate();
                    break;

                case "c1":
                    story.Position(pos1);
                    break;

                case "c2":
                    story.Position(pos2);
                    break;

                case "c3":
                    story.Position(pos3);
                    break;

                case "c4":
                    story.Position(pos4);
                    break;
            }
        }
    }
}

