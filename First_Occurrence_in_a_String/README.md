# LeetCode Problem 28: Find the Index of the First Occurrence in a String

## Problem Statement
Given two strings `haystack` and `needle`, return the index of the first occurrence of `needle` in `haystack`.  
If `needle` is not part of `haystack`, return `-1`.

---

## My Solution (Java)

```java
class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0,j=needle.length(); j<=haystack.length(); j++,i++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
```

---

## Explanation
- Use two pointers:  
  - `i` marks the start index of the substring.  
  - `j` marks the end index (`i + needle.length()`).
- Iterate through `haystack` while checking substrings of length equal to `needle`.
- If any substring matches `needle`, return the starting index `i`.
- If no match is found, return `-1`.

---

## Sample Input/Output

### Example 1
**Input:**  
`haystack = "sadbutsad", needle = "sad"`  

**Output:**  
`0`  

### Example 2
**Input:**  
`haystack = "leetcode", needle = "leeto"`  

**Output:**  
`-1`  

---

## Complexity Analysis
- **Time Complexity:** `O((n - m + 1) * m)`  
  Where `n` is the length of `haystack` and `m` is the length of `needle`.  
  In the worst case, we check each substring of length `m`.
- **Space Complexity:** `O(1)`  
  No extra space is used apart from variables.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
