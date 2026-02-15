# LeetCode Problem 101: Symmetric Tree

## Problem Statement
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSym(root.left,root.right);
    }
    private boolean isSym(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;
        if(t1.val!=t2.val) return false;
        return isSym(t1.left,t2.right) && isSym(t1.right,t2.left);
    }
}
```

---

## Explanation
- A tree is symmetric if the left subtree is a mirror reflection of the right subtree.
- Base cases:
  - If both nodes are `null`, they are symmetric.
  - If one is `null` and the other is not, they are not symmetric.
  - If values differ, they are not symmetric.
- Recursively check:
  - Left child of one node against the right child of the other.
  - Right child of one node against the left child of the other.

---

## Sample Input/Output

### Example 1
**Input:**  
`root = [1,2,2,3,4,4,3]`  

**Output:**  
`true`  

### Example 2
**Input:**  
`root = [1,2,2,null,3,null,3]`  

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
