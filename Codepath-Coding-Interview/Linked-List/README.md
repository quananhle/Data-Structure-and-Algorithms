# Linked List

### Linked List Class

```Python
class LinkedListNode:
  def __init__(self, value):
      self.next = None
      self.value = value
```
- You only need a value in order to initialize a node
    * *next* and *prev* (if doubly linked-list)
- Majority of linked list coding questions is singly linked list

### Linked List: Things To Know

![Alt text](https://github.com/Quananhle/Data-Structure-and-Algorithms/blob/master/Codepath-Coding-Interview/photos/LL.png "LL")

- All problems deal with pointer-manipulation and traversing the list
- Most problems require you to use O(1) space
- Common patterns in solving these problems:
    * Dummy-head
    * Two-pointer
    * Multi-pass

    #### Two-Pointer
    - Use two/multiple pointers to manipulate references to nodes (e.g. reversing a linked list)
    - Also used to get/infer certaint information about list (e.g. detect cycle)
    
    #### Dummy-head
    - Create a 'dummy head' node and construct a list using its next pointer
    - Return ```dummyHead.next``` to return the newly constructed list
    - Very useful when you need to manipulate pointers and create a list with the same nodes but different ordering
    - Very useful for edge-cases
    
    #### Multi-pass
    - Useful if you can guarantee constant amount of passes or if you need to know the length of the list
    - Linked List Reverse
        * Adding two list together
        * LL Palindrome
