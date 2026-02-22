# LeetCode Problem 12: Integer to Roman

## Problem Statement
Given an integer, convert it to a Roman numeral.  
Input is guaranteed to be within the range `1` to `3999`.

---

## My Solution (Java)

```java
class Solution {
    public String intToRoman(int num) {
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        String str = new String(); 
        while (num > 0) {
            if (num >= n[i]) {
                str = str + s[i];
                num -= n[i];
            } else {
                i++;
            }
        }
        return str;
    }
}
```

---

## Explanation
- Roman numerals are built from specific values (`M=1000`, `CM=900`, `D=500`, etc.).
- Store these values in an array `n` and their corresponding symbols in array `s`.
- Iterate through the arrays:
  - If the current number `num` is greater than or equal to `n[i]`, append the symbol `s[i]` and subtract `n[i]` from `num`.
  - Otherwise, move to the next smaller value.
- Continue until `num` becomes 0.
- Return the constructed Roman numeral string.

---

## Sample Input/Output

### Example 1
**Input:**  
`num = 3`  

**Output:**  
`"III"`  

### Example 2
**Input:**  
`num = 58`  

**Output:**  
`"LVIII"`  
Explanation: `L = 50`, `V = 5`, `III = 3`.

### Example 3
**Input:**  
`num = 1994`  

**Output:**  
`"MCMXCIV"`  
Explanation: `M = 1000`, `CM = 900`, `XC = 90`, `IV = 4`.

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Where `n` is the number of Roman numeral symbols added (bounded by a constant since `num ≤ 3999`).
- **Space Complexity:** `O(1)`  
  Only a fixed set of arrays and variables are used.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
