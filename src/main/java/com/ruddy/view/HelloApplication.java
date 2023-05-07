package com.ruddy.view;

import com.ruddy.game.PreparationForGame;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloApplication extends Application implements Initializable {

    private static Stage stage;
    @FXML
    private Label resultGame;
    private static String message = "Do you wanna GAME?";

    public static void main(String[] args) {
        launch();
    }

    public static void continueGame(String resultGame) throws IOException {
         message = resultGame + "/n do you want continue?";
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Game menu");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void startGame() throws Exception {
        stage.close();
        new PreparationForGame().start();
    }

    @FXML
    protected void onExitButtonClick() {
        stage.close();
    }

    @Override
    public void start(Stage firstStage) throws IOException {
        stage = firstStage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Word Game!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resultGame.setText(message);
    }
}