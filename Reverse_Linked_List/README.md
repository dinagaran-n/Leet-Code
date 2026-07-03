# LeetCode Problem 206: Reverse Linked List

## Problem Statement
Given the head of a singly linked list, reverse the list and return the new head.

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;   
    }
}
```

---

## Explanation
- Initialize three pointers:
  - `prev` → initially `null` (new tail of the list).
  - `cur` → starts at `head`.
  - `temp` → used to temporarily store the next node.
- Traverse the list:
  - Save the next node in `temp`.
  - Reverse the link (`cur.next = prev`).
  - Move `prev` forward to `cur`.
  - Move `cur` forward to `temp`.
- When traversal ends, `prev` points to the new head of the reversed list.

---

## Sample Input/Output

### Example 1
**Input:**  
`head = [1,2,3,4,5]`  

**Output:**  
`[5,4,3,2,1]`  

### Example 2
**Input:**  
`head = [1,2]`  

**Output:**  
`[2,1]`  

### Example 3
**Input:**  
`head = []`  

**Output:**  
`[]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  Each node is visited once.
- **Space Complexity:** `O(1)`  
  Reversal is done in-place using constant extra space.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
