## Middle of the Linked List

[Leetcode](https://leetcode.com/problems/middle-of-the-linked-list/)

**Difficulty**: Green

Given the ```head``` of a singly linked list, return the _middle node of the linked list_. If there are two middle nodes, return the __second middle node__.

#### Example 1: 
- Input: head = [1,2,3,4,5]
- Output: [3,4,5]
- Explanation: The middle node of the list is node 3.

![Alt text](https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg)

#### Example 2: 
- Input: head = [1,2,3,4,5,6]
- Output: [4,5,6]
- Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

![Alt text](https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg)

Constraints:

    The number of nodes in the list is in the range [1, 100].
    1 <= Node.val <= 100

    
```Python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def middleNode(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
```

