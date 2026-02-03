# LeetCode Problem 70: Climbing Stairs

## Problem Statement
You are climbing a staircase. It takes `n` steps to reach the top.  
Each time you can either climb 1 or 2 steps.  
In how many distinct ways can you climb to the top?

---

## My Solution (Java)

```java
public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;

        int a = 1, b = 1;

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
```

---

## Explanation
- This problem is equivalent to computing the **Fibonacci sequence**:
  - To reach step `n`, you can come from step `n-1` (1 step) or step `n-2` (2 steps).
  - So, `ways(n) = ways(n-1) + ways(n-2)`.
- Initialize `a = 1` and `b = 1` for the base cases (`n = 0` and `n = 1`).
- Iteratively compute the number of ways up to `n` using a loop.
- Return `b` as the total number of distinct ways.

---

## Sample Input/Output

### Example 1
**Input:**  
`n = 2`  

**Output:**  
`2`  
Explanation: There are two ways: (1 step + 1 step) or (2 steps).

### Example 2
**Input:**  
`n = 3`  

**Output:**  
`3`  
Explanation: There are three ways: (1+1+1), (1+2), (2+1).

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  We compute the result iteratively up to `n`.
- **Space Complexity:** `O(1)`  
  Only a few variables are used, no extra data structures.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
