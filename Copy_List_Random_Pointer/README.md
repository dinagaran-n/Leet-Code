# LeetCode Problem 138: Copy List with Random Pointer

## Problem Statement
A linked list is given where each node contains:
- An integer value `val`
- A pointer `next` to the next node
- A pointer `random` to any node in the list or `null`

Return a **deep copy** of the list.  
The new list should have the same structure and values, but all nodes must be newly created (no shared references with the original list).

---

## My Solution (Java)

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<>();
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
```

---

## Explanation
- Use a **HashMap** to store the mapping between original nodes and their copied nodes.
- **First pass:**  
  - Traverse the list and create a new node for each original node.  
  - Store the mapping in the HashMap.
- **Second pass:**  
  - Assign `next` and `random` pointers for each copied node using the HashMap.
- Finally, return the copied head node.

---

## Sample Input/Output

### Example 1
**Input:**  
`head = [[7,null],[13,0],[11,4],[10,2],[1,0]]`  

**Output:**  
`[[7,null],[13,0],[11,4],[10,2],[1,0]]`  

### Example 2
**Input:**  
`head = []`  

**Output:**  
`[]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each node is visited twice (once for creation, once for pointer assignment).
- **Space Complexity:** `O(n)`  
  HashMap stores mappings for all nodes.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
