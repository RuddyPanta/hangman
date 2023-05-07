package com.ruddy.game;

import com.ruddy.view.HelloApplication;
import com.ruddy.view.ViewJavaFX;

public class Engine {


    public static void show(Player player) throws Exception {
        while (player.getMistakes() < 6) {
            player.changeHideWord();
            Character choicesPlayer = new ViewJavaFX().onViewJavaFX(player);
            player.addPlayerChoice(choicesPlayer);
            player.changeHideWord();
            if (player.isWordGuessed()) {
                HelloApplication.continueGame("Your are WIN!!!!");
                break;
            }
            if (player.isWrong(choicesPlayer)) {
                player.addMistake();
            }
        }
        if (player.getMistakes() >= 6) {
            HelloApplication.continueGame("Your are LOST!");
        }
    }

}
