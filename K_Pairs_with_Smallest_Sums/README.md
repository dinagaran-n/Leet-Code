# LeetCode Problem 373: Find K Pairs with Smallest Sums

## Problem Statement
You are given two integer arrays `nums1` and `nums2` sorted in ascending order and an integer `k`.  
Define a pair `(u, v)` which consists of one element from `nums1` and one element from `nums2`.  
Return the `k` pairs `(u1, v1), (u2, v2), ..., (uk, vk)` with the smallest sums.

---

## My Solution (Java)

```java
class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );

        List<List<Integer>> result = new ArrayList<>();

        if(nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        for(int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while(k > 0 && !pq.isEmpty()) {

            int[] current = pq.poll();

            result.add(Arrays.asList(current[0], current[1]));

            if(current[2] + 1 < nums2.length) {
                pq.offer(new int[]{
                    current[0],
                    nums2[current[2] + 1],
                    current[2] + 1
                });
            }

            k--;
        }

        return result;
    }
}
```

---

## Explanation
- Use a **min-heap** (`PriorityQueue`) to always extract the pair with the smallest sum.
- Initially, pair each element of `nums1` (up to `k` elements) with the first element of `nums2`.
- Pop the smallest pair from the heap and add it to the result.
- If the popped pair used `nums2[j]`, push the next pair `(nums1[i], nums2[j+1])` into the heap.
- Repeat until `k` pairs are collected or the heap is empty.

---

## Sample Input/Output

### Example 1
**Input:**  
`nums1 = [1,7,11], nums2 = [2,4,6], k = 3`  

**Output:**  
`[[1,2],[1,4],[1,6]]`  

### Example 2
**Input:**  
`nums1 = [1,1,2], nums2 = [1,2,3], k = 2`  

**Output:**  
`[[1,1],[1,1]]`  

### Example 3
**Input:**  
`nums1 = [1,2], nums2 = [3], k = 3`  

**Output:**  
`[[1,3],[2,3]]`  

---

## Complexity Analysis
- **Time Complexity:** `O(k log k)`  
  Each heap operation costs `O(log k)` and we perform up to `k` operations.
- **Space Complexity:** `O(k)`  
  Heap stores at most `k` pairs.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
