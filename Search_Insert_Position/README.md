# LeetCode Problem 35: Search Insert Position

## Problem Statement
Given a sorted array of distinct integers `nums` and a target value `target`, return the index if the target is found.  
If not, return the index where it would be if it were inserted in order.  
You must write an algorithm with `O(log n)` runtime complexity.

---

## My Solution (Java)

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid;

        while(left<=right){
            mid = (left + right)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(target<nums[mid]){
                right=mid-1;
            }
            else if(target>nums[mid]){
                left=mid+1;
            }
        }
        return left;
    }
}
```

---

## Explanation
- Use binary search to find the target or its correct insertion position.
- Initialize `left = 0` and `right = nums.length - 1`.
- While `left <= right`:
  - Compute `mid = (left + right) / 2`.
  - If `nums[mid] == target`, return `mid`.
  - If `target < nums[mid]`, move the search to the left half (`right = mid - 1`).
  - If `target > nums[mid]`, move the search to the right half (`left = mid + 1`).
- If the loop ends without finding the target, return `left` as the insertion position.

---

## Sample Input/Output

### Example 1
**Input:**  
`nums = [1,3,5,6], target = 5`  

**Output:**  
`2`  

### Example 2
**Input:**  
`nums = [1,3,5,6], target = 2`  

**Output:**  
`1`  

### Example 3
**Input:**  
`nums = [1,3,5,6], target = 7`  

**Output:**  
`4`  

### Example 4
**Input:**  
`nums = [1,3,5,6], target = 0`  

**Output:**  
`0`  

---

## Complexity Analysis
- **Time Complexity:** `O(log n)`  
  Binary search reduces the search space by half each iteration.
- **Space Complexity:** `O(1)`  
  Only a few variables are used, no extra data structures.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
