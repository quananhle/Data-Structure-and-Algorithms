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

### Simple Approach 

```{PYTHON}
        nums.sort()
        for i in range(1, len(nums)):
            if (nums[i] == nums[i-1]):
                return nums[i]
```

__Note:__ This approach, however, modified the list as we sort ```nums``` in place, so the memory footprint is constant or O(1). But if we cannot modify the input array, then we must allocate linear space for a copy of ```nums``` and sort that instead, but the space complexity is now O(n).

### Set Approach

```{PYTHON}
        num_set = set()
        for num in nums:
            if num in num_set:
                return num
            num_set.add(num)
```

__Note:__ This approach has ```O(n)``` time complexity, as set in both Python and Java rely on underlying hash tables, so insertion and lookup have amortized constant time complexities. The algorithm is therefore linear, as it consists of a for loop that performs constant work n times. The space complexity is also ```O(n)``` as in the worst case, the duplicate element appears twice, with one of its appearances at array index n−1. In this case, ```num_set``` will contain n−1 distinct values, and will therefore occupy ```O(n)``` space.

### Defaultdict Approach

```{PYTHON}
        res = collections.defaultdict(int)
        for num in nums:
            #defaultdict[key,val] = res[num,cnt]
            res[num] += 1
            #check if any key is counted more than 1
            if res[num] > 1:
                #return key
                return num
```

### Math Approach

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

#### 1. How can we prove that at least one duplicate number must exist in ```nums```? 

__Answer:__ we can compare the size of the list with the size of the set that contains the same elements as in list to make sure the size are the same as set contains no duplicate element

```{PYTHON}
    """Check if given list contains any duplicates"""
    if len(nums) != len(set(num)):
        return 0
```
```{PYTHON}
    """Check if given list contains any duplicates using list.count()"""   
    for num in nums:
        if nums.count(num) > 1:
            #implement the function to find duplicate element
	else:
	    return 0
```

#### 2. Can you solve the problem without modifying the list ```nums```?

__Answer:__ Yes, refer to the ```Math approach``` and the ```defaultdict approach```

#### 3. Can you solve the problem using only constant, ```O(1)``` extra space?

<!--- __Answer:__ Yes, refer to the ```Math approach``` and the ```defaultdict approach``` -->
