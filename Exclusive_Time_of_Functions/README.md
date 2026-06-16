# LeetCode Problem 636: Exclusive Time of Functions

## Problem Statement
On a single-threaded CPU, we execute `n` functions. Each function has a unique ID between `0` and `n-1`.  
The function logs are given in a list of strings, where each log is formatted as:  
`"{function_id}:{start_or_end}:{timestamp}"`.  

Return an array where the value at index `i` represents the **exclusive time** of function `i`.  
Exclusive time means the total time spent in the function itself, excluding the time spent in child function calls.

---

## My Solution (Java)

```java
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for(String log : logs){
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String text = parts[1];
            int time = Integer.parseInt(parts[2]);

            if(text.equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += time - prevTime;
                }
                stack.push(id);
                prevTime = time;
            } else {
                result[stack.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return result;
    }
}
```

---

## Explanation
- Use a stack to track active functions.
- `prevTime` keeps track of the last processed timestamp.
- When a function starts:
  - Add the elapsed time since `prevTime` to the currently running function (top of stack).
  - Push the new function ID onto the stack.
  - Update `prevTime`.
- When a function ends:
  - Pop it from the stack.
  - Add its duration (`time - prevTime + 1`) to its result.
  - Update `prevTime` to `time + 1` (since execution resumes after this timestamp).
- Continue until all logs are processed.

---

## Sample Input/Output

### Example 1
**Input:**  
`n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]`  

**Output:**  
`[3,4]`  

Explanation:  
- Function 0 runs from 0–1 and 6–6 → 3 units.  
- Function 1 runs from 2–5 → 4 units.  

### Example 2
**Input:**  
`n = 1, logs = ["0:start:0","0:end:0"]`  

**Output:**  
`[1]`  

---

## Complexity Analysis
- **Time Complexity:** `O(m)`  
  Each log entry is processed once, where `m` is the number of logs.
- **Space Complexity:** `O(n)`  
  Stack stores active functions, at most `n`.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
