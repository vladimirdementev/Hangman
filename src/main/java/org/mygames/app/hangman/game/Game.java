package org.mygames.app.hangman.game;

import org.mygames.app.hangman.game.hangmanpicture.HangmanPicture;
import org.mygames.app.hangman.game.menu.Menu;
import org.mygames.app.hangman.game.generator.WordGenerator;
import org.mygames.app.hangman.game.printer.Printer;
import org.mygames.app.hangman.game.reader.Reader;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private static final int maxError = 7;
    Set<String> poolUserResponse = new HashSet<>();

    public void start() {
        Menu menu = new Menu();
        WordGenerator wordGenerator = new WordGenerator("src/main/resources/Words.txt");
        while (menu.newGame()) {
            /*генерируем результат*/
            String result = wordGenerator.generateWord();
            /*инициализация счетчика ошибок*/
            int cntError = 0;
            /*генерируем секретное слово для отображения пользователю*/
            String secretResult = generateSecretWord(result);
            /*запускаем цикл до того момента пока секретное слово не равно результату и счетчик ошибок меньше максимального кол=ва ошибок*/
            while (!secretResult.equals(result) && cntError < maxError) {
                /*просим пользователя ввести букву*/
                Printer.print("Введите букву");
                String userResponse = getUserResponse();
                if (checkCyrillic(userResponse) && !checkPoolResponse(userResponse)) {
                    /*проверяем вхождение введенного символа в результат*/
                    if (!checkUserResponse(userResponse, result)) {
                        /*если не входит инкрементируем счетчик ошибок*/
                        cntError++;
                    } else {
                        /*если входит, то подставляем введенный символ в секретное слово*/
                        secretResult = modifySecretWord(secretResult, result, userResponse);
                    }
                    poolUserResponse.add(userResponse);
                }
                /*принтим виселицу и прочую информацию*/
                Printer.print(HangmanPicture.generatePicture(cntError));
                Printer.print("Отгадываемое слово:" + secretResult);
                Printer.print("Количество ошибок: " + cntError);
            }
            if (cntError < maxError) {
                Printer.print("Вы победили");
            }
            if (cntError >= maxError) {
                Printer.print("Вы проиграли");
            }
            Printer.print("Загаданное слово: " + result);
            poolUserResponse.clear();
        }
    }

    private String getUserResponse() {
        return Reader.read();
    }

    private Boolean checkUserResponse(String userResponse, String resultWord) {
        return resultWord.contains(userResponse) && checkCyrillic(userResponse) && !checkPoolResponse(userResponse);
    }

    private Boolean checkCyrillic(String userResponse) {
        if (!Character.UnicodeBlock.of(userResponse.charAt(0)).equals(Character.UnicodeBlock.CYRILLIC)) {
            Printer.print("Введенный символ «" + userResponse + "» должен быть буквой и принадлежать к русскому алфавиту");
        }
        return Character.UnicodeBlock.of(userResponse.charAt(0)).equals(Character.UnicodeBlock.CYRILLIC);
    }

    private Boolean checkPoolResponse(String userResponse) {
        if (poolUserResponse.contains(userResponse)) {
            Printer.print("Введенная буква «" + userResponse + "» уже была введена, введите другую букву");
        }
        return poolUserResponse.contains(userResponse);
    }

    private String modifySecretWord(String secretResult, String result, String userResponse) {
        int index = result.indexOf(userResponse);
        while (index >= 0) {
            secretResult = secretResult.substring(0, index) + userResponse + secretResult.substring(index + 1);
            index = result.indexOf(userResponse, index + 1);
        }
        return secretResult;
    }

    private String generateSecretWord(String result) {
        return result.replaceAll(".", "*");
    }


}
