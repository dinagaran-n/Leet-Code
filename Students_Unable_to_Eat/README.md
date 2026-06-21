# LeetCode Problem 1700: Number of Students Unable to Eat Lunch

## Problem Statement
The school cafeteria provides sandwiches in a specific order.  
Each student prefers either a square (`0`) or a circular (`1`) sandwich.  
The sandwiches are placed in a stack, with the top sandwich being served first.  
Each student in the queue either takes the sandwich if it matches their preference or moves to the end of the queue.  
If no student wants the top sandwich, the process stops.  

Return the number of students who are unable to eat.

---

## My Solution (Java)

```java
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeroCount = 0;
        int oneCount = 0;
        for(int s : students){
            if(s == 0){
                zeroCount++;
            }
            else{
                oneCount++;
            }
        }
        for(int sandwich : sandwiches){
            if(sandwich == 0){
                if(zeroCount == 0){
                    return oneCount;
                }
                zeroCount--;
            }
            else{
                if(oneCount == 0){
                    return zeroCount;
                }
                oneCount--;
            }
        }
        return 0;
    }
}
```

---

## Explanation
- Count the number of students preferring square (`0`) and circular (`1`) sandwiches.
- Iterate through the sandwiches stack:
  - If the sandwich is `0` but no student wants `0`, return the remaining `oneCount`.
  - If the sandwich is `1` but no student wants `1`, return the remaining `zeroCount`.
  - Otherwise, decrement the respective count.
- If all sandwiches are served, return `0`.

This avoids simulating the entire queue rotation and directly checks feasibility.

---

## Sample Input/Output

### Example 1
**Input:**  
`students = [1,1,0,0], sandwiches = [0,1,0,1]`  

**Output:**  
`0`  

### Example 2
**Input:**  
`students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]`  

**Output:**  
`3`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each student and sandwich is processed once.
- **Space Complexity:** `O(1)`  
  Only counters are used.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
