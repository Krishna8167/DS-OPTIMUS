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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean flag = false;
        while (!deque.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelsize = deque.size();

            for (int i = 0; i < levelsize; i++) {
                if (flag == true) {
                    TreeNode currentNode = deque.pollFirst();
                    currentLevel.add(currentNode.val);
                    if (currentNode.right != null) {
                        deque.offerLast(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        deque.offerLast(currentNode.left);
                    }
                    
                } else {
                    TreeNode currentNode = deque.pollLast();
                    currentLevel.add(currentNode.val);

                    if (currentNode.left != null) {
                        deque.offerFirst(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        deque.offerFirst(currentNode.right);
                    }
                    
                }
            }
            flag = !flag;
            result.add(currentLevel);
        }
        return result;
    }
}
