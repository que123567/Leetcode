package easy;

import DataStructure.TreeNode;

import java.util.Queue;

/**
 * 669. Trim a Binary Search Tree
 * '
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 * '
 * Example 1:
 * '
 * Input:
 * 1
 * / \
 * 0   2
 * '
 * L = 1
 * R = 2
 * '
 * Output:
 * 1
 * \
 * 2
 * Example 2:
 * '
 * Input:
 * 3
 * / \
 * 0   4
 * \
 * 2
 * /
 * 1
 * '
 * L = 1
 * R = 3
 * '
 * Output:
 * 3
 * /
 * 2
 * /
 * 1
 */
public class LeetCode669 {


    class Solution_R {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null)
                return null;

            if (root.val < L)
                return trimBST(root.right, L, R);
            if (root.val > R)
                return trimBST(root.left, L, R);

            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);

            return root;
        }
    }

    class Solution_I {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) {
                return root;
            }
            //Find a valid root which is used to return.
            while (root.val < L || root.val > R) {
                if (root.val < L) {
                    root = root.right;
                }
                if (root.val > R) {
                    root = root.left;
                }
            }
            TreeNode dummy = root;
            // Remove the invalid nodes from left subtree.
            while (dummy != null) {
                while (dummy.left != null && dummy.left.val < L) {
                    dummy.left = dummy.left.right;
                    // If the left child is smaller than L, then we just keep the right subtree of it.
                }
                dummy = dummy.left;
            }
            dummy = root;
            // Remove the invalid nodes from right subtree
            while (dummy != null) {
                while (dummy.right != null && dummy.right.val > R) {
                    dummy.right = dummy.right.left;
                    // If the right child is biggrt than R, then we just keep the left subtree of it.
                }
                dummy = dummy.right;
            }
            return root;
        }
    }

    public static void main(String[] args) {

    }
}
