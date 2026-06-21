package it.unicam.cs.mpgc.rpg129546.Ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager.setStage(stage);
        SceneManager.showMenu();
    }

    public static void main(String[] args) {
        launch();
    }
}