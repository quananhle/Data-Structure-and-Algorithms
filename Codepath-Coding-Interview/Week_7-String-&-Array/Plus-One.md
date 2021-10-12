## Plus One

[Leetcode](https://leetcode.com/problems/plus-one/)

**Difficulty**: Green

You are given a __large integer__ represented as an integer array ```digits```, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

#### Example 1: 
- Input: num = [1,2,0,0], k = 34
- Output: [1,2,3,4]
- Explanation: 1200 + 34 = 1234

#### Example 2: 
- Input: num = [2,7,4], k = 181
- Output: [4,5,5]
- Explanation: 274 + 181 = 455

#### Example 3: 
- Input: num = [2,1,5], k = 806
- Output: [1,0,2,1]
- Explanation: 215 + 806 = 1021

#### Example 4: 
- Input: num = [9,9,9,9,9,9,9,9,9,9], k = 1
- Output: [1,0,0,0,0,0,0,0,0,0,0]
- Explanation: 9999999999 + 1 = 10000000000

Constraints:

    1 <= num.length <= 104
    0 <= num[i] <= 9
    num does not contain any leading zeros except for the zero itself.
    1 <= k <= 104
    
```Python
class Solution(object):
    def addToArrayForm(self, num, k):
        """
        :type num: List[int]
        :type k: int
        :rtype: List[int]
        """
```



