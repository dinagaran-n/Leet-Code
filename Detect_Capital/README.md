# LeetCode Problem 520: Detect Capital

## Problem Statement
We define the usage of capitals in a word to be correct if one of the following cases holds:
1. All letters in the word are capitals (e.g., `"USA"`).
2. All letters in the word are not capitals (e.g., `"leetcode"`).
3. Only the first letter in the word is capital (e.g., `"Google"`).  

Return `true` if the given word uses capitals correctly, otherwise return `false`.

---

## My Solution (Java)

```java
class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 0 || word.length() == 1) return true;
        if(Character.isUpperCase(word.charAt(0))){
            boolean isFirstChar = Character.isUpperCase(word.charAt(1));
            for(int i=2; i<word.length();i++){
                boolean curCharState = Character.isUpperCase(word.charAt(i));
                if(curCharState != isFirstChar) return false;
            }
        }
        else{
            for(int i=1; i<word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }
}
```

---

## Explanation
- If the word length is 0 or 1, return `true` (trivially valid).
- If the first character is uppercase:
  - Check the second character’s case.
  - All subsequent characters must match the case of the second character (either all uppercase or all lowercase).
- If the first character is lowercase:
  - Ensure all remaining characters are lowercase.
- Return `true` if all conditions are satisfied.

---

## Sample Input/Output

### Example 1
**Input:**  
`word = "USA"`  

**Output:**  
`true`  

### Example 2
**Input:**  
`word = "leetcode"`  

**Output:**  
`true`  

### Example 3
**Input:**  
`word = "Google"`  

**Output:**  
`true`  

### Example 4
**Input:**  
`word = "FlaG"`  

**Output:**  
`false`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each character is checked once.
- **Space Complexity:** `O(1)`  
  Only a few variables are used.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
