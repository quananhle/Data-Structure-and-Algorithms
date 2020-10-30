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

### Math approach

```{PYTHON}
    """
    sum(nums): find the sum of all values in nums
    sum(set(nums)): find the sum of all distinct values in nums as set contains no duplicate elements
    len(nums): number of elements in the list
    len(set(nums)): number of elements in the set
    """
    #sum(nums) - sum(set(nums)) yields the total value of the duplicate element
    #len(nums) - len(set(nums)) yields the times the element appears more than once in the list
		return (sum(nums) - sum(set(nums))) / (len(nums) - len(set(nums)))
```

### Follow-ups:

#### 1. How can we prove that at least one duplicate number must exist in nums? 

__Answer:__ we can compare the size of the list with the size of the set that contains the same elements as in list to make sure the size are the same as set contains no duplicate element
```{PYTHON}
    """Check if given list contains any duplicates"""
    if len(nums) != len(set(num)):
        return 0
```

#### 2. Can you solve the problem without modifying the array nums?

__Answer:__ Yes, refer to Math approach
