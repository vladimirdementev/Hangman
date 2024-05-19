package org.mygames.app.hangman.game.menu;


import org.mygames.app.hangman.game.printer.Printer;
import org.mygames.app.hangman.game.reader.Reader;

public class Menu {
    public Boolean newGame() {
        Boolean result = null;
        while (result == null) {
            Printer.print("Начать новую игру?(Y/y - да, N/n - нет)");
            result = checkUserResponse(getUserResponse());
        }
        return result;
    }

    private Boolean checkUserResponse(String userResponse) {
        Boolean result = null;
        switch (userResponse) {
            case "y":
                result = true;
                break;
            case "n" :
                result = false;
                break;
            default:
                Printer.print("Ответ должен содержать символ y(да) или n(нет) латинского алфавита в верхнем или нижнем регистре");
                break;
        }
        return result;
    }

    private String getUserResponse() {
        return Reader.read();
    }
}
