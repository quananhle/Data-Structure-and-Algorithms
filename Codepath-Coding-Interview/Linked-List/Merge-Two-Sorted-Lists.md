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
            Input: 1 -> 2 -> 4, 1 -> 3 -> 5
            Output: 1 -> 1 -> 2 -> 3 -> 4 -> 5
        
        Match
            Linked List
        
        Plan
            - Dummy-head + Two-pointer
            Left pointer                List1
            |                           |
            Dummy                       1 -> 2 -> 4
            
            Head                        1 -> 3 -> 5
            |                           |
            Right pointer               List2
        """
        
        head = ListNode()
        dummy = head
        # head = dummy = ListNode()
        while list1 and list2:
            if list1.val < list2.val:
                dummy.next = list1
                dummy = list1
                list1 = list1.nextt
            else:
                dummy.next = list2
                dummy = list2
                list2 = list2.next

        dummy.next = list1 if list1 else list2
        return head.next
        """
        Step 1: list1.val = list2.val

                Left pointer          List1
                |                     |
                Dummy     0 --> 1 --> 2 --> 4
                |               ^
                |_______________|
                                ^
                                |
                Head  --> 0 -----           1 --> 3 --> 5
                |                           |
                Right pointer               List2

        Step 2: list1.val > list2.val

                Left pointer              List1
                |                         |
                Dummy     0 --> 1 -----   2 --> 4
                |               ^     |
                |_______________|__   |
                                |  |  |
                                |  |  |
                Head  --> 0 -----  |  |---> 1 --> 3 --> 5
                |                  |        ^     |
                |                  |________|     |
                Right pointer                     List2

        Step 3: list1.val < list2.val

                Left pointer                                List1
                |       |-----------------|                 |
                Dummy --| 0 --> 1 -----   |---------> 2 --> 4
                                ^     |               ^
                                |     |               |
                                |     |               |
                                |     |               |
                Head  --> 0 -----     |-------------> 1     3 --> 5
                |                                           |
                |                                           |
                Right pointer                               List2

        Step 4: list1.val > list2.val

                Left pointer                                        List1
                |                                                   |
                Dummy     0 --> 1 -----              2 ------       4
                |               ^     |              ^      |
                |_______________|__   |              |      |
                                |  |  |              |      |
                                |  |  |              |      |      
                Head  --> 0 -----  |  |------------> 1      |----> 3 --> 5
                |                  |                               ^     |
                |                  |_______________________________|     |
                Right pointer                                            List2

        Step 5: list1.val < list2.val

                Left pointer                                                        List1
                |       |-------------------------------------------                |
                Dummy --| 0 --> 1 -----              2 ------      |------> 4       None
                                ^     |              ^      |               ^
                                |     |              |      |               |
                                |     |              |      |               |
                                |     |              |      |               |
                Head  --> 0 -----     |------------> 1      |-------------> 3       5
                |                                                                   |
                |                                                                   |
                Right pointer                                                       List2

        Step 6: dummy.next = list2

                Left pointer                                                                List1
                |       |-------------------------------------------                        |
                Dummy --| 0 --> 1 -----              2 ------      |------> 4 -------       None
                                ^     |              ^      |               ^       |
                                |     |              |      |               |       |
                                |     |              |      |               |       |
                                |     |              |      |               |       |
                Head  --> 0 -----     |------------> 1      |-------------> 3       |-----> 5
                |                                                                           |
                |                                                                           |
                Right pointer                                                               List2

        Step 7: return head.next

                 --------------------> 1              2 ------               4 -------
                |                      |              ^      |               ^       |
                |                      |              |      |               |       |
                |                      |              |      |               |       |
                |                      |              |      |               |       |
                Head                   -------------> 1      --------------> 3       ------> 5
        """        
```
