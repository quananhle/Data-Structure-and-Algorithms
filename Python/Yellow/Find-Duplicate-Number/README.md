## Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one duplicate number in nums, return this duplicate number.

```{PYTHON}
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
```

### Simple approach

```{PYTHON}
        nums.sort()
        res = collections.defaultdict(int)
        for num in nums:
            res[num] += 1
            if res[num] > 1:
                return num
```
