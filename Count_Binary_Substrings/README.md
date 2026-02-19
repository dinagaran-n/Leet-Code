# LeetCode Problem 696: Count Binary Substrings

## Problem Statement
Given a binary string `s`, return the number of non-empty substrings that have the same number of `0`s and `1`s, and all the `0`s and all the `1`s in these substrings are grouped consecutively.  
The substrings must be contiguous.

---

## My Solution (Java)

```java
class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0;
        int cur = 1;
        int result = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cur+=1;
            }
            else{
                result+= Math.min(prev,cur);
                prev=cur;
                cur=1;
            }
        }
        result+= Math.min(prev,cur);
        return result;
    }
}
```

---

## Explanation
- Track consecutive groups of identical characters (`0`s or `1`s).
- `cur` counts the length of the current group, `prev` stores the length of the previous group.
- When the character changes:
  - Add `Math.min(prev, cur)` to the result (because the number of valid substrings is limited by the smaller group).
  - Update `prev = cur` and reset `cur = 1`.
- After the loop, add `Math.min(prev, cur)` one last time.
- Return the total count.

---

## Sample Input/Output

### Example 1
**Input:**  
`s = "00110011"`  

**Output:**  
`6`  
Explanation: The substrings are `"0011"`, `"01"`, `"1100"`, `"10"`, `"0011"`, `"01"`.

### Example 2
**Input:**  
`s = "10101"`  

**Output:**  
`4`  
Explanation: The substrings are `"10"`, `"01"`, `"10"`, `"01"`.

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each character is processed once, where `n` is the length of the string.
- **Space Complexity:** `O(1)`  
  Only a few integer variables are used.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
