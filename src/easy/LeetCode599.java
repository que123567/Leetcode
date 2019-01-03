package easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 599. Minimum Index Sum of Two Lists
 * ,
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 * ,
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 * ,
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * Note:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */
public class LeetCode599 {
    /**
     * O(M*N)
     *
     * @param list1
     * @param list2
     * @return
     */
    public static String[] findRestaurant(String[] list1, String[] list2) {
        int minIndex = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j]) && i + j <= minIndex) {
                    if (i + j < minIndex) {
                        map.clear();
                    }
                    map.put(list1[i], i + j);
                    minIndex = i + j;
                }
            }
        }
        String[] strs = new String[map.size()];
        int i = 0;
        for (String res : map.keySet()) {
            strs[i++] = res;
        }
        return strs;
    }

    /**
     * O(M+N)
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant_v(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {
                if (i + j < minSum) {
                    res.clear();
                    minSum = i + j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }



    public static void main(String[] args) {
        String[] a = new String[]{"Shogun", "Piatti", "Burger King", "KFC"};
        String[] b = new String[]{"Piatti", "Shogun", "Hungry Hunter Steakhouse", "Shogun"};

        String[] strings = findRestaurant(a, b);
        for (String str : strings) {
            System.out.print(str + " ");
        }
    }
}
