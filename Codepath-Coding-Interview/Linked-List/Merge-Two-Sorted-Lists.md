## Merge Two Sorted Lists

[Leetcode](https://leetcode.com/problems/merge-two-sorted-lists/)

**Difficulty**: Green

You are given the heads of two sorted linked lists ```list1``` and ```list2```.

Merge the two lists in a one __sorted__ list. The list should be made by splicing together the nodes of the first two lists.

Return the _head of the merged linked list_.

**Example 1:**

![image](https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg)

- **Input**: list1 = [1,2,4], list2 = [1,3,4]
- **Output**: [1,1,2,3,4,4]

**Example 2:**
- **Input**: list1 = [], list2 = []
- **Output**: []

**Example 3:**
- **Input**: list1 = [], list2 = [0]
- **Output**: [0]

#### Constraints:
```
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
```

```Python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeTwoLists(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        """
        Understand
            Input: 1 -> 2 -> 3 -> 4 -> 5 n = 1
            Output: 1 -> 2 -> 3 -> 4
            Input: 1 -> 2 -> 3 -> 4 -> 5 n = 5
            Output: 2 -> 3 -> 4 -> 5
            Input: 1 -> 2 -> 3 -> 4 -> 5 n = 6
            Output: Invalid Testcase, expected 'n' to have value from 1 to 5 only
        
        Match
            Linked List
        
        Plan
            - Multi-pass
            Get length of LL in one-pass, increment pointer length-n times. 
            You are at the node you want to delete. 
            Just keep track of the previous node and remove the node you are at.
            
            - Dummy-head + Two-pointer
            Left pointer                 Right pointer 
            |                            |
            Dummy -> 1 -> 2 -> 3 -> 4 -> 5

            Separate two pointers by n nodes, one at head node and one at n nodes apart
            Move two pointers to the end of the LL
            Once right pointer reaches the end, then left pointer is the node to delete
            To make it easy deleting the head of the list, use a dummyhead
        """
        
        head = ListNode(-1)
        dummy = head
        # head = dummy = ListNode()
        while list1 and list2:
            if list1.val < list2.val:
                dummy.next = list1
                list1 = list1.next
            else:
                dummy.next = list2
                list2 = list2.next
            dummy = dummy.next
        dummy.next = list1 if list1 else list2
        return head.next
```
