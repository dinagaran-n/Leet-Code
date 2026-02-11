# LeetCode Problem 3: Longest Substring Without Repeating Characters

## Problem Statement
Given a string `s`, find the length of the longest substring without repeating characters.

---

## My Solution (Java)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxlen = Math.min(s.length(),1);
        while(end<s.length()){
            char c = s.charAt(end);
            while(seen.contains(c)){
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(s.charAt(end));
            int windowSize = end-start+1;
            maxlen = Math.max(maxlen,windowSize);
            end++;
        }
        return maxlen;
    }
}
```

---

## Explanation
- Use a sliding window approach with two pointers (`start` and `end`).
- Maintain a `HashSet` to store characters in the current window.
- If the character at `end` is already in the set, shrink the window from the left (`start++`) until the duplicate is removed.
- Add the current character to the set and update the maximum window size.
- Continue until the end of the string is reached.
- Return the maximum length found.

---

## Sample Input/Output

### Example 1
**Input:**  
`s = "abcabcbb"`  

**Output:**  
`3`  
Explanation: The answer is `"abc"`, with length 3.

### Example 2
**Input:**  
`s = "bbbbb"`  

**Output:**  
`1`  
Explanation: The answer is `"b"`, with length 1.

### Example 3
**Input:**  
`s = "pwwkew"`  

**Output:**  
`3`  
Explanation: The answer is `"wke"`, with length 3.

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each character is processed at most twice (once added, once removed).
- **Space Complexity:** `O(min(n, a))`  
  Where `a` is the size of the character set (e.g., 26 for lowercase letters, 128 for ASCII).

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
