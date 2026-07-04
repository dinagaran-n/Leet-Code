# LeetCode Problem 328: Odd Even Linked List

## Problem Statement
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.  
The first node is considered odd, the second node even, and so on.  

---

## My Solution (Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head; 
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
```

---

## Explanation
- If the list is empty or has only one node, return it directly.
- Maintain two pointers:
  - `odd` → tracks odd-indexed nodes.
  - `even` → tracks even-indexed nodes.
- Save the head of the even list (`evenHead`) to connect later.
- Rearrange links:
  - Move `odd.next` to skip over even nodes.
  - Move `even.next` to skip over odd nodes.
- Continue until no more pairs remain.
- Finally, connect the last odd node to the head of the even list.

---

## Sample Input/Output

### Example 1
**Input:**  
`head = [1,2,3,4,5]`  

**Output:**  
`[1,3,5,2,4]`  

### Example 2
**Input:**  
`head = [2,1,3,5,6,4,7]`  

**Output:**  
`[2,3,6,7,1,5,4]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each node is visited once.
- **Space Complexity:** `O(1)`  
  Reordering is done in-place.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
