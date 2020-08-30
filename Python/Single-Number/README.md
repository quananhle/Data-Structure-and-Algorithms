## Single Number
```(python}
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
```
Given a non-empty array of integers, every element appears <i>twice</i> except for one. Find that single one.

**Example 1:**
```
Input: [2,2,1]
Output: 1
```
**Example 2:**
```
Input: [4,1,2,1,2]
Output: 4
```

### Approach 1: List operation

**Algorithm**

    Iterate over all the elements in nums
    If some number in nums is new to array, append it
    If some number is already in the array, remove it

