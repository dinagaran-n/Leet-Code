# LeetCode Problem 8: String to Integer (atoi)

## Problem Statement
Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer (similar to the C/C++ `atoi` function).  
The algorithm should follow these rules:
1. Read and ignore leading whitespace.
2. Check for an optional sign (`+` or `-`).
3. Read digits until a non-digit character is encountered or the end of the string is reached.
4. Clamp the integer within the 32-bit signed integer range:  
   - `[-2^31, 2^31 - 1]` → `[-2147483648, 2147483647]`.

---

## My Solution (Java)

```java
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        int sign = 1;
        int i = 0;
        long result = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break;

            result = result * 10 + (ch - '0');

            if (sign * result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign * result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * result);
    }
}
```

---

## Explanation
- Trim leading spaces using `s.trim()`.
- Handle optional sign (`+` or `-`).
- Iterate through characters:
  - Stop if a non-digit is encountered.
  - Build the number digit by digit.
- Use `long` to avoid overflow during calculation.
- Clamp the result to `Integer.MAX_VALUE` or `Integer.MIN_VALUE` if it exceeds bounds.
- Return the final integer.

---

## Sample Input/Output

### Example 1
**Input:**  
`s = "42"`  

**Output:**  
`42`  

### Example 2
**Input:**  
`s = "   -42"`  

**Output:**  
`-42`  

### Example 3
**Input:**  
`s = "4193 with words"`  

**Output:**  
`4193`  

### Example 4
**Input:**  
`s = "words and 987"`  

**Output:**  
`0`  

### Example 5
**Input:**  
`s = "-91283472332"`  

**Output:**  
`-2147483648` (clamped to `Integer.MIN_VALUE`)  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each character is processed once, where `n` is the length of the string.
- **Space Complexity:** `O(1)`  
  Only a few variables are used, no extra data structures.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
