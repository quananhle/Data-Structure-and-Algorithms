## Remove Duplicates from Sorted List

[Leetcode](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

**Difficulty**: Green

Given the ```head``` of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list __sorted__ as well.

**Example 1:**

![image](https://assets.leetcode.com/uploads/2021/01/04/list1.jpg)

- **Input**: head = [1,1,2]
- **Output**: [1,2]

**Example 2:**

![image](https://assets.leetcode.com/uploads/2021/01/04/list2.jpg)

- **Input**: head = [1,1,2,3,3]
- **Output**: [1,2,3]

### Constraints:

- The number of nodes in the list is in the range [0, 300].
- -100 <= Node.val <= 100
- The list is guaranteed to be sorted in ascending order.

```Python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = head
        while head and head.next:
            if head.val == head.next.val:
                head.next = head.next.next
            else:
                head = head.next
        return dummy
```

