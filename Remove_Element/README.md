# LeetCode Problem 27: Remove Element

## Problem Statement
Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` in-place.  
The relative order of the elements may be changed.  
Return the number of elements in `nums` which are not equal to `val`.

---

## My Solution (Java)

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}
```

---

## Explanation
- Initialize `k = 0` to track the position of the next valid element.
- Iterate through the array:
  - If the current element is not equal to `val`, copy it to index `k` and increment `k`.
- After the loop, `k` represents the count of elements not equal to `val`.
- The first `k` elements of `nums` will contain the valid elements.

---

## Sample Input/Output

### Example 1
**Input:**  
`nums = [3,2,2,3], val = 3`  

**Output:**  
`k = 2, nums = [2,2,...]`  

### Example 2
**Input:**  
`nums = [0,1,2,2,3,0,4,2], val = 2`  

**Output:**  
`k = 5, nums = [0,1,3,0,4,...]`  

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
