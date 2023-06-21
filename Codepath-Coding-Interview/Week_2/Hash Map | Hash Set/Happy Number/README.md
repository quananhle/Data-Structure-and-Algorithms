## [202. Happy Number](https://leetcode.com/problems/happy-number)

```Tag```: ```Hash Set``` ```Floyd's Cycle-Finding Algorithm```

#### Difficulty: Medium

Write an algorithm to determine if a number ```n``` is happy.

A __happy number__ is a number defined by the following process:

- Starting with any positive integer, replace the number by the sum of the squares of its digits.
- Repeat the process until the number equals 1 (where it will stay), or it __loops endlessly in a cycle__ which does not include 1.
- Those numbers for which this process __ends in 1__ are happy.

Return _```true``` if ```n``` is a happy number, and ```false``` if not_.

![image](https://user-images.githubusercontent.com/35042430/222334290-31501ada-37f2-4035-b36a-16d4ef6f7492.png)

---

__Example 1:__
```
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```

__Example 2:__
```
Input: n = 2
Output: false
```

__Constraints:__

- 1 <= ```n``` <= 2<sup>31</sup> - 1

---

### Hash Set

![image](https://leetcode.com/problems/happy-number/Figures/202/image2.png)

#### List Comprehension

```Python
class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        happy_number = 0
        
        while True:
            if n in seen:
                return False
            seen.add(n)
            
            digits = list(str(n))
            happy_number = sum([int(digit)**2 for digit in digits])
            if happy_number == 1:
                break
            n = happy_number
            
        return True
```

```Python
class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while True:
            nums = [int(digit)**2 for digit in str(n)]
            n = sum(nums)
            if n in seen:
                return False
            elif n == 1:
                return True
            seen.add(n)
```

```Python
class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while n != 1:
            nums = [int(digit)**2 for digit in str(n)]
            n = sum(nums)
            if n in seen:
                return False
            seen.add(n)
        else:
            return True
```

#### Math

```Python
class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while n != 1:
            if n in seen:
                return False
            seen.add(n)

            happy_number = 0
            while n > 0:
                n, digit = divmod(n, 10)
                happy_number += digit ** 2
            
            n = happy_number

        return True
```

```Python
class Solution:
    def isHappy(self, n: int) -> bool:
        if n == 1:
            return True

        seen = set()

        while n != 1 and not n in seen:
            seen.add(n)

            happy_number = 0
            while n > 0:
                digit = n % 10
                n //= 10
                happy_number += digit ** 2

            if happy_number == 1:
                return True

            n = happy_number

        return False
```

### Turtle and Hare

![image](https://user-images.githubusercontent.com/35042430/222345801-80f9bbd5-8fbc-421d-8d4b-4fc720c3eec2.png)

```Python
class Solution:
    def isHappy(self, n: int) -> bool:
        def get_next(num):
            happy_number = 0
            while num > 0:
                happy_number += (num % 10)**2
                num //= 10
            return happy_number

        turtle = n
        hare = get_next(n)

        while turtle != hare and hare != 1:
            turtle = get_next(turtle)
            hare = get_next(get_next(hare))
        
        return hare == 1
```
