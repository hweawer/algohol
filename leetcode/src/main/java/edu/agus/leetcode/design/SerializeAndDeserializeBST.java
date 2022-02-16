package edu.agus.leetcode.design;

public class SerializeAndDeserializeBST {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Codec {
    private TreeNode root;

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
      if (node == null) return;
      else {
        sb.append(node.val);
        sb.append(',');
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
      }
    }

    private void dfsInsert(TreeNode node, Integer v) {
      if (node.val > v) {
        if (node.left == null) {
          node.left = new TreeNode(v);
        } else dfsInsert(node.left, v);
      } else if (node.val < v) {
        if (node.right == null) {
          node.right = new TreeNode(v);
        } else dfsInsert(node.right, v);
      }
    }

    public String serialize(TreeNode root) {
      if (root == null) return "";
      StringBuilder sb = new StringBuilder();
      dfsSerialize(root, sb);
      sb.deleteCharAt(sb.length() - 1);
      return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data.isEmpty()) return root;
      String[] nums = data.split(",");
      root = new TreeNode(Integer.parseInt(nums[0]));
      for (int i = 1; i < nums.length; i++) {
        Integer v = Integer.parseInt(nums[i]);
        dfsInsert(root, v);
      }
      return root;
    }
  }
}
