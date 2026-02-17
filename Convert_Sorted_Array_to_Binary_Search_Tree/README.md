# LeetCode Problem 108: Convert Sorted Array to Binary Search Tree

## Problem Statement
Given an integer array `nums` where the elements are sorted in ascending order, convert it to a height-balanced binary search tree (BST).  
A height-balanced BST is defined as a binary tree in which the depth of the two subtrees of every node never differs by more than one.

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums,0,nums.length-1);
    }
    public TreeNode makeTree(int nums[], int st, int end ){
        if(st>end){
            return null;
        }
        int mid = st+(end-st)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeTree(nums,st,mid-1);
        root.right = makeTree(nums,mid+1,end);

        return root;
    }
}
```

---

## Explanation
- The array is sorted, so the middle element should be chosen as the root to ensure balance.
- Recursively:
  - Pick the middle element of the current subarray as the root.
  - Build the left subtree from the left half of the array.
  - Build the right subtree from the right half of the array.
- This guarantees the tree is height-balanced.

---

## Sample Input/Output

### Example 1
**Input:**  
`nums = [-10,-3,0,5,9]`  

**Output:**  
A possible BST is:  
```
      0
     / \
   -3   9
   /   /
 -10  5
```

### Example 2
**Input:**  
`nums = [1,3]`  

**Output:**  
A possible BST is:  
```
   3
  /
 1
```

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each element is visited once to construct the tree.
- **Space Complexity:** `O(log n)`  
  Recursion stack depth depends on the height of the tree (balanced tree height is `log n`).

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
