package leetcode.problems;

import java.util.IdentityHashMap;
import java.util.Map;

public class ProblemN1339MaximumProductOfSplittedBinaryTree {
    /* 1339. Maximum Product of Splitted Binary Tree
Medium Topics: Tree, Depth-First Search, Binary Tree

Given the root of a binary tree, split the binary tree into two subtrees
by removing one edge such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees.
Since the answer may be too large, return it modulo 10^9 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.

Example 1:
Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10.
Their product is 110 (11*10)

Example 2:
Input: root = [1,null,2,3,4,null,null,5,6]
Output: 90
Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)

Constraints:
    The number of nodes in the tree is in the range [2, 5 * 10^4].
    1 <= Node.val <= 10^4     */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #1339. Maximum Product of Splitted Binary Tree");

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode root1 = new TreeNode(1, node2, node3);
        System.out.println("Solution for example 1: " + maxProduct(root1));
        System.out.println("Solution for example 1 is " +
                (maxProduct(root1) == 110 ? "***CORRECT***" : "!!! WRONG !!!"));

        TreeNode node5b = new TreeNode(5);
        TreeNode node6b = new TreeNode(6);
        TreeNode node4b = new TreeNode(4, node5b, node6b);
        TreeNode node3b = new TreeNode(3);
        TreeNode node2b = new TreeNode(2, node3b, node4b);
        TreeNode root2 = new TreeNode(1, null, node2b);
        System.out.println("Solution for example 2: " + maxProduct(root2));
        System.out.println("Solution for example 2 is " +
                (maxProduct(root2) == 90 ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    //    Definition for a binary tree node.
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

    // DFS, currSubTreeSum * (fullSum - currSubTreeSum) hint -> 5 ms
    // (7 ms if using long and didn't check null of root children)
    /*public static int maxProduct(TreeNode root) {
        long[] prod = new long[1];
        int fullSum = sumTree(root);
        if (root.left != null) prodNode(root.left, prod, fullSum);
        if (root.right != null) prodNode(root.right, prod, fullSum);
        return (int) (prod[0] % (1000000000 + 7));
    }

    private static long prodNode(TreeNode root, long[] prod, int fullSum) {
        if (root == null) {
            return 0;
        }
        long leftSum = prodNode(root.left, prod, fullSum);
        long rightSum = prodNode(root.right, prod, fullSum);
        long currSubTreeSum = root.val + leftSum + rightSum;
        long currProd = currSubTreeSum * (fullSum - currSubTreeSum);
        prod[0] = Math.max(prod[0], currProd);
        return currSubTreeSum;
    }

    private static int sumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumTree(root.left) + sumTree(root.right);
    }*/

    // adding memoization -> 24 ms
    public static int maxProduct(TreeNode root) {
        long[] prod = new long[1];
        int fullSum = sumTree(root);
        Map<TreeNode, Long> memo = new IdentityHashMap<>();
        if (root.left != null) prodNode(root.left, prod, fullSum, memo);
        if (root.right != null) prodNode(root.right, prod, fullSum, memo);
        return (int) (prod[0] % (1000000000 + 7));
    }

    private static long prodNode(TreeNode root, long[] prod, int fullSum, Map<TreeNode, Long> memo) {
        if (root == null) {
            return 0;
        }
        long leftSum, rightSum;
        if (memo.containsKey(root.left)) {
            leftSum = memo.get(root.left);
        } else {
            leftSum = prodNode(root.left, prod, fullSum, memo);
            memo.put(root.left, leftSum);
        }
        if (memo.containsKey(root.right)) {
            rightSum = memo.get(root.right);
        } else {
            rightSum = prodNode(root.right, prod, fullSum, memo);
            memo.put(root.right, rightSum);
        }
        long currSubTreeSum = root.val + leftSum + rightSum;
        long currProd = currSubTreeSum * (fullSum - currSubTreeSum);
        prod[0] = Math.max(prod[0], currProd);
        return currSubTreeSum;
    }

    private static int sumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumTree(root.left) + sumTree(root.right);
    }
}
