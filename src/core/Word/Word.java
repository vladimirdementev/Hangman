package core.Word;

public interface Word {

    /**
     * Проверяет, содержится ли указанный символ в слове
     * @param character проверяемый символ
     * @return true, если символ есть в слове и он еще не был угадан
     */
    boolean checkCharacter(char character);

    /**
     * Проверяет, было ли полностью угадано слово
     * @return true, если все символы слова угаданы
     */
    boolean isGuessed();

    /**
     * Возвращает текущее состояние слова (с угаданными и скрытыми символами)
     * @return строка, где угаданные символы показаны, а неизвестные заменены '*'
     */
    String getCurrentState();

    /**
     * Устанавливает новое слово для игры
     * @param newWord новое слово
     */
    void setWord(String newWord);

}
