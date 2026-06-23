package it.unicam.cs.mpgc.rpg129546.Ui;

import it.unicam.cs.mpgc.rpg129546.Ui.Controller.RewardController;
import it.unicam.cs.mpgc.rpg129546.Ui.Controller.ShopController;
import it.unicam.cs.mpgc.rpg129546.Ui.Controller.BattleController;
import it.unicam.cs.mpgc.rpg129546.Game.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private static Stage stage;

    public static void setStage(Stage stage) {
        SceneManager.stage = stage;
    }

    public static void showMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/Fxml/MainMenu.fxml"));

            Scene scene = new Scene(loader.load(),1280,720);
            stage.setScene(scene);
            stage.setTitle("RPG");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showBattle(Game game) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/Fxml/Battle.fxml"));

            Scene scene = new Scene(loader.load(),1280,720);

            BattleController controller = loader.getController();
            controller.setGame(game);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showReward(Game game) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/Fxml/Reward.fxml"));

            Scene scene = new Scene(loader.load(),1280,720);

            RewardController controller = loader.getController();
            controller.setGame(game, game.getLastReward().getXp(),game.getLastReward().getGold());

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showGameOver() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/Fxml/GameOver.fxml"));

            Scene scene = new Scene(loader.load(),1280,720);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showShop(Game game) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/Fxml/Shop.fxml"));

            Scene scene = new Scene(loader.load(),1280,720);

            ShopController controller = loader.getController();
            controller.setGame(game);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}