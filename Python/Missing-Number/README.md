## Missing Number

```{python}
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
```

Given an array containing n distinct numbers taken from ```0, 1, 2, ..., n``` find the one that is missing from the array.

**Example 1:**
```
Input: [3,0,1]
Output: 2
```
**Example 2:**
```
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
```
**Note:** The algorithm should run in linear runtime complexity.

#### Complexity Analysis

* **Time complexity** : O(nlgn)

    The only elements of the algorithm that have asymptotically nonconstant time complexity are the main for loop (which runs in O(n) time), and the sort invocation (which runs in O(nlgn) time for Python and Java). Therefore, the runtime is dominated by sort, and the entire runtime is O(nlgn).

* **Space complexity** : O(1) (or O(n))

    In the sample code, we sorted nums in place, allowing us to avoid allocating additional space. If modifying ```nums``` is forbidden, we can allocate an O(n) size copy and sort that instead.
