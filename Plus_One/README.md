# LeetCode Problem 66: Plus One

## Problem Statement
You are given a large integer represented as an integer array `digits`, where each `digits[i]` is the `i`th digit of the integer.  
The digits are ordered from most significant to least significant in left-to-right order.  
Increment the large integer by one and return the resulting array of digits.

---

## My Solution (Java)

```java
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
```

---

## Explanation
- Start from the last digit (least significant).
- If the digit is less than 9, simply increment it and return the array.
- If the digit is 9, set it to 0 and continue to the next digit to the left.
- If all digits are 9, the loop will set them all to 0.  
  In this case, create a new array with one extra digit, set the first element to 1, and return it.

---

## Sample Input/Output

### Example 1
**Input:**  
`digits = [1,2,3]`  

**Output:**  
`[1,2,4]`  

### Example 2
**Input:**  
`digits = [4,3,2,1]`  

**Output:**  
`[4,3,2,2]`  

### Example 3
**Input:**  
`digits = [9]`  

**Output:**  
`[1,0]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  We may need to traverse all digits once, where `n` is the length of the array.
- **Space Complexity:** `O(1)` (or `O(n)` in the worst case when all digits are 9 and a new array is created).

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
