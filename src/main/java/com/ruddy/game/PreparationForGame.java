package com.ruddy.game;

import java.util.Map;

public class PreparationForGame {

    public void start() throws Exception {
        Map<String, String> dictionary = new Dictionary().getDictionary();
        WordForGame wordForGame = new WordForGame(dictionary);
        Player player = new Player(wordForGame);
        Engine.show(player);
    }
}
