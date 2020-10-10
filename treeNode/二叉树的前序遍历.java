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

 //二叉树前序遍历迭代法 

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(root == null) return resultList;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            resultList.add(treeNode.val);

            if(treeNode.right != null){
                stack.push(treeNode.right);
            }

            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
        }

        return resultList;
    }
}