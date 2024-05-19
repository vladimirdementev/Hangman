package org.mygames.app.hangman.game.hangmanpicture;

public class HangmanPicture {

    public static String generatePicture(int countError) {
        return  "╔ ═ ═ ═ ═ ═ ═ ═\n" +
                "║" + (countError > 0 ? "           │" : "") + "\n" +
                "║" + (countError > 1 ? "           ◯" : "") + "\n" +
                "║" + (countError > 2 ? "          /" : "") + (countError > 3 ? "│" : "") + (countError > 4 ? "\\" : "") + "\n" +
                "║" + (countError > 5 ? "          /" : "") + (countError > 6 ? " \\" : "") + "\n" +
                "║" + "\n" +
                "║" + "\n" +
                "╚═ ═ ═ ═ ═ ═ ═ ═ ";
    }

}
