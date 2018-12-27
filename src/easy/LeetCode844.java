package easy;

/**
 * 844. Backspace String Compare
 * .
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * .
 * Example 1:
 * .
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * .
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * .
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * .
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 */
public class LeetCode844 {

    public static boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }

    private static String getString(String s) {
        int n = s.length(), count = 0;
        String res = "";
        for (int i = n-1; i >=0 ; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                count++;
            }else {
                if (count > 0) {
                    count--;
                }else {
                    res += c;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }
}
