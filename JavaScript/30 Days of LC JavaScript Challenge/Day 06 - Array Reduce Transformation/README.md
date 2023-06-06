## [2626. Array Reduce Transformation](https://leetcode.com/problems/array-reduce-transformation)

```Tag```: ```Basic Array Transforms```

#### Difficulty: Easy

Given an integer array ```nums```, a reducer function ```fn```, and an initial value ```init```, return _a reduced array_.

A reduced array is created by applying the following operation: ```val = fn(init, nums[0])```, ```val = fn(val, nums[1])```, ```val = fn(val, nums[2])```, ... until every element in the array has been processed. The final value of ```val``` is returned.

If the length of the array is ```0```, it should return ```init```.

Please solve it without using the built-in ```Array.reduce``` method.

---

__Example 1:__
```
Input: 
nums = [1,2,3,4]
fn = function sum(accum, curr) { return accum + curr; }
init = 0
Output: 10
Explanation:
initially, the value is init=0.
(0) + nums[0] = 1
(1) + nums[1] = 3
(3) + nums[2] = 6
(6) + nums[3] = 10
The final answer is 10.
```

__Example 2:__
```
Input: 
nums = [1,2,3,4]
fn = function sum(accum, curr) { return accum + curr * curr; }
init = 100
Output: 130
Explanation:
initially, the value is init=100.
(100) + nums[0]^2 = 101
(101) + nums[1]^2 = 105
(105) + nums[2]^2 = 114
(114) + nums[3]^2 = 130
The final answer is 130.
```

__Example 3:__
```
Input: 
nums = []
fn = function sum(accum, curr) { return 0; }
init = 25
Output: 25
Explanation: For empty arrays, the answer is always init.
```

__Constraints:__

- ```0 <= nums.length <= 1000```
- ```0 <= nums[i] <= 1000```
- ```0 <= init <= 1000```

---

### Use-cases of Reduce

#### Sum Values in Array

The classic use-case of reduce is summing up all the values in an array.

```JavaScript
const nums = [1, 2, 3];
const sum = nums.reduce((accumulator, val) => accumulator + val, 0);
console.log(sum); // 6
```

And you can sum values based on some property with a minor modification.

```JavaScript
const nums = [{x: 1}, {x: 2}, {x: 3}];
const sum = nums.reduce((accumulator, val) => accumulator + val.x, 0);
console.log(sum); // 6
```

#### Index Array by Key

An extremely common task in programming is taking a list of data and indexing each piece of data by some key. That way, the data is accessible by it's key in ```O(1)``` time.

```JavaScript
const groceries = [
  { id: 173, name: "Soup" }, 
  { id: 964, name: "Apple" },
  { id: 535, name: "Cheese" }
];

const indexedGroceries = groceries.reduce((accumulator, val) => {
  accumulator[val.id] = val;
  return accumulator;
}, {});

console.log(indexedGroceries);
/**
 * {
 *   "173": { id: 173, name: "Soup" },
 *   "964": { id: 964, name: "Apple" },
 *   "535": { id: 535, name: "Cheese" },
 * }
 */
 ```
 
Note that a common performance mistake that developers make is to create a clone of the accumulator for each array iteration. i.e. ```return { ...accumulator, [val.id]: val };```. This results in an ```O(n^2)``` algorithm.

#### Combine Filter and Map

It is not uncommon to need to chain ```.filter().map()``` together to both remove elements from an array and transform it. The problem is this approach is less efficient because these array methods create new arrays. Two arrays are created when only one is necessary. You can combine the filter and the map into a single reduce for improved performance.

```JavaScript
const groceries = [
  { id: 173, name: "Soup" }, 
  { id: 964, name: "Apple" },
  { id: 535, name: "Cheese" }
];

/** With filter and map */
var names = groceries
  .filter(item => item.id > 500)
  .map(item => item.name)

/** With reduce */
var names = groceries.reduce((accumulator, val) => {
  if (val.id > 500) {
    accumulator.push(val.name);
  }
  return accumulator;
}, []);

console.log(names); // ["Apple", "Cheese"]
```
---


```JavaScript
/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    var ans = init;
    for (let i = 0; i < nums.length; ++i) {
        ans = fn(ans, nums[i]);
    }
    return ans;
};
```

### Approach 1: For...of Loop

```JavaScript
/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    var ans = init;
    for (const num of nums) {
        ans = fn(ans, num);
    }
    return ans;
};
```
### Approach 2: Array.forEach Loop

```JavaScript
/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    var ans = init;
    nums.forEach((num) => {
        ans = fn(ans, num);
    });
    return ans;
};
```

### Approach 3: For...in Loop

```JavaScript
/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    var ans = init;
    for (const i in nums) {
        ans = fn(ans, nums[i]);
    }
    return ans;
};
```
