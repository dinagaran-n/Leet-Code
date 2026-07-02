# LeetCode Problem 686: Repeated String Match

## Problem Statement
Given two strings `a` and `b`, return the minimum number of times you must repeat string `a` so that `b` is a substring of the repeated string.  
If no such solution exists, return `-1`.

---

## My Solution (Java)

```java
class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder string = new StringBuilder(a);
        int c = 1;
        while(string.length() < b.length()){
            string.append(a);
            c++;
        }
        if(string.indexOf(b) != -1){
            return c;
        }
        string.append(a);
        c++;
        if(string.indexOf(b) != -1){
            return c;
        }
        return -1;
    }
}
```

---

## Explanation
- Start with `a` and repeat it until its length is at least as long as `b`.
- Check if `b` is a substring of the repeated string:
  - If yes, return the count of repetitions.
  - If not, append one more `a` and check again.
- If still not found, return `-1`.

This ensures that we only need to check up to `len(b)/len(a) + 2` repetitions.

---

## Sample Input/Output

### Example 1
**Input:**  
`a = "abcd", b = "cdabcdab"`  

**Output:**  
`3`  
Explanation: `"abcdabcdabcd"` contains `"cdabcdab"`.

### Example 2
**Input:**  
`a = "a", b = "aa"`  

**Output:**  
`2`  

### Example 3
**Input:**  
`a = "abc", b = "wxyz"`  

**Output:**  
`-1`  

---

## Complexity Analysis
- **Time Complexity:** `O(n + m)`  
  Where `n = len(a)` and `m = len(b)`. String building and substring search are linear.
- **Space Complexity:** `O(n + m)`  
  StringBuilder stores repeated strings.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
