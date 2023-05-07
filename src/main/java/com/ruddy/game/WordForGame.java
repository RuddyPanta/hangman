package com.ruddy.game;

import java.util.Map;
import java.util.Random;

public class WordForGame {
    private String word;
    private String wordValue;

    public WordForGame(Map<String, String> words) {
        randomWordForGame(words);
    }

    private void randomWordForGame(Map<String, String> words) {
        Random rnd = new Random();
        Object[] keysWords = words.keySet().toArray();
        word = (String) keysWords[rnd.nextInt(keysWords.length)];
        wordValue = words.get(word);
    }

    public String getWord() {
        return word;
    }

    public String getWordValue() {
        return wordValue;
    }
}
