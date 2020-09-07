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

### Approach #1 Sorting.py

**Algorithm**

If nums were in order, it would be easy to see which number is missing. First, we sort nums. Then, we check the two special cases that can be handled in constant time - ensuring that 0 is at the beginning and that n is at the end. Given that those assumptions hold, the missing number must somewhere between (but not including) 0 and n. To find it, we ensure that the number we expect to be at each index is indeed there. Because we handled the edge cases, this is simply the previous number plus 1. Thus, as soon as we find an unexpected number, we can simply return the expected number.

#### Complexity Analysis

* **Time complexity** : O(nlgn)

    The only elements of the algorithm that have asymptotically nonconstant time complexity are the main for loop (which runs in O(n) time), and the sort invocation (which runs in O(nlgn) time for Python and Java). Therefore, the runtime is dominated by sort, and the entire runtime is O(nlgn).

* **Space complexity** : O(1) (or O(n))

    In the sample code, we sorted nums in place, allowing us to avoid allocating additional space. If modifying ```nums``` is forbidden, we can allocate an O(n) size copy and sort that instead.
     
### Approach #2 HashSet.py

**Intuition**: A brute force method for solving this problem would be to simply check for the presence of each number that we expect to be present. The naive implementation might use a linear scan of the array to check for containment, but we can use a HashSet to get constant time containment queries and overall linear runtime.

**Algorithm**: This algorithm is almost identical to the brute force approach, except we first insert each element of nums into a set, allowing us to later query for containment in O(1) time.    

#### Complexity Analysis

* **Time complexity** : O(n)

    Because the set allows for O(1) containment queries, the main loop runs in O(n) time. Creating num_set costs O(n) time, as each set insertion runs in amortized O(1) time, so the overall runtime is O(n+n)=O(n).
    
* **Space complexity** : O(n)

    nums contains n−1 distinct elements, so it costs O(n) space to store a set containing all of them.
    
### Approach #3 XORBit.py

**Intuition**: We can harness the fact that XOR is its own inverse to find the missing element in linear time.

**Algorithm**: Because we know that nums contains n numbers and that it is missing exactly one number on the range [0..n−1][, we know that n definitely replaces the missing number in nums. Therefore, if we initialize an integer to n and XOR it with every index and value, we will be left with the missing number. 

|Index|   0|   1|   2|   3|
|---|---|---|---|---|
|Value|   0|   1|   3|   4|

missing=4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)=(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2=0∧0∧0∧0∧2=2 \begin{aligned} missing &= 4 \wedge (0 \wedge 0) \wedge (1 \wedge 1) \wedge (2 \wedge 3) \wedge (3 \wedge 4) \\ &= (4 \wedge 4) \wedge (0 \wedge 0) \wedge (1 \wedge 1) \wedge (3 \wedge 3) \wedge 2 \\ &= 0 \wedge 0 \wedge 0 \wedge 0 \wedge 2 \\ &= 2 \end{aligned} missing​=4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)=(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2=0∧0∧0∧0∧2=2​
