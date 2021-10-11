## Palindrome Linked List

[Leetcode](https://leetcode.com/problems/palindrome-linked-list/)

**Difficulty**: Green

Given the ```head``` of a singly linked list, return ```true``` if it is a palindrome.

#### Example 1: 
- Input: head = [1,2,2,1]
- Output: true

![Alt text](https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg)

#### Example 2: 
- Input: head = [1,2]
- Output: false

![Alt text](https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg)

Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?

```Python
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
```




