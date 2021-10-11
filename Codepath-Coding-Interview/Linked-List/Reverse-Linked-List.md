## Reverse Linked List

[Leetcode](https://leetcode.com/problems/reverse-linked-list/)

**Difficulty**: Green

Given the ```head``` of a singly linked list, reverse the list, and return the reversed list.

#### Example 1: 
- Input: head = [1,2,3,4,5]
- Output: [5,4,3,2,1]

![Alt text](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg)

#### Example 2: 
- Input: head = [1], n = 1
- Output: []

#### Example 3: 
- Input: head = []
- Output: []

Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

```Python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        """
        head
        |               
        1       ->      2       ->      3       ->      4       ->      5       ->      None
        """
        prev = None
        while head:
            curr = head
            head = head.next
            curr.next = prev
            prev = curr
        return curr
        """
                    prev            head
                    |               |
        None   <-   1               2       ->      3       ->      4       ->      5       ->      None
                    |
                    curr

                    prev            head
                    |               |
        None   <-   1               2       ->      3       ->      4       ->      5       ->      None
                    |
                    curr

                    prev            head
                    |               |
        None   <-   1               2       ->      3       ->      4       ->      5       ->      None
                    |
                    curr

                    prev            head
                    |               |
        None   <-   1               2       ->      3       ->      4       ->      5       ->      None
                    |
                    curr

                    prev            head
                    |               |
        None   <-   1               2       ->      3       ->      4       ->      5       ->      None
                    |
                    curr
        """
```



