# LeetCode Problem 1200: Minimum Absolute Difference

## Problem Statement
Given an array of distinct integers `arr`, find all pairs of elements with the minimum absolute difference of any two elements.  
Return a list of pairs in ascending order.

---

## My Solution (Java)

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] nums) {

        Arrays.sort(nums);

        int smallestGap = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            smallestGap = Math.min(smallestGap, nums[i] - nums[i - 1]);
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == smallestGap) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[i - 1]);
                pair.add(nums[i]);
                answer.add(pair);
            }
        }

        return answer;
    }
}
```

---

## Explanation
- Sort the array to ensure differences are checked in ascending order.
- Find the smallest difference between consecutive elements.
- Traverse again to collect all pairs that match this smallest difference.
- Store each pair in a list and return the final list of pairs.

---

## Sample Input/Output

### Example 1
**Input:**  
`arr = [4,2,1,3]`  

**Output:**  
`[[1,2],[2,3],[3,4]]`  

### Example 2
**Input:**  
`arr = [1,3,6,10,15]`  

**Output:**  
`[[1,3]]`  

### Example 3
**Input:**  
`arr = [3,8,-10,23,19,-4,-14,27]`  

**Output:**  
`[[-14,-10],[19,23],[23,27]]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n log n)`  
  Sorting dominates the runtime.
- **Space Complexity:** `O(n)`  
  Output list stores pairs.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
