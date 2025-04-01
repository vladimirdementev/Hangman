package core.Validator;

import java.util.Set;

public class HangmanGuessValidator implements Validator<Character> {
    private final Set<Character> guessedCharacters;

    public HangmanGuessValidator(Set<Character> guessedCharacters) {
        this.guessedCharacters = guessedCharacters;
    }

    private Boolean hasGuessed(char character, Set<Character> guessedCharacters) {
        return guessedCharacters.contains(character);
    }

    private boolean isCyrillicCharacter(char character) {
        return Character.UnicodeBlock.of(character).equals(Character.UnicodeBlock.CYRILLIC);
    }

    @Override
    public Boolean validate(Character character) {
        return Character.isLetter(character) && !hasGuessed(character, guessedCharacters) && isCyrillicCharacter(character);
    }
}
