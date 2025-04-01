package core.User;

public interface User {

    String getName();

    void makeGuess(char character);

    boolean hasAttemptsLeft();

    void decreaseRemainingAttempts();

    void addGuessedCharacter(char character);

    char getNextGuess();
}
