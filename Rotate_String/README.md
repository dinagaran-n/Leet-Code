# LeetCode Problem 796: Rotate String

## Problem Statement
Given two strings `s` and `goal`, return `true` if and only if `s` can become `goal` after some number of shifts.  
A shift means moving the leftmost character of `s` to the rightmost position.  
For example: `"abcde"` → `"bcdea"`.

---

## My Solution (Java)

```java
class Solution {
    public boolean rotateString(String s, String goal) {
        for(int i = 0; i < s.length(); i++){
            if(s.equals(goal)) return true;
            s = s.substring(1) + s.charAt(0);
        }
        return false;
    }
}
```

---

## Explanation
- Iterate through the string `s` up to its length.
- At each step:
  - Check if `s` equals `goal`. If yes, return `true`.
  - Otherwise, rotate `s` by moving the first character to the end.
- If no match is found after all rotations, return `false`.

---

## Sample Input/Output

### Example 1
**Input:**  
`s = "abcde", goal = "cdeab"`  

**Output:**  
`true`  

### Example 2
**Input:**  
`s = "abcde", goal = "abced"`  

**Output:**  
`false`  

---

## Complexity Analysis
- **Time Complexity:** `O(n^2)`  
  Each rotation involves substring concatenation, which costs `O(n)` for `n` characters, repeated `n` times.
- **Space Complexity:** `O(n)`  
  New strings are created during rotations.

⚡ Optimized approach: Check if `goal` is a substring of `s + s`. This reduces time complexity to `O(n)`.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
