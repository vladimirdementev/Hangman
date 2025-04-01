package core.User;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


public class Player implements User {
    private final String name;
    private int remainingAttempts;
    private final Set<Character> guessedCharacters;

    public Player(String name, int remainingAttempts) {
        this.name = name;
        this.remainingAttempts = remainingAttempts;
        this.guessedCharacters = new HashSet<>();
    }

    public Set<Character> getGuessedCharacters() {
        return guessedCharacters;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void makeGuess(char character) {

    }

    @Override
    public boolean hasAttemptsLeft() {
        return remainingAttempts > 0;
    }

    @Override
    public void decreaseRemainingAttempts() {
        remainingAttempts--;
    }

    @Override
    public void addGuessedCharacter(char character) {
        guessedCharacters.add(character);
    }

    @Override
    public char getNextGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву: ");
        String input = scanner.nextLine().toUpperCase();

        if (input.length() != 1) {
            System.out.println("Пожалуйста, введите одну букву");
            return getNextGuess();
        }

        char guess = input.charAt(0);
        if (!isValidGuess(guess)) {
            System.out.println("Вы уже пробовали эту букву или она некорректна");
            return getNextGuess();
        }

        return guess;
    }
}
