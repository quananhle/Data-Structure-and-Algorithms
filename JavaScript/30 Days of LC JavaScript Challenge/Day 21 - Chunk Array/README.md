## [2677. Chunk Array](https://leetcode.com/problems/chunk-array)

#### Difficulty: Easy

Given an array ```arr``` and a chunk size ```size```, return _a chunked array_. A chunked array contains the original elements in ```arr```, but consists of subarrays each of length ```size```. The length of the last subarray may be less than ```size``` if ```arr.length``` is not evenly divisible by ```size```.

You may assume the array is the output of ```JSON.parse```. In other words, it is valid JSON.

Please solve it without using lodash's ```_.chunk``` function.

---

__Example 1:__
```
Input: arr = [1,2,3,4,5], size = 1
Output: [[1],[2],[3],[4],[5]]
Explanation: The arr has been split into subarrays each with 1 element.
```

__Example 2:__
```
Input: arr = [1,9,6,3,2], size = 3
Output: [[1,9,6],[3,2]]
Explanation: The arr has been split into subarrays with 3 elements. However, only two elements are left for the 2nd subarray.
```

__Example 3:__
```
Input: arr = [8,5,3,2,6], size = 6
Output: [[8,5,3,2,6]]
Explanation: Size is greater than arr.length thus all elements are in the first subarray.
```

__Example 4:__
```
Input: arr = [], size = 1
Output: []
Explanation: There are no elements to be chunked so an empty array is returned.
```

__Constraints:__

- ```arr``` is a valid JSON array
- ```2 <= JSON.stringify(arr).length <= 10^5```
- ```1 <= size <= arr.length + 1```

---
