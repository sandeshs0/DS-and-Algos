
public class Question4B {

    // Function to check if two nodes are cousins in a binary tree
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        // Find information about nodes x and y
        int[] xInfo = findNode(root, x, 0, -1);
        int[] yInfo = findNode(root, y, 0, -1);

        // Check if x and y have the same depth but different parents
        return xInfo[0] == yInfo[0] && xInfo[1] != yInfo[1];
    }

    // Helper function to find information about a node in the tree
    private static int[] findNode(TreeNode root, int target, int depth, int parent) {
        if (root == null) {
            return null;
        }

        if (root.val == target) {
            return new int[]{depth, parent};
        }

        int[] left = findNode(root.left, target, depth + 1, root.val);
        int[] right = findNode(root.right, target, depth + 1, root.val);

        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5)));
        int x = 2;
        int y = 3;
        System.out.println(isCousins(root, x, y)); // Print whether x and y are cousins
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
