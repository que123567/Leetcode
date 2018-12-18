package easy;

import java.util.HashMap;

/**
 * Given two strings s and t which consist of only lowercase letters.
 * .
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * .
 * Find the letter that was added in t.
 * .
 * Example:
 * .
 * Input:
 * s = "abcd"
 * t = "abcde"
 * .
 * Output:
 * e
 * .
 * Explanation:
 * 'e' is the letter that was added.
 */

public class LeetCode389 {
    /**
     * soltion_1
     * beat 8.33%..
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> charNumMapS = new HashMap<>();
        HashMap<Character, Integer> charNumMapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int num = charNumMapS.getOrDefault(s.charAt(i), 0) + 1;
            charNumMapS.put(s.charAt(i), num);
        }
        for (int i = 0; i < t.length(); i++) {
            int num = charNumMapT.getOrDefault(t.charAt(i), 0) + 1;
            charNumMapT.put(t.charAt(i), num);
        }

        for (int i = 0; i < t.length(); i++) {
            int tNum = charNumMapT.getOrDefault(t.charAt(i), 0);
            int sNum = charNumMapS.getOrDefault(t.charAt(i), 0);
            System.out.println(tNum + " " + sNum);
            if (tNum != sNum) {
                return t.charAt(i);
            }
        }
        return '.';
    }

    /**
     * solution_2
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference_2(String s, String t) {
        int n = t.length();
        char c = t.charAt(n - 1);
        for (int i = 0; i < n - 1; ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

    /**
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference_3(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
        }
        return c;
    }

    /**
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference_4(String s, String t) {
        int[] it = new int[26];

        for (char cs : s.toCharArray()) {
            it[cs - 'a']++;
        }

        for (char ct : t.toCharArray()) {
            it[ct - 'a']--;
            if (it[ct - 'a'] < 0) {
                return ct;
            }
        }
        return '0';
    }

    public static char findTheDifference_5(String s, String t) {
        int[] it = new int[26];

        for (char c : s.toCharArray()) {
            it[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            it[c - 'a']--;
            if (it[c - 'a'] < 0) {
                return c;
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        String a = "ymbgaraibkfmvocpizdydugvalagaivdbfsfbepeyccqfepzvtpyxtbadkhmwmoswrcxnargtlswqemafandgkmydtimuzvjwxvlfwlhvkrgcsithaqlcvrihrwqkpjdhgfgreqoxzfvhjzojhghfwbvpfzectwwhexthbsndovxejsntmjihchaotbgcysfdaojkjldprwyrnischrgmtvjcorypvopfmegizfkvudubnejzfqffvgdoxohuinkyygbdzmshvyqyhsozwvlhevfepdvafgkqpkmcsikfyxczcovrmwqxxbnhfzcjjcpgzjjfateajnnvlbwhyppdleahgaypxidkpwmfqwqyofwdqgxhjaxvyrzupfwesmxbjszolgwqvfiozofncbohduqgiswuiyddmwlwubetyaummenkdfptjczxemryuotrrymrfdxtrebpbjtpnuhsbnovhectpjhfhahbqrfbyxggobsweefcwxpqsspyssrmdhuelkkvyjxswjwofngpwfxvknkjviiavorwyfzlnktmfwxkvwkrwdcxjfzikdyswsuxegmhtnxjraqrdchaauazfhtklxsksbhwgjphgbasfnlwqwukprgvihntsyymdrfovaszjywuqygpvjtvlsvvqbvzsmgweiayhlubnbsitvfxawhfmfiatxvqrcwjshvovxknnxnyyfexqycrlyksderlqarqhkxyaqwlwoqcribumrqjtelhwdvaiysgjlvksrfvjlcaiwrirtkkxbwgicyhvakxgdjwnwmubkiazdjkfmotglclqndqjxethoutvjchjbkoasnnfbgrnycucfpeovruguzumgmgddqwjgdvaujhyqsqtoexmnfuluaqbxoofvotvfoiexbnprrxptchmlctzgqtkivsilwgwgvpidpvasurraqfkcmxhdapjrlrnkbklwkrvoaziznlpor";
        String b = "qhxepbshlrhoecdaodgpousbzfcqjxulatciapuftffahhlmxbufgjuxstfjvljybfxnenlacmjqoymvamphpxnolwijwcecgwbcjhgdybfffwoygikvoecdggplfohemfypxfsvdrseyhmvkoovxhdvoavsqqbrsqrkqhbtmgwaurgisloqjixfwfvwtszcxwktkwesaxsmhsvlitegrlzkvfqoiiwxbzskzoewbkxtphapavbyvhzvgrrfriddnsrftfowhdanvhjvurhljmpxvpddxmzfgwwpkjrfgqptrmumoemhfpojnxzwlrxkcafvbhlwrapubhveattfifsmiounhqusvhywnxhwrgamgnesxmzliyzisqrwvkiyderyotxhwspqrrkeczjysfujvovsfcfouykcqyjoobfdgnlswfzjmyucaxuaslzwfnetekymrwbvponiaojdqnbmboldvvitamntwnyaeppjaohwkrisrlrgwcjqqgxeqerjrbapfzurcwxhcwzugcgnirkkrxdthtbmdqgvqxilllrsbwjhwqszrjtzyetwubdrlyakzxcveufvhqugyawvkivwonvmrgnchkzdysngqdibhkyboyftxcvvjoggecjsajbuqkjjxfvynrjsnvtfvgpgveycxidhhfauvjovmnbqgoxsafknluyimkczykwdgvqwlvvgdmufxdypwnajkncoynqticfetcdafvtqszuwfmrdggifokwmkgzuxnhncmnsstffqpqbplypapctctfhqpihavligbrutxmmygiyaklqtakdidvnvrjfteazeqmbgklrgrorudayokxptswwkcircwuhcavhdparjfkjypkyxhbgwxbkvpvrtzjaetahmxevmkhdfyidhrdeejapfbafwmdqjqszwnwzgclitdhlnkaiyldwkwwzvhyorgbysyjbxsspnjdewjxbhpsvj";
        String c = "aadd";
        String d = "aaddm";
        System.out.println(findTheDifference_5(a, b));

    }

}

