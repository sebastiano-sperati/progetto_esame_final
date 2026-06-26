package it.unicam.cs.mpgc.rpg129546.Ui;

import it.unicam.cs.mpgc.rpg129546.Ui.Controller.RewardController;
import it.unicam.cs.mpgc.rpg129546.Ui.Controller.ShopController;
import it.unicam.cs.mpgc.rpg129546.Ui.Controller.BattleController;
import it.unicam.cs.mpgc.rpg129546.Game.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * gestisce il cambio delle schermate dell'applicazione.
 * la classe centralizza il caricamento dei file FXML,
 * la creazione delle Scene JavaFX e l'inizializzazione
 * dei rispettivi controller.
 * tutte le transizioni tra le schermate del gioco
 * vengono effettuate attraverso questa classe.
 */
public class SceneManager {

    private static Stage stage;
    /**
     * imposta lo Stage principale dell'applicazione.
     * lo Stage viene successivamente riutilizzato
     * per visualizzare tutte le schermate del gioco.
     * @param stage finestra principale dell'applicazione
     */
    public static void setStage(Stage stage) {
        SceneManager.stage = stage;
    }

    /**
     * carica e visualizza il menu principale
     */
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

    /**
     * carica la schermata di battaglia, inizializzando
     * il controller con la partita corrente
     * @param game partita corrente
     */
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
    /**
     * arica la schermata delle ricompense
     * al termine della battaglia.
     * il controller riceve la partita corrente
     * e le ricompense ottenute.
     * @param game partita corrente
     */
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

    /**
     * visualizza la schermata finale del gioco
     */
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
    /**
     * carica la schermata dello shop.
     * il controller viene inizializzato con
     * la partita corrente.
     * @param game partita corrente
     */
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