# LeetCode Problem 100: Same Tree

## Problem Statement
Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.  
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null || p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
```

---

## Explanation
- If both nodes are `null`, they are identical at this branch.
- If one node is `null` and the other is not, or their values differ, the trees are not the same.
- Recursively check the left subtrees and right subtrees.
- Return `true` only if both subtrees are identical.

---

## Sample Input/Output

### Example 1
**Input:**  
`p = [1,2,3], q = [1,2,3]`  

**Output:**  
`true`  

### Example 2
**Input:**  
`p = [1,2], q = [1,null,2]`  

**Output:**  
`false`  

### Example 3
**Input:**  
`p = [1,2,1], q = [1,1,2]`  

**Output:**  
`false`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each node is visited once, where `n` is the number of nodes in the smaller tree.
- **Space Complexity:** `O(h)`  
  Recursion stack depth depends on the height `h` of the tree.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
