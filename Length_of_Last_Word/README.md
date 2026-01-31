# LeetCode Problem 58: Length of Last Word

## Problem Statement
Given a string `s` consisting of words and spaces, return the length of the last word in the string.  
A word is defined as a maximal substring consisting of non-space characters only.

---

## My Solution (Java)

```java
class Solution {
    public int lengthOfLastWord(String s) {
        String[] strArr = s.split(" ");
        return strArr[strArr.length-1].length();
    }
}
```

---

## Explanation
- Split the string `s` into an array of words using `" "` (space) as the delimiter.
- The last element of the array (`strArr[strArr.length - 1]`) will be the last word.
- Return the length of this last word.

---

## Sample Input/Output

### Example 1
**Input:**  
`s = "Hello World"`  

**Output:**  
`5`  

### Example 2
**Input:**  
`s = "   fly me   to   the moon  "`  

**Output:**  
`4`  

### Example 3
**Input:**  
`s = "luffy is still joyboy"`  

**Output:**  
`6`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Splitting the string requires traversing all characters, where `n` is the length of `s`.
- **Space Complexity:** `O(n)`  
  The split operation creates an array of words.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
