## [2625. Flatten Deeply Nested Array](https://leetcode.com/problems/flatten-deeply-nested-array)

```Tag```: ```JSON / Recursion / Important Utilities```

#### Difficulty: Medium

Given a multi-dimensional array ```arr``` and a depth ```n```, return _a flattened version of that array_.

A multi-dimensional array is a recursive data structure that contains integers or other multi-dimensional arrays.

A flattened array is a version of that array with some or all of the sub-arrays removed and replaced with the actual elements in that sub-array. This flattening operation should only be done if the current depth of nesting is less than ```n```. The depth of the elements in the first array are considered to be ```0```.

Please solve it without the built-in ```Array.flat``` method.

---

__Example 1:__
```
Input
arr = [1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]]
n = 0
Output
[1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]]

Explanation
Passing a depth of n=0 will always result in the original array. This is because the smallest possible depth of a subarray (0) is not less than n=0. Thus, no subarray should be flattened. 
```

__Example 2:__
```
Input
arr = [1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]]
n = 1
Output
[1, 2, 3, 4, 5, 6, 7, 8, [9, 10, 11], 12, 13, 14, 15]

Explanation
The subarrays starting with 4, 7, and 13 are all flattened. This is because their depth of 0 is less than 1. However [9, 10, 11] remains unflattened because its depth is 1.
```

__Example 3:__
```
Input
arr = [[1, 2, 3], [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]]
n = 2
Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]

Explanation
The maximum depth of any subarray is 1. Thus, all of them are flattened.
```

__Constraints:__

- ```0 <= count of numbers in arr <= 10^5```
- ```0 <= count of subarrays in arr <= 10^5```
- ```maxDepth <= 1000```
- ```-1000 <= each number <= 1000```
- ```0 <= n <= 1000```

---

![image](https://github.com/quananhle/Data-Structure-and-Algorithms/assets/35042430/ffd1f405-2c7e-41cf-a000-820cd42989f2)

### Approach 1: Recursive approach

```JavaScript
/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
var flat = function (arr, n) {
    let res = [];
    const flattening = (nums, length) => {
        for (const num of nums) {
            if (Array.isArray(num) && length > 0) {
                flattening(num, length - 1);
            }
            else {
                res.push(num);
            }
        }
    }
    flattening(arr, n);
    return res;
};
```

### Approach 2: Using Iterative Queue

```JavaScript
/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
var flat = function (arr, n) {
    let nested = true;
    let queue;
    let depth = 0;

    while (nested && depth < n) {
        nested = false;
        queue = [];

        for (let i = 0; i < arr.length; ++i) {
            if (Array.isArray(arr[i])) {
                queue.push(...arr[i]);
                nested = true;
            }
            else {
                queue.push(arr[i])
            }
        }

        arr = [...queue];
        depth++;
    }

    return arr
};
```

### Approach 3: Using Iterative Stack


```JavaScript
/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
var flat = function (arr, n) {
	const stack = [...arr.map((item) => [item, n])];
	const res = [];
	
	while (stack.length > 0) {
		const [item, depth] = stack.pop();
		if (Array.isArray(item) && depth > 0) {
			// push back with depth - 1
			stack.push(...item.map((el) => [el, depth - 1]));
		} else {
			res.push(item);
		}
	}

	return res.reverse();
};
```
