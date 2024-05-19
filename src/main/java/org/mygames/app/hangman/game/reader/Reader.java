package org.mygames.app.hangman.game.reader;

import java.util.Scanner;

public class Reader {
    static Scanner scanner = new Scanner(System.in);
    public static String read() {
        return scanner.next().toLowerCase().substring(0,1);
    }
}
