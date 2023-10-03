package exercise;

import java.util.ArrayList;

// BEGIN
public class App {

    public static boolean scrabble(String symbols, String word) {

        ArrayList<Character> symbolsList = new ArrayList<>();
        for (char c : symbols.toCharArray()) {
            symbolsList.add(c);
        }

        for (char a: word.toCharArray()) {
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
