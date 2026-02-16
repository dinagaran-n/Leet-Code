# LeetCode Problem 6: Zigzag Conversion

## Problem Statement
The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this (for `numRows = 3`):

```
P   A   H   N
A P L S I I G
Y   I   R
```

Then read line by line: `"PAHNAPLSIIGYIR"`.  
Write the code that will take a string and make this conversion given a number of rows.

---

## My Solution (Java)

```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int cycle = numRows*2-2;
        for(int r=0;r<numRows;r++){
            for(int i=r;i<n;i+=cycle){
                result.append(s.charAt(i));
                int diagonal = i+cycle-2*r;
                if(r!=0 && r!=numRows-1 && diagonal<n){
                    result.append(s.charAt(diagonal));
                }
            }
        }
        return result.toString();
    }
}
```

---

## Explanation
- If `numRows == 1`, the zigzag is just the original string.
- The zigzag pattern repeats every `cycle = 2*numRows - 2` characters.
- For each row `r`:
  - Append the vertical characters at positions `i = r, r+cycle, r+2*cycle, ...`.
  - For middle rows (not the first or last), also append the diagonal characters at `i + cycle - 2*r`.
- Continue until all characters are processed.
- Return the concatenated result.

---

## Sample Input/Output

### Example 1
**Input:**  
`s = "PAYPALISHIRING", numRows = 3`  

**Output:**  
`"PAHNAPLSIIGYIR"`  

### Example 2
**Input:**  
`s = "PAYPALISHIRING", numRows = 4`  

**Output:**  
`"PINALSIGYAHRPI"`  

Explanation:

```
P     I    N
A   L S  I G
Y A   H R
P     I
```

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each character is visited once, where `n` is the length of the string.
- **Space Complexity:** `O(n)`  
  The result string builder stores the converted string.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
