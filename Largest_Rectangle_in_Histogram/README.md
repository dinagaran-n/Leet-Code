# LeetCode Problem 84: Largest Rectangle in Histogram

## Problem Statement
Given an array of integers `heights` representing the histogram's bar height where the width of each bar is `1`, return the area of the largest rectangle in the histogram.

---

## My Solution (Java)

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int n = heights.length;
        for(int i=0;i<=n;i++){
            int height = (i==n)?0:heights[i];
            while(!stack.isEmpty() && height<heights[stack.peek()]){
                int curHeight = heights[stack.pop()];
                int width;
                if(stack.isEmpty()){
                    width = i;
                }
                else{
                    width = i-stack.peek()-1;
                }
                int area = curHeight*width;
                max = Math.max(max,area);
            }
            stack.push(i);
        }
        return max;
    }
}
```

---

## Explanation
- Use a **monotonic stack** to store indices of increasing bar heights.
- Iterate through each bar (and an extra `0` height at the end to flush the stack).
- When the current bar is lower than the bar at the stack’s top:
  - Pop the stack to calculate the area of the rectangle with the popped bar as height.
  - Width is determined by the current index `i` and the new stack top.
- Update `max` with the largest area found.
- Return the maximum area after processing all bars.

---

## Sample Input/Output

### Example 1
**Input:**  
`heights = [2,1,5,6,2,3]`  

**Output:**  
`10`  
Explanation: The largest rectangle is formed by bars `[5,6]` with area `5*2 = 10`.

### Example 2
**Input:**  
`heights = [2,4]`  

**Output:**  
`4`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each bar is pushed and popped from the stack at most once.
- **Space Complexity:** `O(n)`  
  Stack stores indices of bars.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
