# LeetCode Problem 4: Median of Two Sorted Arrays

## Problem Statement
Given two sorted arrays `nums1` and `nums2` of size `n` and `m` respectively, return the median of the two sorted arrays.  
The overall run time complexity should be `O(log (m+n))`.

---

## My Solution (Java)

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n+m];
        int k=0;
        for(int i=0;i<n;i++){
            merged[k++]=nums1[i];
        }
        for(int j=0;j<m;j++){
            merged[k++]=nums2[j];
        }
        Arrays.sort(merged);
        int l = merged.length;
        if(l%2==1){
            return (double)(merged[l/2]);
        }
        else{
            int left = l/2;
            int right = (l/2)-1;
            return (double)(merged[left]+merged[right])/2;
        }
    }
}
```

---

## Explanation
- Merge both arrays into a single array `merged`.
- Sort the merged array.
- If the length of `merged` is odd, return the middle element.
- If the length is even, return the average of the two middle elements.

⚠️ Note: This solution works correctly but does not meet the required `O(log (m+n))` complexity.  
It runs in `O((m+n) log (m+n))` due to sorting. An optimized solution would use binary search partitioning.

---

## Sample Input/Output

### Example 1
**Input:**  
`nums1 = [1,3], nums2 = [2]`  

**Output:**  
`2.0`  

### Example 2
**Input:**  
`nums1 = [1,2], nums2 = [3,4]`  

**Output:**  
`2.5`  

---

## Complexity Analysis
- **Time Complexity:** `O((m+n) log (m+n))`  
  Sorting dominates the runtime.
- **Space Complexity:** `O(m+n)`  
  A new merged array is created.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
