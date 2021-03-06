package easy;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * .
 * Given two integers x and y, calculate the Hamming distance.
 * .
 * Note:
 * 0 ≤ x, y < 231.
 * .
 * Example:
 * .
 * Input: x = 1, y = 4
 * .
 * Output: 2
 * .
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * .
 * The above arrows point to positions where the corresponding bits are different.
 */
public class LeetCode461 {
    static class Solution {//AC

        public static int hammingDistance(int x, int y) {
            String res = Integer.toBinaryString(x ^ y);
            res = res.replace("0", "").trim();
            return res.length();
        }

        public static int hammingDictance_outofrange(int x, int y) {//越界错，最后改为直接把值存入String 如上⬆️
            String binaryX = Integer.toBinaryString(x);//二进制x
            String binaryY = Integer.toBinaryString(y);

            int tmpRes = Integer.valueOf(binaryX) ^ Integer.valueOf(binaryY);
            String finalRes = Integer.toBinaryString(tmpRes);
            finalRes = finalRes.replace("0", "");

            return finalRes.length();
        }

        public static void main(String[] args) {
            System.out.println(hammingDistance(1000000000, 5));
        }
    }
}
