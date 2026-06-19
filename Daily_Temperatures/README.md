# LeetCode Problem 739: Daily Temperatures

## Problem Statement
Given an array of integers `temperatures` representing the daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `i`‑th day to get a warmer temperature.  
If there is no future day for which this is possible, put `0` instead.

---

## My Solution (Java)

```java
class Solution {
    public int[] dailyTemperatures(int[] t){
        int[] result = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<t.length;i++){
            while(!stack.isEmpty() && t[stack.peek()]<t[i]){
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
```

---

## Explanation
- Use a **monotonic stack** to keep track of indices of days with decreasing temperatures.
- For each day `i`:
  - While the stack is not empty and the current temperature is greater than the temperature at the index on top of the stack:
    - Pop the index from the stack.
    - Compute the difference `i - poppedIndex` and store it in `result[poppedIndex]`.
  - Push the current index `i` onto the stack.
- If no warmer day exists for a given index, its result remains `0`.

---

## Sample Input/Output

### Example 1
**Input:**  
`t = [73,74,75,71,69,72,76,73]`  

**Output:**  
`[1,1,4,2,1,1,0,0]`  

### Example 2
**Input:**  
`t = [30,40,50,60]`  

**Output:**  
`[1,1,1,0]`  

### Example 3
**Input:**  
`t = [30,60,90]`  

**Output:**  
`[1,1,0]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each index is pushed and popped from the stack at most once.
- **Space Complexity:** `O(n)`  
  Stack stores indices of days.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
