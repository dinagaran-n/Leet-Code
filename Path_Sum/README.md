# LeetCode Problem 112: Path Sum

## Problem Statement
Given the root of a binary tree and an integer `targetSum`, return `true` if the tree has a **root-to-leaf path** such that adding up all the values along the path equals `targetSum`.  
A leaf is a node with no children.

---

## My Solution (Java)

```java
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        targetSum -= root.val;
        if(root.left==null && root.right==null) return targetSum==0;
        return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
    }
}
```

---

## Explanation
- If the root is `null`, return `false` (no path exists).
- Subtract the current node’s value from `targetSum`.
- If the node is a leaf (no left or right child), check if the remaining `targetSum` equals 0.
- Otherwise, recursively check the left and right subtrees.
- Return `true` if any path satisfies the condition.

---

## Sample Input/Output

### Example 1
**Input:**  
`root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22`  

**Output:**  
`true`  
Explanation: The path `5 -> 4 -> 11 -> 2` sums to 22.

### Example 2
**Input:**  
`root = [1,2,3], targetSum = 5`  

**Output:**  
`false`  

### Example 3
**Input:**  
`root = [], targetSum = 0`  

**Output:**  
`false`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each node is visited once, where `n` is the number of nodes.
- **Space Complexity:** `O(h)`  
  Recursion stack depth depends on the height `h` of the tree.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
