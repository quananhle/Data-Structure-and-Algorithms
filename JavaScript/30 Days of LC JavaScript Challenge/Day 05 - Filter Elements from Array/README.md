## [2634. Filter Elements from Array](https://leetcode.com/problems/filter-elements-from-array)

```Tag```: ```Basic Array Transforms```

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

### Truthy and Falsy

In this question, you are asked to remove all values from an array that aren't truthy (i.e. remove all falsy values). But what does that mean? ```JavaScript``` has true boolean values of ```true``` and ```false```. But you are actually allowed to put any value inside an ```if``` statement. That value will be coerced into a boolean based on it's "truthiness".

All values are considered truthy except the following:

- ```false```
- All forms of zero, meaning ```0```, ```-0``` (output of ```0/-1```), and ```0n``` (output of ```BigInt(0)```)
- ```NaN``` ("Not a Number", one way to get it is with ```0/0```)
- ```""``` (empty string)
- ```null```
- ```undefined```

#### Why does this language feature exist?

The short answer is it can be convenient. Imagine you have a textfield which edits a variable userInput which is initially null.

```JavaScript
if (userInput !== null && userInput !== "") {
  // uploadToDatabase(userInput)
}
```

can be shortened to:

```JavaScript
if (userInput) {
  // uploadToDatabase(userInput)
}
```

#### Truthiness and Logical Operators

- The __OR__ operator ```||``` returns the first value if the first value is __truthy__ (without evaluating the 2nd value). Otherwise it returns the 2<sup>nd</sup> value.
- The __AND__ operator ```&&``` returns the first value if the first value is __falsy__ (without evaluating the 2nd value). Otherwise it returns the 2<sup>nd</sup> value.
- The __Nullish Coalescing__ operator ```??``` is identical to ```||``` except it only treats ```null``` and ```undefined``` as __falsy__.

```JavaScript
let val;
if (a) {
  val = a;
} else if (b) {
  val = b;
} else {
  val = c;
}
```

can be replaced with:

```JavaScript
const val = a || b || c;
```

You could also conditionally execute some code:

```JavaScript
if (a && b) {
  func();
}
```

can be replaced with:

```JavaScript
a && b && func();
```

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

### Approach 3: Preallocate Memory

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let curr = 0;
    const newArray = new Array(arr.length);
    for (let i = 0; i < arr.length; ++i) {
        if (fn(arr[i], i)) {
            newArray[curr] = arr[i];
            ++curr;
        }
    }
    while (newArray.length > curr) {
        newArray.pop();
    }
    return newArray;
};
```

### Approach 4: Perform Operations In-Place

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let curr = 0;
    for (let i = 0; i < arr.length; ++i) {
        if (fn(arr[i], i)) {
            arr[curr] = arr[i];
            ++curr;
        }
    }
    while (arr.length > curr) {
        arr.pop();
    }
    return arr;
};
```

### Approach 5: Built-in Function

```JavaScript
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    return arr.filter(fn);
};
```
