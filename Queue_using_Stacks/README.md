# LeetCode Problem 232: Implement Queue using Stacks

## Problem Statement
Implement a first in, first out (FIFO) queue using only two stacks.  
The implemented queue should support all the functions of a normal queue (`push`, `pop`, `peek`, and `empty`).

---

## My Solution (Java)

```java
class MyQueue {
    Stack<Integer> pri = new Stack<>();
    Stack<Integer> sec = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        pri.push(x);
    }
    
    public int pop() {
        if(!empty()){
            while(pri.size()!=0){
                sec.push(pri.pop());
            } 
            int result = sec.pop();
            while(sec.size()!=0){
                pri.push(sec.pop());
            }
            return result;
        }
        return 0;
    }
    
    public int peek() {
        if(!empty()){
            while(pri.size()!=0){
                sec.push(pri.pop());
            } 
            int result = sec.peek();
            while(sec.size()!=0){
                pri.push(sec.pop());
            }
            return result;
        }
        return 0;
    }
    
    public boolean empty() {
        return pri.size()==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

---

## Explanation
- Two stacks (`pri` and `sec`) are used to simulate queue behavior.
- **Push:** Simply push onto the primary stack.
- **Pop:** Transfer all elements from `pri` to `sec`, pop the top (front of queue), then transfer back.
- **Peek:** Similar to `pop`, but return the top element without removing it.
- **Empty:** Check if the primary stack is empty.

This approach ensures FIFO order using LIFO stacks.

---

## Sample Input/Output

### Example 1
**Input:**  
```
MyQueue q = new MyQueue();
q.push(1);
q.push(2);
q.peek(); // returns 1
q.pop();  // returns 1
q.empty(); // returns false
```

**Output:**  
```
1
1
false
```

---

## Complexity Analysis
- **Time Complexity:**  
  - `push`: `O(1)`  
  - `pop`: `O(n)` (due to transfers)  
  - `peek`: `O(n)`  
  - `empty`: `O(1)`  
- **Space Complexity:** `O(n)`  
  Stacks store all elements.

⚡ Optimized versions exist where amortized `pop` and `peek` are `O(1)` using lazy transfers.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
