# LeetCode Problem 88: Merge Sorted Array

## Problem Statement
You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.  
Merge `nums2` into `nums1` as one sorted array.  
The final sorted array should not be returned by the function, but instead be stored inside the array `nums1`.  
To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements to be merged, and the last `n` elements are set to 0 and should be ignored.

---

## My Solution (Java)

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}
```

---

## Explanation
- Copy all elements of `nums2` into the unused portion of `nums1` starting from index `m`.
- After merging, sort the entire `nums1` array to ensure it is in non-decreasing order.
- This approach is simple but not the most optimal, since sorting takes extra time.

---

## Sample Input/Output

### Example 1
**Input:**  
`nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3`  

**Output:**  
`[1,2,2,3,5,6]`  

### Example 2
**Input:**  
`nums1 = [1], m = 1, nums2 = [], n = 0`  

**Output:**  
`[1]`  

### Example 3
**Input:**  
`nums1 = [0], m = 0, nums2 = [1], n = 1`  

**Output:**  
`[1]`  

---

## Complexity Analysis
- **Time Complexity:** `O((m+n) log(m+n))`  
  Because we sort the combined array after merging.
- **Space Complexity:** `O(1)`  
  The merge is done in-place without using extra data structures.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
