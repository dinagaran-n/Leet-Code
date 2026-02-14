# LeetCode Problem 104: Maximum Depth of Binary Tree

## Problem Statement
Given the root of a binary tree, return its maximum depth.  
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

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
    public int maxDepth(TreeNode root) {
        if(root==null){return 0;}
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
```

---

## Explanation
- If the tree is empty (`root == null`), return `0`.
- Otherwise, recursively compute the depth of the left and right subtrees.
- The maximum depth is `1 + max(leftDepth, rightDepth)`.
- This ensures we count the current node plus the deepest path below it.

---

## Sample Input/Output

### Example 1
**Input:**  
`root = [3,9,20,null,null,15,7]`  

**Output:**  
`3`  

### Example 2
**Input:**  
`root = [1,null,2]`  

**Output:**  
`2`  

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
