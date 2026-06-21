package it.unicam.cs.mpgc.rpg129546.Ui.Controller;

import it.unicam.cs.mpgc.rpg129546.Game.Factory.HeroFactory;
import it.unicam.cs.mpgc.rpg129546.Game.Game;
import it.unicam.cs.mpgc.rpg129546.Persistence.Loaders.SaveLoader;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveData;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveManager;
import it.unicam.cs.mpgc.rpg129546.Ui.SceneManager;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void onNewGame() {
        Game game = new Game(HeroFactory.generate());
        game.startNewBattle();
        SceneManager.showBattle(game);
    }

    @FXML
    private void onLoadGame() {
        try {
            SaveData data = SaveManager.load();
            Game game = SaveLoader.loadGame(data);
            game.startNewBattle();
            SceneManager.showBattle(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onQuit() {
        Platform.exit();
    }
}