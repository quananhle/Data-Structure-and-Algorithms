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
```
