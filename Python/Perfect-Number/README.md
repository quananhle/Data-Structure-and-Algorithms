## Perfect Number

**Code:** Green

A __perfect number__ is a positive integer that is equal to the sum of its __positive divisors__, excluding the number itself. A __divisor__ of an integer ```x``` is an integer that can divide ```x``` evenly.

Given an integer ```n```, return ```true``` if ```n``` is a perfect number, otherwise return false.

```{python}
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
```

__Example 1__:
```
Input: num = 28
Output: true
Explanation: 28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, and 14 are all divisors of 28.
```

__Example 2__: 
```
Input: num = 6
Output: true
```

__Example 3__:
```
Input: num = 496
Output: true
```
__Example 4__:
```
Input: num = 8128
Output: true
```

### Approach #1 BruteForce:

__Algorithm__:
In brute force approach, we consider every possible number to be a divisor of the given number numnumnum, by iterating over all the numbers lesser than numnumnum. Then, we add up all the factors to check if the given number satisfies the Perfect Number property. This approach obviously fails if the number ```num``` is very large. We can little optimize the brute force by breaking out of the loop early when the value of ```sum``` larger than the value of ```num```. In that case, we can directly return ```false```.

#### Complexity Analysis

    Time complexity : O(n). In worst case, we iterate over all the numbers lesser than n.

    Space complexity : O(1). Constant extra space is used.
    
### Approach #2 NinjaBruteForce:

__Algorithm__:

Similar to approach 1, but we only consider half of ```num``` as all perfect numbers has 2 as the positive divisor number.

#### Complexity Analysis

    Time complexity : O(n). Even though it is n/2, the time complexity is O(n/2) = O(n).

    Space complexity : O(1). Constant extra space is used.
    
### Approach #3 PowerMethod:

__Algorirthm__:

![Alt text](power.png?raw=true "main")

Complexity Analysis

    Time complexity : O(sqrt(n)). We iterate only over the range 1 < i ≤ sqrt(num).

    Space complexity : O(1). Constant extra space is used.
