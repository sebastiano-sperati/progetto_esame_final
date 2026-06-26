package it.unicam.cs.mpgc.rpg129546.Ui;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * punto di ingresso dell'applicazione JavaFX.
 * la classe inizializza la finestra principale
 * e avvia la prima schermata del gioco.
 */
public class MainApp extends Application {
    /**
     * inizializza lo Stage principale dell'applicazione,
     * imposta le dimensioni iniziali della finestra
     * e visualizza il menu principale.
     * @param stage finestra principale dell'applicazione
     */
    @Override
    public void start(Stage stage) {
        SceneManager.setStage(stage);
        stage.setWidth(1280);
        stage.setHeight(702);
        SceneManager.showMenu();
    }

    public static void main(String[] args) {
        launch();
    }
}