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
            #defaultdict[key,val] = res[num,cnt]
            res[num] += 1
            #check if any key is counted more than 1
            if res[num] > 1:
                #return key
                return num
```

### Follow-ups:

#### 1. How can we prove that at least one duplicate number must exist in nums? 

