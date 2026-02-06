# LeetCode Problem 94: Binary Tree Inorder Traversal

## Problem Statement
Given the root of a binary tree, return the inorder traversal of its nodes' values.  
Inorder traversal means visiting nodes in the order: **Left → Root → Right**.

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        recursiveInorder(root, arr);
        return arr;
    }
    void recursiveInorder(TreeNode root, List<Integer> arr){
        if(root==null){ return; }
        
        recursiveInorder(root.left,arr);
        arr.add(root.val);
        recursiveInorder(root.right,arr);
    }
}
```

---

## Explanation
- Inorder traversal visits nodes in the order: **Left → Root → Right**.
- Use recursion:
  - If the current node is `null`, return.
  - Recursively traverse the left subtree.
  - Add the current node’s value to the list.
  - Recursively traverse the right subtree.
- The result list `arr` will contain the inorder traversal of the tree.

---

## Sample Input/Output

### Example 1
**Input:**  
`root = [1,null,2,3]`  

**Output:**  
`[1,3,2]`  

### Example 2
**Input:**  
`root = []`  

**Output:**  
`[]`  

### Example 3
**Input:**  
`root = [1]`  

**Output:**  
`[1]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each node is visited exactly once, where `n` is the number of nodes.
- **Space Complexity:** `O(n)`  
  The recursion stack can go as deep as the height of the tree, and the result list stores all node values.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
