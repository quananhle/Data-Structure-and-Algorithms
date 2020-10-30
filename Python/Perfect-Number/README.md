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

### Approach #1 Brute Force
