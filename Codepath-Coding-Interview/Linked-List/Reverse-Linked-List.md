## Reverse Linked List

[Leetcode](https://leetcode.com/problems/reverse-linked-list/)

**Difficulty**: Green

Given the ```head``` of a singly linked list, reverse the list, and return the reversed list.

#### Example 1: 
- Input: head = [1,2,3,4,5]
- Output: [5,4,3,2,1]

[Alt text](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg)

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
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
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
        # check if head is null
        if not head:
            return None
        # create a dummy head
        dummyHead = ListNode(-1)
        # point dummy head to the head node of LL
        dummyHead.next = head
        # initialize two pointers
        left = right = dummyHead
        # move right pointer n nodes apart
        for i in range (n):
            right = right.next
        # move both nodes at the same time until the right node reaches the end of LL
        while right.next != None:
            left = left.next
            right = right.next
        # delete the left.next node
        left.next = left.next.next
        # always return dummyHead.next
        return dummyHead.next
```

