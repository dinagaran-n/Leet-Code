# LeetCode Problem 83: Remove Duplicates from Sorted List

## Problem Statement
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.  
Return the linked list sorted as well.

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(head!=null && head.next!=null){     
            if(head.val==head.next.val){
                head.next=head.next.next;
            }
            else{
                head = head.next;
            }
        }
        return cur;
    }
}
```

---

## Explanation
- The list is sorted, so duplicates will always be adjacent.
- Traverse the list using `head`.
- If the current node’s value equals the next node’s value, skip the next node by updating `head.next`.
- Otherwise, move to the next node.
- Continue until the end of the list.
- Return `cur`, which points to the head of the modified list.

---

## Sample Input/Output

### Example 1
**Input:**  
`head = [1,1,2]`  

**Output:**  
`[1,2]`  

### Example 2
**Input:**  
`head = [1,1,2,3,3]`  

**Output:**  
`[1,2,3]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n)`  
  We traverse the list once, where `n` is the number of nodes.
- **Space Complexity:** `O(1)`  
  The operation is done in-place without using extra space.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
