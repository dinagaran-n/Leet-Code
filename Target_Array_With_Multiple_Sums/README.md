# LeetCode Problem 1354: Construct Target Array With Multiple Sums

## Problem Statement
You are given an array `target` of n integers.  
In one step, you can choose an index `i` and set `target[i] = target[i] + sum(target)`.  
Return `true` if it is possible to construct the array `[1,1,...,1]` (all ones) from `target` using this operation, and `false` otherwise.

---

## My Solution (Java)

```java
class Solution {
    public boolean isPossible(int[] target) {

        if (target.length == 1)
            return target[0] == 1;

        long sum = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : target) {
            sum += num;
            heap.offer(num);
        }

        while (heap.peek() != 1) {

            int cur = heap.poll();

            if (sum - cur == 1)
                return true;

            int y = (int)(cur % (sum - cur));

            if (y == 0 || y == cur)
                return false;

            sum = sum - cur + y;

            heap.offer(y);
        }

        return true;
    }
}
```

---

## Explanation
- Use a **max-heap** to always reduce the largest element.
- Track the total sum of the array.
- At each step:
  - Remove the largest element `cur`.
  - Compute the remainder `y = cur % (sum - cur)`.
  - If `y == 0` or `y == cur`, return `false` (invalid state).
  - Replace `cur` with `y` and update the sum.
- Continue until the largest element becomes `1`.
- Special case: if the array length is 1, return `true` only if the single element is `1`.

---

## Sample Input/Output

### Example 1
**Input:**  
`target = [9,3,5]`  

**Output:**  
`true`  

### Example 2
**Input:**  
`target = [1,1,1,2]`  

**Output:**  
`false`  

### Example 3
**Input:**  
`target = [8,5]`  

**Output:**  
`true`  

---

## Complexity Analysis
- **Time Complexity:** `O(n log n)`  
  Each heap operation costs `O(log n)` and may repeat until values reduce to 1.
- **Space Complexity:** `O(n)`  
  Heap stores all elements.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
