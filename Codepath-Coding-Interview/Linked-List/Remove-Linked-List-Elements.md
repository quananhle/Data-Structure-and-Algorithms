## Remove Linked List Elements

[Leetcode](https://leetcode.com/problems/remove-linked-list-elements/)

**Difficulty**: Green

Given the ```head``` of a linked list and an integer ```val```, remove all the nodes of the linked list that has ```Node.val == val```, and return the new head.

**Example 1:**

![Alt text](https://assets.leetcode.com/uploads/2021/03/06/removelinked-list.jpg "removelinked-list")

- **Input**: head = [1,2,6,3,4,5,6], val = 6
- **Output**: [1,2,3,4,5]

**Example 2:**

- **Input**: head = [], val = 1
- **Output**: []

**Example 3:**

- **Input**: head = [7,7,7,7], val = 7
- **Output**: []

__Constraints__:

    The number of nodes in the list is in the range [0, 104].
    1 <= Node.val <= 50
    0 <= val <= 50

```Python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        # return the new head requires a sentinel node or a dummy head
        sentinel = ListNode(0)
        # dummy head points to the head of the linked list
        sentinel.next = head
        prev, curr = sentinel, head
        # loop through the linked list
        while curr:
            # if node to be removed found
            if curr.val == val:
                # previous node points to next node
                prev.next = curr.next
            else:
                # otherwise, move up previous node pointer
                prev = curr
            # increment
            curr = curr.next
        return sentinel.next
```
