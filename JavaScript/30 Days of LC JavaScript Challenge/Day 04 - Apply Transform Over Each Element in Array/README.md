## [2635. Apply Transform Over Each Element in Array](https://leetcode.com/problems/apply-transform-over-each-element-in-array)

#### Difficulty: Easy

Given an integer array ```arr``` and a mapping function ```fn```, return _a new array with a transformation applied to each element_.

The returned array should be created such that ```returnedArray[i] = fn(arr[i], i)```.

Please solve it without the built-in ```Array.map``` method.

---

__Example 1:__
```
Input: arr = [1,2,3], fn = function plusone(n) { return n + 1; }
Output: [2,3,4]
Explanation:
const newArray = map(arr, plusone); // [2,3,4]
The function increases each value in the array by one.
```

__Example 2:__
```
Input: arr = [1,2,3], fn = function plusI(n, i) { return n + i; }
Output: [1,3,5]
Explanation: The function increases each value by the index it resides in.
```

__Example 3:__
```
Input: arr = [10,20,30], fn = function constant() { return 42; }
Output: [42,42,42]
Explanation: The function always returns 42.
```

__Constraints:__

- ```0 <= arr.length <= 1000```
- ```-10^9 <= arr[i] <= 10^9```
- ```fn``` returns a number

---

### Approach 1: Write Values onto Initially Empty Array

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    let newArr = [];
    for (let i = 0; i < arr.length; i++) {
        newArr[i] = fn(arr[i], i);
    }
    return newArr;
};
```

### Approach 2: For...in Loop

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const newArr = new Array(arr.length);
    for (const i in arr) {
        newArr[i] = fn(arr[i], Number(i));
    }
    return newArr;
};
```

### Approach 3: Push Values onto Array

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const newArr = [];
    for (let i = 0; i < arr.length; i++) {
        newArr.push(fn(arr[i], i));
    }
    return newArr;
};
```

### Approach 4: Preallocate Memory

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const newArr = new Array(arr.length);
    for (let i = 0; i < arr.length; i++) {
        newArr[i] = fn(arr[i], i);
    }
    return newArr;
};
```

### Approach 5: 32 Bit Integer Array

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const newArr = new Int32Array(arr.length);
    for (let i = 0; i < arr.length; ++i) {
        newArr[i] = fn(arr[i], i);
    }
    return newArr;
};
```

### Approach 6: In-Memory Transformation

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    for (let i = 0; i < arr.length; ++i) {
        arr[i] = fn(arr[i], i);
    }
    return arr
};
```
