import java.util.Arrays;

/**
 * Created by patrycja.lisowska on 11.10.2017.
 */
public class Stuff {

    /**
     * Write a method to replace all spaces in a string with '%20: You may assume that the string
     * has sufficient space at the end to hold the additional characters, and that you are given the "true"
     * length of the string.
     */
    public void urlify(char[] s, int trueLength) {
        // TODO
    }

    /**
     * Given a string, write a function to check if it is a permutation of
     * a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
     * permutation is a rearrangement of letters. The palindrome does not need to be limited to just
     * dictionary words.
     */
    public boolean anagramOfPalindrome(String s) {
        // palindrome: even length and all letters paired, odd length and one letter single
        int max = 256; // assuming ASCII / ISO
        int[] count = new int[max];

        // count all letters
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        // consider EVEN case
        if (s.length() % 2 == 0) {
            for (int i = 0; i < max; i++) {
                if (count[i] % 2 != 0) {
                    return false;
                }
            }
            return true;
        }

        // consider ODD case
        boolean singleFound = false;
        for (int i = 0; i < max; i++) {
            if (count[i] % 2 == 1 && singleFound) {
                return false;
            } else if (count[i] % 2 == 1) {
                singleFound = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Stuff s = new Stuff();
        System.out.println(s.anagramOfPalindrome("abb"));
    }
}
