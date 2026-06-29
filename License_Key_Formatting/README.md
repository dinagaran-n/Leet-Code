# LeetCode Problem 482: License Key Formatting

## Problem Statement
You are given a string `s` that represents a license key.  
The string consists of alphanumeric characters and dashes.  
The string is broken into groups separated by dashes.  
You are also given an integer `k`.  

Reformat the string so that each group contains exactly `k` characters, except the first group which may be shorter.  
All lowercase letters should be converted to uppercase.  
Return the reformatted license key.

---

## My Solution (Java)

```java
class Solution {

    public String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (ch == '-')
                continue;

            if (count == k) {
                sb.append('-');
                count = 0;
            }

            sb.append(Character.toUpperCase(ch));
            count++;
        }

        return sb.reverse().toString();
    }
}
```

---

## Explanation
- Traverse the string from the end to the beginning.
- Skip dashes (`'-'`).
- For every `k` characters added, insert a dash.
- Convert all characters to uppercase before appending.
- Reverse the final string to restore the correct order.

---

## Sample Input/Output

### Example 1
**Input:**  
`s = "5F3Z-2e-9-w", k = 4`  

**Output:**  
`"5F3Z-2E9W"`  

### Example 2
**Input:**  
`s = "2-5g-3-J", k = 2`  

**Output:**  
`"2-5G-3J"`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each character is processed once.
- **Space Complexity:** `O(n)`  
  StringBuilder stores the reformatted key.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
