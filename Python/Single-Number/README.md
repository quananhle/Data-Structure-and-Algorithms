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

### Approach 1: List

**Algorithm**

    Iterate over all the elements in nums
    If some number in nums is new to array, append it
    If some number is already in the array, remove it

Complexity Analysis

* Time complexity : O(n<sup>2</sup>). We iterate through nums, taking O(n) time. We search the whole list to find whether there is duplicate number, taking O(n) time. Because search is in the for loop, so we have to multiply both time complexities which is O(n<sup>2</sup>).

* Space complexity : O(n). We need a list of size n to contain elements in nums. 

### Approach 2: Hash Table

**Algorithm**

We use hash table to avoid the O(n) time required for searching the elements.

    Iterate through all elements in nums and set up key/value pair.
    Return the element which appeared only once.

Complexity Analysis

* Time complexity : O(n⋅1) = O(n). Time complexity of for loop is O(n). Time complexity of hash table(dictionary in python) operation pop is O(1).

* Space complexity : O(n). The space required by hash_table is equal to the number of elements in nums.


