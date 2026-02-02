# LeetCode Problem 67: Add Binary

## Problem Statement
Given two binary strings `a` and `b`, return their sum as a binary string.

---

## My Solution (Java)

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry==1){
            if(i>=0){
                carry+=a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                carry+=b.charAt(j)-'0';
                j--;
            }
            sb.append(carry%2);
            carry/=2;
        }
        return sb.reverse().toString();
    }
}
```

---

## Explanation
- Use two pointers `i` and `j` to traverse strings `a` and `b` from right to left.
- Maintain a `carry` to handle binary addition.
- At each step:
  - Add the digit from `a` if `i >= 0`.
  - Add the digit from `b` if `j >= 0`.
  - Append `(carry % 2)` to the result string.
  - Update `carry = carry / 2`.
- Continue until both strings are fully traversed and no carry remains.
- Reverse the result string to get the correct binary sum.

---

## Sample Input/Output

### Example 1
**Input:**  
`a = "11", b = "1"`  

**Output:**  
`"100"`  

### Example 2
**Input:**  
`a = "1010", b = "1011"`  

**Output:**  
`"10101"`  

---

## Complexity Analysis
- **Time Complexity:** `O(max(n, m))`  
  Where `n` and `m` are the lengths of `a` and `b`. We traverse both strings once.
- **Space Complexity:** `O(max(n, m))`  
  The result string builder stores the sum.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
