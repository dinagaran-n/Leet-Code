# LeetCode Problem 2073: Time Needed to Buy Tickets

## Problem Statement
There are `n` people in a queue, where the `i`‑th person has `tickets[i]` tickets to buy.  
Each person buys **one ticket at a time** and then moves to the end of the queue if they still have tickets left.  
The person at index `k` is the one you care about.  
Return the time it takes for the person at index `k` to finish buying all their tickets.

---

## My Solution (Java)

```java
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int t = 0;
        for(int i=0;i<tickets.length;i++){
            if(i<=k){
                t += Math.min(tickets[i], tickets[k]);
            }
            else{
                t += Math.min(tickets[i], tickets[k]-1);
            }
        }
        return t;
    }
}
```

---

## Explanation
- The key observation:  
  - People before or at index `k` can buy up to `tickets[k]` tickets.  
  - People after index `k` can buy at most `tickets[k] - 1` tickets (because person `k` finishes before they can buy their last one).  
- Iterate through all people:
  - If `i <= k`, add `min(tickets[i], tickets[k])` to the total time.  
  - If `i > k`, add `min(tickets[i], tickets[k] - 1)`.  
- Return the accumulated time.

---

## Sample Input/Output

### Example 1
**Input:**  
`tickets = [2,3,2], k = 2`  

**Output:**  
`6`  
Explanation: Person 2 finishes after 6 seconds.

### Example 2
**Input:**  
`tickets = [5,1,1,1], k = 0`  

**Output:**  
`8`  
Explanation: Person 0 buys all 5 tickets in 8 seconds.

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each person is processed once.
- **Space Complexity:** `O(1)`  
  Only a counter variable is used.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
