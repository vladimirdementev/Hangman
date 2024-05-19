package org.mygames.app.hangman.game.generator;

import java.io.IOException;
import java.io.RandomAccessFile;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class WordGenerator {
    private final String fileName;
    public WordGenerator(String fileName) {
        this.fileName = fileName;
    }

    public String generateWord() {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            int fileSize = (int) raf.length();
            raf.seek(getRandomPositionCursor(fileSize)); //перемещаем «курсор»
            raf.readLine();
            String line = raf.readLine();
            if (line != null) {//
                return new String(line.getBytes(ISO_8859_1), UTF_8);
            } else {
                return generateWord();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int getRandomPositionCursor(int maxSizeFile) {
        return (int) (Math.random() * maxSizeFile);
    }

}





