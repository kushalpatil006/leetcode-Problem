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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLevelEven = true;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            int previousValue = Integer.MIN_VALUE;
            if(!isLevelEven) {
                previousValue = Integer.MAX_VALUE;
            }
            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                
                if(isLevelEven && (curr.val % 2 == 0 || curr.val <= previousValue)) {
                    return false;
                }

                if(!isLevelEven && (curr.val % 2 == 1 || curr.val >= previousValue)) {
                    return false;
                }

                previousValue = curr.val;

                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            isLevelEven = !isLevelEven;
        }

        return true;
    }
}
