# LeetCode Problem 69: Sqrt(x)

## Problem Statement
Given a non-negative integer `x`, return the square root of `x` rounded down to the nearest integer.  
The returned integer should be non-negative as well.  
You must not use any built-in exponent function or operator.

---

## My Solution (Java)

```java
class Solution {
    public int mySqrt(int x) {
        if(x<2){
            return x;
        }
        int left = 1; 
        int right = x/2;
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if((long)mid*mid == (long)x){
                return mid;
            }
            else if((long)mid*mid < (long)x){
                left = mid+1;
            }
            else if((long)mid*mid > (long)x){
                right = mid-1;
            }
        }
        return right;
    }
}
```

---

## Explanation
- If `x < 2`, return `x` directly since the square root is trivial.
- Use **binary search** between `1` and `x/2`:
  - Compute `mid` safely to avoid overflow.
  - Compare `mid * mid` with `x`:
    - If equal, return `mid`.
    - If less, move `left` to `mid + 1`.
    - If greater, move `right` to `mid - 1`.
- When the loop ends, `right` will be the integer square root of `x`.

---

## Sample Input/Output

### Example 1
**Input:**  
`x = 4`  

**Output:**  
`2`  

### Example 2
**Input:**  
`x = 8`  

**Output:**  
`2`  
Explanation: The square root of 8 is 2.828..., and since we round down, the answer is 2.

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
