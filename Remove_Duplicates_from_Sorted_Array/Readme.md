# LeetCode Problem 26: Remove Duplicates from Sorted Array

## Problem Statement
Given an integer array `nums` sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.  
Return the number of unique elements `k`.

---

## My Solution (Java)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
```

---

## Explanation
- Start with `k = 1` since the first element is always unique.
- Iterate through the array from index `1`.
- If the current element is different from the previous one, place it at index `k` and increment `k`.
- Finally, return `k` which represents the count of unique elements.

---

## Sample Input/Output

### Example 1
**Input:**  
`nums = [1,1,2]`  

**Output:**  
`k = 2, nums = [1,2,...]`  

### Example 2
**Input:**  
`nums = [0,0,1,1,1,2,2,3,3,4]`  

**Output:**  
`k = 5, nums = [0,1,2,3,4,...]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  We traverse the array once, where `n` is the length of the array.
- **Space Complexity:** `O(1)`  
  The operation is done in-place without using extra space.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
