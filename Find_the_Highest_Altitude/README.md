# LeetCode Problem 1732: Find the Highest Altitude

## Problem Statement
There is a biker going on a road trip.  
The road trip consists of `n + 1` points at different altitudes.  
The biker starts at altitude `0`.  

You are given an integer array `gain` of length `n` where `gain[i]` is the net gain in altitude between points `i` and `i + 1`.  
Return the highest altitude the biker reaches.

---

## My Solution (Java)

```java
class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int max = 0;
        for(int n : gain){
            sum += n;
            max = Math.max(max, sum);
        }
        return max;
    }
}
```

---

## Explanation
- Start at altitude `0`.
- Traverse the `gain` array:
  - Add each `gain[i]` to the running sum (current altitude).
  - Track the maximum altitude reached so far.
- Return the maximum altitude after processing all gains.

---

## Sample Input/Output

### Example 1
**Input:**  
`gain = [-5,1,5,0,-7]`  

**Output:**  
`1`  
Explanation: Altitudes are `[0,-5,-4,1,1,-6]`. The highest is `1`.

### Example 2
**Input:**  
`gain = [-4,-3,-2,-1,4,3,2]`  

**Output:**  
`0`  
Explanation: Altitudes are `[0,-4,-7,-9,-10,-6,-3,-1]`. The highest is `0`.

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each element in `gain` is processed once.
- **Space Complexity:** `O(1)`  
  Only two variables (`sum` and `max`) are used.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
