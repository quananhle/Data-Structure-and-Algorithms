## Delete Node in a Linked List

[Leetcode](https://leetcode.com/problems/delete-node-in-a-linked-list/)

**Difficulty**: Green

Write a function to __delete a node__ in a singly-linked list. You will __not__ be given access to the ```head``` of the list, instead you will be given access to __the node to be deleted__ directly.

It is __guaranteed__ that the node to be deleted is __not a tail node__ in the list.

**Example 1:**
- **Input**: head = [4,5,1,9], node = 5
- **Output**: [4,1,9]
- **Explanation**: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

**Example 2:**
- **Input**: head = [4,5,1,9], node = 1
- **Output**: [4,5,9]
- **Explanation**: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.

**Example 3:**
- **Input**: head = [0,1], node = 0
- **Output**: [1]

**Example 4:**
- **Input**: head = [-3,5,-99], node = -3
- **Output**: [5,-99]

```Python
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next
```
