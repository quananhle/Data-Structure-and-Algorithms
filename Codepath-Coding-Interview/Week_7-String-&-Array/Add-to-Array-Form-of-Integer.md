## Add to Array-Form of Integer

[Leetcode](https://leetcode.com/problems/add-to-array-form-of-integer/)

**Difficulty**: Green

The __array-form__ of an integer ```num``` is an array representing its digits in left to right order.

    For example, for num = 1321, the array form is [1,3,2,1].

Given ```num```, the ___array-form___ of an integer, and an integer ```k```, return the __array-form__ of the integer ```num + k```.

#### Example 1: 
- Input: num = [1,2,0,0], k = 34
- Output: [1,2,3,4]
- Explanation: 1200 + 34 = 1234

![Alt text](https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg)

#### Example 2: 
- Input: num = [2,7,4], k = 181
- Output: [4,5,5]
- Explanation: 274 + 181 = 455

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


