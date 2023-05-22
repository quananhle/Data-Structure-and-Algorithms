## [JSON Deep Equal](https://leetcode.com/problems/json-deep-equal)

```Tag```: ```JSON / Recursion / Important Utilities```

#### Difficulty: Medium

Given two objects ```o1``` and ```o2```, check if they are __deeply equal__.

For two objects to be deeply equal, they must contain the same keys, and the associated values must also be deeply equal. Two objects are also considered deeply equal if they pass the ```===``` equality check.

You may assume both objects are the output of ```JSON.parse```. In other words, they are valid JSON.

Please solve it without using lodash's ```_.isEqual()``` function.

---

__Example 1:__
```
Input: o1 = {"x":1,"y":2}, o2 = {"x":1,"y":2}
Output: true
Explanation: The keys and values match exactly.
```

__Example 2:__
```
Input: o1 = {"y":2,"x":1}, o2 = {"x":1,"y":2}
Output: true
Explanation: Although the keys are in a different order, they still match exactly.
```

__Example 3:__
```
Input: o1 = {"x":null,"L":[1,2,3]}, o2 = {"x":null,"L":["1","2","3"]}
Output: false
Explanation: The array of numbers is different from the array of strings.
```

__Example 4:__
```
Input: o1 = true, o2 = false
Output: false
Explanation: true !== false
```

__Constraints:__

- ```1 <= JSON.stringify(o1).length <= 10^5```
- ```1 <= JSON.stringify(o2).length <= 10^5```
- ```maxNestingDepth <= 1000```

---
