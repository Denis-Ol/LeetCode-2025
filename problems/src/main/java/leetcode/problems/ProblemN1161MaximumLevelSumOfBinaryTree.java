package leetcode.problems;

public class ProblemN1161MaximumLevelSumOfBinaryTree {
    /* 1161. Maximum Level Sum of a Binary Tree
Medium, Topics: Tree, Depth-First Search, Breadth-First Search, Binary Tree

Given the root of a binary tree, the level of its root is 1,
the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.


Example 1:
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Example 2:
Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2

Constraints:
    The number of nodes in the tree is in the range [1, 10^4].
    -10^5 <= Node.val <= 10^5     */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #1161. Maximum Level Sum of a Binary Tree");

        TreeNode leaf1 = new TreeNode(7);
        TreeNode leaf2 = new TreeNode(-8);
        TreeNode node7 = new TreeNode(7, leaf1, leaf2);
        TreeNode node0 = new TreeNode(0);
        TreeNode root1 = new TreeNode(1, node7, node0);
        System.out.println("Solution for example 1: " + maxLevelSum(root1));
        System.out.println("Solution for example 1 is " +
                (maxLevelSum(root1) == 2 ? "***CORRECT***" : "!!! WRONG !!!"));

        TreeNode node32127 = new TreeNode(-32127);
        TreeNode node98693 = new TreeNode(98693);
        TreeNode node89388 = new TreeNode(-89388, null, node32127);
        TreeNode node10250 = new TreeNode(10250, node98693, node89388);
        TreeNode root2 = new TreeNode(989, null, node10250);
        System.out.println("Solution for example 2: " + maxLevelSum(root2));
        System.out.println("Solution for example 2 is " +
                (maxLevelSum(root2) == 2 ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    // Definition for a binary tree node.
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

    /* // HashMap for levels, DFS => 9 ms
    public static int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> levelsMap = new HashMap<>();
        valOfNodeAtLevel(root, 1, levelsMap);
        int maxVal = Integer.MIN_VALUE;
        int maxLevel = 0;
        for (Map.Entry<Integer, Integer> entry : levelsMap.entrySet()) {
            int currKey = entry.getKey();
            int currVal = entry.getValue();

            if (currVal > maxVal) {
                maxVal = currVal;
                maxLevel = currKey;
            } else if (currVal == maxVal) {
                if (maxLevel == 0 || currKey < maxLevel) {
                    maxLevel = currKey;
                }
            }
        }
        return maxLevel;
    }

    private static void valOfNodeAtLevel(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        int val = root.val;
        map.put(level, map.getOrDefault(level, 0) + val);
        valOfNodeAtLevel(root.left, level + 1, map);
        valOfNodeAtLevel(root.right, level + 1, map);
    }*/

    /* // int[] for levels, DFS => 2 ms
    public static int maxLevelSum(TreeNode root) {
        int[] levels = new int[10001];
        int[] maxLevelReached = new int[1];
        valOfNodeAtLevel(root, 1, levels, maxLevelReached);
        int maxVal = Integer.MIN_VALUE;
        int maxLevel = 0;
        for (int i = 1; i <= maxLevelReached[0]; i++) {
            int currVal = levels[i];
            if (maxVal < currVal) {
                maxLevel = i;
                maxVal = currVal;
            }
        }
        return maxLevel;
    }

    private static void valOfNodeAtLevel(TreeNode root, int level, int[] levelsArr, int[] maxSeenLevel) {
        if (root == null) {
            return;
        }
        int val = root.val;
        levelsArr[level] += val;
        if (maxSeenLevel[0] < level) {
            maxSeenLevel[0] = level;
        }
        valOfNodeAtLevel(root.left, level + 1, levelsArr, maxSeenLevel);
        valOfNodeAtLevel(root.right, level + 1, levelsArr, maxSeenLevel);
    }*/

    // int[] for levels, DFS, int method with maxSeenLevel => 2 ms
    public static int maxLevelSum(TreeNode root) {
        int[] levels = new int[10001];
        int maxLevelReached = maxLevel(root, 1, levels);
        int maxVal = Integer.MIN_VALUE;
        int maxLevel = 0;
        for (int i = 1; i <= maxLevelReached; i++) {
            int currVal = levels[i];
            if (maxVal < currVal) {
                maxLevel = i;
                maxVal = currVal;
            }
        }
        return maxLevel;
    }

    private static int maxLevel(TreeNode root, int level, int[] sumArr) {
        if (root == null) {
            return 0;
        }
        sumArr[level] += root.val;
        int leftMax = maxLevel(root.left, level + 1, sumArr);
        int rightMax = maxLevel(root.right, level + 1, sumArr);
        return Math.max(level, Math.max(leftMax, rightMax));
    }
}
