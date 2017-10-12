/**
 * Created by patrycja.lisowska on 11.10.2017.
 */
public class UniqueCharactersInString {

    private static int MAX = 256; // assume extended ASCII / ISO

    public boolean solution(String s) {
        boolean[] chars = new boolean[MAX];
        for (char c : s.toCharArray()) {
            if (chars[c]) {
                return false;
            }
            chars[c] = true;
        }
        return true;
    }

    public boolean solutionNoAdditionalStructure(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (i == j) continue;
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean solutionUsingBitManipulation(String s) {
        // warning - this will work only for strings built from a-z characters
        int integer = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if ((integer & (1 << (c - 'a'))) == 1) {
                return false;
            }
            integer |= 1 << i;
        }
        return true;
    }
}
