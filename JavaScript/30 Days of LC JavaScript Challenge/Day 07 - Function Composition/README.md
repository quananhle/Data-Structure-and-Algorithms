## [2629. Function Composition](https://leetcode.com/problems/function-composition)

#### Difficulty: Easy

Given an array of functions ```[f1, f2, f3, ..., fn]```, return _a new function ```fn``` that is the function composition of the array of functions_.

The function composition of ```[f(x), g(x), h(x)]``` is ```fn(x) = f(g(h(x)))```.

The function composition of an empty list of functions is the __identity function__ ```f(x) = x```.

You may assume each function in the array accepts one integer as input and returns one integer as output.

---

__Example 1:__
```
Input: functions = [x => x + 1, x => x * x, x => 2 * x], x = 4
Output: 65
Explanation:
Evaluating from right to left ...
Starting with x = 4.
2 * (4) = 8
(8) * (8) = 64
(64) + 1 = 65
```

__Example 2:__
```
Input: functions = [x => 10 * x, x => 10 * x, x => 10 * x], x = 1
Output: 1000
Explanation:
Evaluating from right to left ...
10 * (1) = 10
10 * (10) = 100
10 * (100) = 1000
```

__Example 3:__
```
Input: functions = [], x = 42
Output: 42
Explanation:
The composition of zero functions is the identity function
```

__Constraints:__

- ```-1000 <= x <= 1000```
- ```0 <= functions.length <= 1000```
- all functions accept and return a single integer

---

![image](https://github.com/quananhle/Data-Structure-and-Algorithms/assets/35042430/262222c8-be16-429a-8cd1-ce0a257f8ae8)

### Approach 1: Function Composition using Iteration

```JavaScript
/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
	return function(x) {
        if (functions.lengthh === 0) {
            return x;
        }

        let output = x;
        for (let i = functions.length - 1; i >= 0; i--) {
            const currFunc = functions[i];
            output = currFunc(output);
        }

        return output;
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
 ```

### Approach 2: Function Composition using Iteration using ```for ... of``` loop

```JavaScript
/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
	return function(x) {
        if (functions.lengthh === 0) {
            return x;
        }

        let output = x;
        for (const currFunc of functions.reverse()) {
            output = currFunc(output);
        }

        return output;
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
```

---

### Additional Considerations

A professional implementation would need to consider several more things when dealing with function composition.

#### Handling ```this``` context

In JavaScript, the value of ```this``` within a function depends on how the function is called. When using function composition, it's important to consider how the ```this``` context of the original functions is preserved. Although the provided test cases may not explicitly test for this, handling the ```this``` context correctly can be crucial in real-world scenarios.

One approach to handle the ```this``` context is to use the ```call``` or ```apply``` methods when invoking the composed functions. This allows you to explicitly set the value of this when calling the function. For example:

```JavaScript
const composedFn = function(x) {
  let result = x;
  for (let i = functions.length - 1; i >= 0; i--) {
    result = functions[i].call(this, result);
  }
  return result;
};
```

This ensures that the ```this``` context of the original functions is preserved when they are called as part of the composed function. For more clarity, consider a scenario where the functions you're composing are methods on an object, and they rely on this to access other properties or methods on that object. If you don't correctly preserve the ```this``` context when composing these methods, they may not work as expected.

```JavaScript
const obj = {
  value: 1,
  increment: function() { this.value++; return this.value; },
  double: function() { this.value *= 2; return this.value; },
};

// Composing the methods without preserving `this`
const badCompose = function(functions) {
  return function(x) {
    let result = x;
    for (let i = functions.length - 1; i >= 0; i--) {
      result = functions[i](result);
    }
    return result;
  };
};

const badComposedFn = badCompose([obj.increment, obj.double]);
console.log(badComposedFn(1));  // This will return NaN, because `this` is not `obj` inside `increment` and `double`
```

To handle this situation, you can use the ```call``` or ```apply``` methods when invoking the composed functions. This allows you to explicitly set the value of ```this``` when calling the function:

```JavaScript
const obj = {
  value: 1,
  increment: function() { this.value++; return this.value; },
  double: function() { this.value *= 2; return this.value; },
};

// Composing the methods while preserving `this`
const goodCompose = function(functions, context) {
  return function(x) {
    let result = x;
    for (let i = functions.length - 1; i >= 0; i--) {
      result = functions[i].call(context, result);
    }
    return result;
  };
};

const goodComposedFn = goodCompose([obj.increment, obj.double], obj);
console.log(goodComposedFn(1));  // This works as expected, because `this` is `obj` inside `increment` and `double`
```
