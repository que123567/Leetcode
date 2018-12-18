package easy;

import DataStructure.TreeNode;

/**
 * 226. Invert Binary Tree
 * Example:
 * .
 * Input:
 * .
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * Output:
 * .
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * .
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class LeetCode226 {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public static void main(String[] args) {
    }
}
