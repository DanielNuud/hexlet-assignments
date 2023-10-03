package exercise;

import java.util.ArrayList;

// BEGIN
public class App {

    public static boolean scrabble(String symbols, String word) {

        String newSymbols = symbols.toLowerCase();
        String newWord = word.toLowerCase();

        ArrayList<Character> symbolsList = new ArrayList<>();
        for (char c : newSymbols.toCharArray()) {
            symbolsList.add(c);
        }

        for (char a: newWord.toCharArray()) {
            if (symbolsList.contains(a)) {
                symbolsList.remove(Character.valueOf(a));
            } else {
                return false;
            }
        }
        return true;

    }
}
//END
