# LeetCode Problem 2: Add Two Numbers

## Problem Statement
You are given two non-empty linked lists representing two non-negative integers.  
The digits are stored in reverse order, and each node contains a single digit.  
Add the two numbers and return the sum as a linked list.  
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int v1 = (l1==null)?0:l1.val;
            int v2 = (l2==null)?0:l2.val;
            int sum = v1+v2+carry;
            carry = sum/10;
            int digit = sum%10;
            l3.next = new ListNode(digit);
            l3 = l3.next;
            l1 = (l1!=null)?l1.next:null;
            l2 = (l2!=null)?l2.next:null;
        }
        return head.next;
    }
}
```

---

## Explanation
- Initialize a dummy node `l3` to build the result list, with `head` pointing to it.
- Maintain a `carry` to handle sums greater than 9.
- Traverse both lists until all digits and carry are processed:
  - Extract values from `l1` and `l2` (use 0 if null).
  - Compute `sum = v1 + v2 + carry`.
  - Update `carry = sum / 10` and `digit = sum % 10`.
  - Create a new node with `digit` and attach it to the result list.
  - Move to the next nodes in `l1` and `l2`.
- Return `head.next` (skipping the dummy node).

---

## Sample Input/Output

### Example 1
**Input:**  
`l1 = [2,4,3], l2 = [5,6,4]`  

**Output:**  
`[7,0,8]`  
Explanation: 342 + 465 = 807.

### Example 2
**Input:**  
`l1 = [0], l2 = [0]`  

**Output:**  
`[0]`  

### Example 3
**Input:**  
`l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]`  

**Output:**  
`[8,9,9,9,0,0,0,1]`  

---

## Complexity Analysis
- **Time Complexity:** `O(max(n, m))`  
  Where `n` and `m` are the lengths of `l1` and `l2`. Each node is processed once.
- **Space Complexity:** `O(max(n, m))`  
  A new linked list is created to store the result.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
