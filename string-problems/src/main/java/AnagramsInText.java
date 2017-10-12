import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by patrycja.lisowska on 10.10.2017.
 * <p>
 * Given a smaller string s and a bigger string b, design an algorithm to find all permutations
 * of the shorter string within the longer one. Print the location of each permutation.
 * <p>
 * Other description: find all anagrams of string s in given text and return their location.
 * <p>
 * Note: there's a O(n) algorithms for this problem, where n = b.length
 */
public class AnagramsInText {

    private static final int MAX = 256;

    public List<Integer> solution(String text, String s) {

        if (text == null || s == null || text.length() < s.length()) {
            return Collections.emptyList();
        }

        char[] countText = new char[MAX];
        char[] countString = new char[MAX];

        // prepare analysis of s.len first characters in text
        for (int i = 0; i < s.length(); i++) {
            countText[text.charAt(i)]++;
            countString[s.charAt(i)]++;
        }

        List<Integer> result = new ArrayList<>();
        // look at 'windows' of length == s.len in text:
        // - check if current window has the same count of characters as string s
        // - move on to next window and modify character counts by
        //   removing first character from previous window and adding new character
        //   (remove first left, add next right)
        for (int i = s.length(); i < text.length(); i++) {
            if (isCharacterCountEqual(countText, countString)) {
                result.add(i - s.length());
            }

            countText[text.charAt(i)]++;
            countText[text.charAt(i - s.length())]--;
        }

        if (isCharacterCountEqual(countText, countString)) {
            result.add(text.length() - s.length());
        }

        return result;
    }

    private boolean isCharacterCountEqual(char[] array1, char[] array2) {
        for (int i = 0; i < MAX; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

}
