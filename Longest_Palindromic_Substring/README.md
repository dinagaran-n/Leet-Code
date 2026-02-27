# LeetCode Problem 5: Longest Palindromic Substring

## Problem Statement
Given a string `s`, return the longest palindromic substring in `s`.  
A palindrome is a string that reads the same forward and backward.

---

## My Solution (Java)

```java
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";

        for(int i = 0; i < n; i++) {
            // Odd length palindrome
            int st = i, end = i;
            while(st >= 0 && end < n && s.charAt(st) == s.charAt(end)) {
                st--;
                end++;
            }
            String temp = s.substring(st+1, end);
            if(temp.length() > res.length()) res = temp;

            // Even length palindrome
            st = i;
            end = i+1;
            while(st >= 0 && end < n && s.charAt(st) == s.charAt(end)) {
                st--;
                end++;
            }
            temp = s.substring(st+1, end);
            if(temp.length() > res.length()) res = temp;
        }

        return res;
    }
}
```

---

## Explanation
- The algorithm expands around each character (and each pair of characters) to find palindromes.
- For each index `i`:
  - Treat `i` as the center of an odd-length palindrome.
  - Treat `i` and `i+1` as the center of an even-length palindrome.
- Expand outward while characters match.
- Track the longest palindrome found so far.
- Return the longest substring.

---

## Sample Input/Output

### Example 1
**Input:**  
`s = "babad"`  

**Output:**  
`"bab"`  
Explanation: `"aba"` is also a valid answer.

### Example 2
**Input:**  
`s = "cbbd"`  

**Output:**  
`"bb"`  

---

## Complexity Analysis
- **Time Complexity:** `O(n^2)`  
  Each center expansion can take up to `O(n)` and there are `n` centers.
- **Space Complexity:** `O(1)`  
  Only variables for indices and substring tracking are used.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
