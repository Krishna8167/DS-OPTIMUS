/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperserial(root, sb);
        return sb.toString();
    }

    public void helperserial(TreeNode node , StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");

        helperserial(node.left, sb);
        helperserial(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] value = data.split(",");
        return helperdeserial(value, new int[]{0});
    }

    public TreeNode helperdeserial(String[] value, int[] index) {

        String val = value[index[0]++];

        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helperdeserial(value, index);
        node.right = helperdeserial(value, index);

        return node;


    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
