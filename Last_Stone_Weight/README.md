# LeetCode Problem 1046: Last Stone Weight

## Problem Statement
You are given an array of integers `stones` where each stone has a positive weight.  
At each turn, take the two heaviest stones and smash them together:
- If the stones are equal, both are destroyed.
- If they are unequal, the smaller one is destroyed and the larger one’s weight is reduced by the smaller one’s weight.  

Continue until no more than one stone remains.  
Return the weight of the last remaining stone, or `0` if none remain.

---

## My Solution (Java)

```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->(b-a));
        for (int x : stones){
            heap.offer(x);
        }
        while (heap.size() > 1){
            heap.offer(heap.poll() - heap.poll());
        }
        return heap.poll();
    }
}
```

---

## Explanation
- Use a **max-heap** (`PriorityQueue` with custom comparator) to always access the two heaviest stones.
- Insert all stones into the heap.
- While more than one stone remains:
  - Remove the two heaviest stones.
  - If their weights differ, push the difference back into the heap.
  - If equal, both are destroyed (difference = 0, which is harmless if reinserted).
- At the end, return the last stone’s weight. If no stones remain, return `0`.

---

## Sample Input/Output

### Example 1
**Input:**  
`stones = [2,7,4,1,8,1]`  

**Output:**  
`1`  
Explanation:  
- Smash 7 and 8 → result 1.  
- Smash 4 and 2 → result 2.  
- Smash 1 and 1 → both destroyed.  
- Smash 2 and 1 → result 1.  

### Example 2
**Input:**  
`stones = [1]`  

**Output:**  
`1`  

---

## Complexity Analysis
- **Time Complexity:** `O(n log n)`  
  Each insertion and removal from the heap costs `O(log n)`, repeated for `n` stones.
- **Space Complexity:** `O(n)`  
  Heap stores all stones.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
