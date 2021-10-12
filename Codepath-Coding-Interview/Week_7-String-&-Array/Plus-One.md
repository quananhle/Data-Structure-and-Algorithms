## Add to Array-Form of Integer

[Leetcode](https://leetcode.com/problems/add-to-array-form-of-integer/)

**Difficulty**: Green

The __array-form__ of an integer ```num``` is an array representing its digits in left to right order.

    For example, for num = 1321, the array form is [1,3,2,1].

Given ```num```, the ___array-form___ of an integer, and an integer ```k```, return the __array-form__ of the integer ```num + k```.

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



