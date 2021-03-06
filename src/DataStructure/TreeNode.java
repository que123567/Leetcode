package DataStructure;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * Case1
     *
     * @return
     */
    public static TreeNode makeTree_Test_Case_1() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(13);

        return treeNode;
    }

    /**
     * Travel_1
     * @param root
     */
    public static void travelTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        travelTree(root.left);
        travelTree(root.right);

    }
}

