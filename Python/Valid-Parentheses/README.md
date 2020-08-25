## Valid Parentheses

Given a string containing just the characters ```'(', ')', '{', '}', '[' and ']'```, determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

**Note**: an empty string is also considered valid.

* Example 1:
```
  Input: "()"
  Output: true
```
* Example 2:
```
  Input: "()[]{}"
  Output: true
```
* Example 3:
```
  Input: "(]"
  Output: false
```
* Example 4:
```
  Input: "([)]"
  Output: false
```
* Example 5:
```
  Input: "{[]}"
  Output: true
```
All given inputs are in lowercase letters a-z.


```{python}
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
```



#### Complexity analysis

    Time complexity : O(n) because we simply traverse the given string one character at a time and push and pop operations on a stack take O(1) time.
    Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.

