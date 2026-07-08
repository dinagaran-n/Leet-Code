# LeetCode Problem 41: First Missing Positive

## Problem Statement
Given an unsorted integer array `nums`, return the smallest missing positive integer.  
You must implement an algorithm that runs in `O(n)` time and uses constant extra space.

---

## My Solution (Java)

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] - 1]){
                int cindex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[cindex];
                nums[cindex] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}
```

---

## Explanation
- The key idea is to place each number in its correct position:
  - If `nums[i]` is between `1` and `n`, place it at index `nums[i] - 1`.
  - Swap until each number is either out of range or in its correct position.
- After rearrangement:
  - Traverse the array. If `nums[i] != i + 1`, then `i + 1` is the smallest missing positive.
- If all positions are correct, return `n + 1`.

---

## Sample Input/Output

### Example 1
**Input:**  
`nums = [1,2,0]`  

**Output:**  
`3`  

### Example 2
**Input:**  
`nums = [3,4,-1,1]`  

**Output:**  
`2`  

### Example 3
**Input:**  
`nums = [7,8,9,11,12]`  

**Output:**  
`1`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each number is swapped at most once into its correct position.
- **Space Complexity:** `O(1)`  
  Rearrangement is done in-place.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
