package easy;

import java.util.HashMap;

/**
 * 437. Path Sum III
 * .
 * You are given a binary tree in which each node contains an integer value.
 * .
 * Find the number of paths that sum to a given value.
 * .
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * .
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * .
 * Example:
 * .
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * .
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * .
 * Return 3. The paths that sum to 8 are:
 * .
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class LeetCode437 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;

        }
    }

    /**
     * more consice than Solution 3
     */
    static class Solution1 {
        /**
         * @param root
         * @param sum
         * @return
         */
        public int pathSum_(TreeNode root, int sum) {
            if (root == null)
                return 0;
            return pathSumFrom(root, sum) + pathSum_(root.left, sum) + pathSum_(root.right, sum);
        }

        private int pathSumFrom(TreeNode node, int sum) {
            if (node == null)
                return 0;
            return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
        }
    }

    static class Solution2 {
        /**
         * So the idea is similar as Two sum, using HashMap to store ( key : the prefix sum, value : how many ways get to this prefix sum) , and whenever reach a node, we check if prefix sum - target exists in hashmap or not, if it does, we added up the ways of prefix sum - target into res.
         * For instance : in one path we have 1,2,-1,-1,2, then the prefix sum will be: 1, 3, 2, 1, 3, let's say we want to find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2} and {2}ways.
         * I used global variable count, but obviously we can avoid global variable by passing the count from bottom up. The time complexity is O(n). This is my first post in discuss, open to any improvement or criticism. :)
         */
        public static int pathSum(TreeNode root, int sum) {
            HashMap<Integer, Integer> preSum = new HashMap<>();
            preSum.put(0, 1);
            return helper(root, 0, sum, preSum);
        }

        public static int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
            if (root == null) {
                return 0;
            }

            currSum += root.val;
            int res = preSum.getOrDefault(currSum - target, 0);
            preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

            res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
            preSum.put(currSum, preSum.get(currSum) - 1);
            return res;
        }
    }

    /**
     * Solution3
     * Each time find all the path start from current node
     * Then move start node to the child and repeat.
     * Time Complexity should be O(N^2) for the worst case and O(NlogN) for balanced binary Tree.
     */
    static class Solution3 {
        public static int pathSum(TreeNode root, int sum) {
            if (root == null)
                return 0;
            return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        public static int findPath(TreeNode root, int sum) {
            int res = 0;
            if (root == null)
                return res;
            if (sum == root.val)
                res++;
            res += findPath(root.left, sum - root.val);
            res += findPath(root.right, sum - root.val);
            return res;
        }
    }

    static class Solution_my {

    }

    public static void main(String[] args) {
    }

}


