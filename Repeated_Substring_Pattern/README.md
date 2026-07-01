# LeetCode Problem 459: Repeated Substring Pattern

## Problem Statement
Given a string `s`, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.  
Return `true` if `s` can be constructed this way, otherwise return `false`.

---

## My Solution (Java)

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String twice = s + s;
        return (twice.substring(1, twice.length() - 1).contains(s));
    }
}
```

---

## Explanation
- Concatenate the string with itself (`s + s`).
- Remove the first and last characters to avoid trivial matches.
- If the original string `s` appears in this modified string, it means `s` is composed of repeated substrings.
- Otherwise, return `false`.

This clever trick works because repeating substrings will always appear in the middle of the doubled string.

---

## Sample Input/Output

### Example 1
**Input:**  
`s = "abab"`  

**Output:**  
`true`  
Explanation: `"abab"` is constructed by repeating `"ab"`.

### Example 2
**Input:**  
`s = "aba"`  

**Output:**  
`false`  

### Example 3
**Input:**  
`s = "abcabcabcabc"`  

**Output:**  
`true`  
Explanation: `"abcabcabcabc"` is constructed by repeating `"abc"`.

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  String concatenation and substring operations are linear in the length of `s`.
- **Space Complexity:** `O(n)`  
  Extra space is used for the concatenated string.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
