# LeetCode Problem 21: Merge Two Sorted Lists

## Problem Statement
You are given the heads of two sorted linked lists `list1` and `list2`.  
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.  
Return the head of the merged linked list.

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode cur = null;
        ListNode result = null;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                if(cur==null){
                    cur=list1;
                    result=cur;
                }
                else{
                    cur.next=list1;
                    cur= cur.next;
                }
                list1=list1.next;
            }
            else{
                if(cur==null){
                    cur=list2;
                    result=cur;
                }
                else{
                    cur.next=list2;
                    cur= cur.next;
                }
                list2=list2.next;
            }
        }
        while(list1!=null){
            cur.next=list1;
            cur=cur.next;
            list1=list1.next;
        }
        while(list2!=null){
            cur.next=list2;
            cur=cur.next;
            list2=list2.next;
        }
        return result;
    }
}
```

---

## Explanation
- If either list is `null`, return the other list immediately.
- Use two pointers:  
  - `cur` to track the current node in the merged list.  
  - `result` to store the head of the merged list.  
- Compare nodes from both lists and attach the smaller one to the merged list.
- Continue until one list is exhausted, then attach the remaining nodes from the other list.
- Return `result` as the head of the merged sorted list.

---

## Sample Input/Output

### Example 1
**Input:**  
`list1 = [1,2,4], list2 = [1,3,4]`  

**Output:**  
`[1,1,2,3,4,4]`  

### Example 2
**Input:**  
`list1 = [], list2 = []`  

**Output:**  
`[]`  

### Example 3
**Input:**  
`list1 = [], list2 = [0]`  

**Output:**  
`[0]`  

---

## Complexity Analysis
- **Time Complexity:** `O(n + m)`  
  We traverse both lists once, where `n` and `m` are the lengths of `list1` and `list2`.
- **Space Complexity:** `O(1)`  
  The merge is done in-place without extra data structures.

---

## Author
- **Name:** Dinagaran N  
- **College:** RIT Chennai
