/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        if (xx == null || yy == null) return false;

        int lx = level(root, x, 0);
        int ly = level(root, y, 0);

        if (lx == -1 || ly == -1) return false;

        return ((lx == ly) && !(isSibling(root, xx, yy)));
    }

    public TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }

        if (node.val == x) {
            return node;
        }

        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }
        return findNode(node.right, x);
    }

    public int level(TreeNode node, int x, int level) {

        if (node == null) {
            return -1;
        }

        if (node.val == x) {
            return level;
        }

        int l = level(node.left, x, level + 1);
        if (l != -1) {
            return l;
        }
        return level(node.right, x, level + 1);
    }

    public boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }

        if (node.left == x && node.right == y) return true;
        if (node.left == y && node.right == x) return true;

        return (isSibling(node.left, x, y) || isSibling(node.right, x, y));
    }

}
