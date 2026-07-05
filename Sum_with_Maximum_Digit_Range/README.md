# LeetCode Problem 3982: Sum of Integers with Maximum Digit Range

## Problem Statement
You are given an array of integers `nums`.  
For each integer, define its **digit range** as the difference between its maximum digit and minimum digit.  
Find the sum of all integers in `nums` that have the maximum digit range among all numbers in the array.  

---

## My Solution (Java)

```java
class Solution {
    public int sumOfIntegersWithMaximumDigitRange(int[] nums) {
        int maxRange = -1;
        int sum = 0;

        for (int num : nums) {
            int range = digitRange(num);

            if (range > maxRange) {
                maxRange = range;
                sum = num;
            } else if (range == maxRange) {
                sum += num;
            }
        }

        return sum;
    }

    private int digitRange(int num) {
        int maxDigit = 0;
        int minDigit = 9;

        while (num > 0) {
            int digit = num % 10;
            maxDigit = Math.max(maxDigit, digit);
            minDigit = Math.min(minDigit, digit);
            num /= 10;
        }

        return maxDigit - minDigit;
    }
}
```

---

## Explanation
- For each number in `nums`, compute its **digit range**:
  - Extract digits one by one.
  - Track the maximum and minimum digit.
  - Return the difference (`maxDigit - minDigit`).
- Compare the digit range with the current maximum:
  - If greater, update `maxRange` and reset `sum` to the current number.
  - If equal, add the number to `sum`.
- Return the final sum of numbers with the maximum digit range.

---

## Sample Input/Output

### Example 1
**Input:**  
`nums = [123, 98, 45]`  

**Output:**  
`123`  
Explanation:  
- `123` → digits {1,2,3}, range = 3-1 = 2  
- `98` → digits {9,8}, range = 9-8 = 1  
- `45` → digits {4,5}, range = 5-4 = 1  
Maximum digit range = 2 → sum = 123  

### Example 2
**Input:**  
`nums = [29, 83, 47]`  

**Output:**  
`29`  
Explanation:  
- `29` → range = 9-2 = 7  
- `83` → range = 8-3 = 5  
- `47` → range = 7-4 = 3  
Maximum digit range = 7 → sum = 29  

---

## Complexity Analysis
- **Time Complexity:** `O(n * d)`  
  Where `n` is the number of integers and `d` is the number of digits per integer.
- **Space Complexity:** `O(1)`  
  Only a few variables are used.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
