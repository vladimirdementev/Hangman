package org.mygames;

import org.mygames.app.hangman.game.Game;

public class Main {
    public static void main(String[] args) {
        Game hangman = new Game();
        hangman.start();
    }
}