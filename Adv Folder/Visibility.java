package package01;

public class Visibility {

    UI ui;

    public Visibility(UI userInterface) {
        ui = userInterface;
    }

    public void showTitleScreen() {

        // SHOW GAME SCREEN TITLE
        ui.titlenamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // HIDE GAME SCREEN
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void TitletoTown() {

        // HIDE GAME SCREEN TITLE
        ui.titlenamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // SHOW GAME SCREEN
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}
