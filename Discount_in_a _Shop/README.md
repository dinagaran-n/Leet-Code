# LeetCode Problem 1475: Final Prices With a Special Discount in a Shop

## Problem Statement
Given an array of integers `prices` where `prices[i]` is the price of the `i`‑th item in a shop,  
there is a special discount for each item: you pay the price minus the first smaller or equal price that appears later in the array.  
If no such price exists, you pay the original price.  

Return an array `answer` where `answer[i]` is the final price you will pay for the `i`‑th item.

---

## My Solution (Java)

```java
class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = prices[i];
            for(int j=i+1;j<n;j++){
                if(prices[j] <= prices[i]){
                    answer[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return answer;
    }
}
```

---

## Explanation
- For each item `i`, check the next items `j > i`.
- If a smaller or equal price is found, subtract it from `prices[i]` and store in `answer[i]`.
- If no such price exists, keep `answer[i] = prices[i]`.
- This brute force approach works but can be optimized using a monotonic stack.

---

## Sample Input/Output

### Example 1
**Input:**  
`prices = [8,4,6,2,3]`  

**Output:**  
`[4,2,4,2,3]`  

### Example 2
**Input:**  
`prices = [1,2,3,4,5]`  

**Output:**  
`[1,2,3,4,5]`  

### Example 3
**Input:**  
`prices = [10,1,1,6]`  

**Output:**  
`[9,0,1,6]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n^2)` in the brute force version.  
  Each item may scan all later items.
- **Space Complexity:** `O(n)` for the result array.  

⚡ Optimized solutions using a monotonic stack can achieve `O(n)` time.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
