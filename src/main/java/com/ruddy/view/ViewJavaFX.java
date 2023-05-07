package com.ruddy.view;


import com.ruddy.game.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ViewJavaFX implements Initializable {
    private static final Stage stage = new Stage();
    @FXML
    private ImageView imgHangman;
    @FXML
    private Label wordValueLabel;
    @FXML
    private Label playerChoiceLabel;
    @FXML
    private Label hideWordLabel;
    @FXML
    private TextField playerAnswerLabel;
    private static String wordValue;
    private static String hideWord;
    private static String playerChoice;
    private static Character playerAnswer;
    private static Image hangman;

    public Character onViewJavaFX(Player player) throws Exception {
        wordValue = player.getWordValue();
        hideWord = player.getHideWord();
        playerChoice = player.getPlayerChoices();
        showImage(player.getMistakes());
        start();
        return playerAnswer;
    }

    @FXML
    private void playerChoice() {
        String tempPlayerAnswer = playerAnswerLabel.getCharacters().toString();
        if (tempPlayerAnswer.length() == 1
                && Character.isLetter(tempPlayerAnswer.charAt(0))
                && !playerChoice.contains(tempPlayerAnswer)) {
            playerAnswer = tempPlayerAnswer.charAt(0);
            stage.close();
        }
        playerAnswerLabel.setText("Only one letter");
    }

    private void showImage(int mistakes) {
        switch (mistakes) {
            case 1 -> hangman = new Image("/img/hangman1.png");
            case 2 -> hangman = new Image("/img/hangman2.png");
            case 3 -> hangman = new Image("/img/hangman3.png");
            case 4 -> hangman = new Image("/img/hangman4.png");
            case 5 -> hangman = new Image("/img/hangman5.png");
            case 6 -> hangman = new Image("/img/hangman6.png");
            default -> hangman = new Image("/img/hangman0.png");
        }

    }

    public void start() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ViewJavaFX.class.getResource("/game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setOnCloseRequest(event -> System.exit(0));
        stage.alwaysOnTopProperty();
        stage.setScene(scene);
        stage.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wordValueLabel.setText(wordValue);
        hideWordLabel.setText(hideWord);
        playerChoiceLabel.setText(playerChoice);
        imgHangman.setImage(hangman);
    }

}
