## [2634. Filter Elements from Array](https://leetcode.com/problems/filter-elements-from-array)

#### Difficulty: Easy

Given an integer array ```arr``` and a filtering function ```fn```, return _a new array with a fewer or equal number of elements_.

The returned array should only contain elements where ```fn(arr[i], i)``` evaluated to a truthy value.

Please solve it without the built-in ```Array.filter``` method.

---

__Example 1:__
```
Input: arr = [0,10,20,30], fn = function greaterThan10(n) { return n > 10; }
Output: [20,30]
Explanation:
const newArray = filter(arr, fn); // [20, 30]
The function filters out values that are not greater than 10
```

__Example 2:__
```
Input: arr = [1,2,3], fn = function firstIndex(n, i) { return i === 0; }
Output: [1]
Explanation:
fn can also accept the index of each element
In this case, the function removes elements not at index 0
```

__Example 3:__
```
Input: arr = [-2,-1,0,1,2], fn = function plusOne(n) { return n + 1 }
Output: [-2,0,1,2]
Explanation:
Falsey values such as 0 should be filtered out
```

__Constraints:__

- ```0 <= arr.length <= 1000```
- ```-10^9 <= arr[i] <= 10^9```

---

### Approach 1: Push Values onto New Array

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const newArray = [];
    for (let i = 0; i < arr.length; ++i) {
        if (fn(arr[i], i)) {
            newArray.push(arr[i]);
        }
    }
    return newArray;
};
```

### Approach 2: For...in Loop

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const newArray = [];
    for (const num in arr) {
        const i = Number(num);
        if (fn(arr[i], i)) {
            newArray.push(arr[i]);
        }
    }
    return newArray;
};
```

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const newArray = [];
    for (let i = 0; i < arr.length; ++i) {
        if (fn(arr[i], i)) {
            newArray.push(arr[i]);
        }
    }
    return newArray;
};
```

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const newArray = [];
    for (let i = 0; i < arr.length; ++i) {
        if (fn(arr[i], i)) {
            newArray.push(arr[i]);
        }
    }
    return newArray;
};
```

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const newArray = [];
    for (let i = 0; i < arr.length; ++i) {
        if (fn(arr[i], i)) {
            newArray.push(arr[i]);
        }
    }
    return newArray;
};
```

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const newArray = [];
    for (let i = 0; i < arr.length; ++i) {
        if (fn(arr[i], i)) {
            newArray.push(arr[i]);
        }
    }
    return newArray;
};
```
