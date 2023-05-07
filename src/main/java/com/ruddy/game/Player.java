package com.ruddy.game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Character> playerCr;
    private final String wordGame;
    private final String wordValue;
    private String hideWord;
     private int mistakes;

    public Player(WordForGame wordForGame) {
        this.wordGame = wordForGame.getWord();
        this.wordValue = wordForGame.getWordValue();
        this.mistakes = 0;
        this.playerCr = new ArrayList<>();
        this.hideWord = null;

    }

    public void changeHideWord() {
        StringBuilder result = new StringBuilder();
        for (char ch : wordGame.toCharArray()) {
            if (playerCr.contains(ch)) {
                result.append(ch);
            } else {
                result.append('*');
            }
        }
        hideWord = result.toString();
    }

    public boolean isWrong(Character chPlayer) {
        for (Character ch : wordGame.toCharArray()) {
            if (ch.equals(chPlayer)) {
                return false;
            }
        }
        return true;
    }

    public boolean isWordGuessed() {
        return !hideWord.contains("*");
    }

    public String getHideWord() {
        return hideWord;
    }

    public int getMistakes() {
        return mistakes;
    }

    public void addMistake() {
        this.mistakes += 1;
    }

    public String getWordValue() {
        return wordValue;
    }

    public String getPlayerChoices() {
        return playerCr.toString();
    }

    public void addPlayerChoice(Character ch) {
        this.playerCr.add(ch);
    }

}
