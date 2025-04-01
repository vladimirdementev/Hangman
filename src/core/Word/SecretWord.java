package core.Word;

import java.util.HashMap;
import java.util.Map;

public class SecretWord implements Word{

    private String word;
    private final Map<Character, Boolean> guessedState;

    public SecretWord(String word) {
        this.word = word.toUpperCase();
        guessedState = new HashMap<>();
        for (char c : word.toCharArray()) {
            guessedState.put(c, false);
        }
    }

    public String getWord() {
        return word;
    }

    public Map<Character, Boolean> getGuessedState() {
        return guessedState;
    }

    @Override
    public boolean checkCharacter(char character) {
        if (guessedState.containsKey(character)) {
            guessedState.put(character, true);
            return true;
        }
        return false;
    }

    @Override
    public boolean isGuessed() {
        return guessedState.values().stream().allMatch(Boolean::booleanValue);
    }

    @Override
    public String getCurrentState() {
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (guessedState.containsKey(c)) {
                result.append(c);
            } else {
                result.append('*');
            }
        }
        return result.toString();
    }

    @Override
    public void setWord(String newWord) {
        word = newWord.toUpperCase();
        guessedState.clear();
    }
}
