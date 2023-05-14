## [2623. Memoize](https://leetcode.com/problems/memoize)

#### Difficulty: Medium

Given a function ```fn```, return _a memoized version of that function_.

A memoized function is a function that will never be called twice with the same inputs. Instead it will return a cached value.

You can assume there are 3 possible input functions: ```sum```, ```fib```, and ```factorial```.

- ```sum``` accepts two integers ```a``` and ```b``` and returns ```a + b```.
- ```fib``` accepts a single integer ```n``` and returns ```1``` if ```n <= 1``` or ```fib(n - 1) + fib(n - 2)``` otherwise.
- ```factorial``` accepts a single integer ```n``` and returns ```1``` if ```n <= 1``` or ```factorial(n - 1) * n``` otherwise.

---

__Example 1:__
```
Input
"sum"
["call","call","getCallCount","call","getCallCount"]
[[2,2],[2,2],[],[1,2],[]]
Output
[4,4,1,3,2]

Explanation
const sum = (a, b) => a + b;
const memoizedSum = memoize(sum);
memoizedSum(2, 2); // Returns 4. sum() was called as (2, 2) was not seen before.
memoizedSum(2, 2); // Returns 4. However sum() was not called because the same inputs were seen before.
// Total call count: 1
memoizedSum(1, 2); // Returns 3. sum() was called as (1, 2) was not seen before.
// Total call count: 2
```

__Example 2:__
```
Input
"factorial"
["call","call","call","getCallCount","call","getCallCount"]
[[2],[3],[2],[],[3],[]]
Output
[2,6,2,2,6,2]

Explanation
const factorial = (n) => (n <= 1) ? 1 : (n * factorial(n - 1));
const memoFactorial = memoize(factorial);
memoFactorial(2); // Returns 2.
memoFactorial(3); // Returns 6.
memoFactorial(2); // Returns 2. However factorial was not called because 2 was seen before.
// Total call count: 2
memoFactorial(3); // Returns 6. However factorial was not called because 3 was seen before.
// Total call count: 2
```

__Example 3:__
```
Input
"fib"
["call","getCallCount"]
[[5],[]]
Output
[8,1]

Explanation
fib(5) = 8
// Total call count: 1
```
 

__Constraints:__

- ```0 <= a, b <= 10^5```
- ```1 <= n <= 10```
- at most ```10^5``` function calls
- at most ```10^5``` attempts to access callCount
- input function is ```sum```, ```fib```, or ```factorial```

---

This type of optimization is called __memoization__ and is an extremely important example of a __higher-order function__.

To give a concrete example of memoization, here is some code without memoization.

```JavaScript
let callCount = 0;
const add = (a, b) => {
  callCount += 1;
  return a + b;
}

add(2, 2); // 4
console.log(callCount); // 1
add(2, 2); // 4
console.log(callCount); // 2
add(2, 2); // 4
console.log(callCount); // 3
```

As expected, ```callCount``` is incremented every time ```add``` is called.

However if we apply __memoization__:

```JavaScript
let callCount = 0;
const add = (a, b) => {
  callCount += 1;
  return a + b;
};
const memoizedAdd = memoize(add);

memoizedAdd(2, 2); // 4
console.log(callCount); // 1
memoizedAdd(2, 2); // 4
console.log(callCount); // 1
memoizedAdd(2, 2); // 4
console.log(callCount); // 1
```

### Approach 1: Rest/Spread Syntax + JSON.stringify()

```JavaScript
/**
 * @param {Function} fn
 */
function memoize(fn) {
    const cache = {};
    return function(...args) {
        const key = JSON.stringify(args);
        if (key in cache) {
            return cache[key];
        }
        const output = fn(...args);
        cache[key] = output
        return output;
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */
```

### Approach 2: Argument Syntax

```JavaScript
/**
 * @param {Function} fn
 */
function memoize(fn) {
    const cache = {};
    return function(...args) {
        let key = '';
        for (const arg of arguments) {
            key += ',' + arg;
        }
        if (key in cache) {
            return cache[key];
        }
        const output = fn(...args);
        cache[key] = output
        return cache[key]
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */
```

### Approach 3: Optimize Based on Numeric Constraints + Function.apply

```JavaScript
/**
 * @param {Function} fn
 */
function memoize(fn) {
    const cache = new Map();
    return function(...args) {
        let key = arguments[0];
        if (arguments[1]) {
            key += arguments[1] * 100001;
        }
        const result = cache.get(key);
        if (result != undefined) {
            return result;
        }
        const output = fn(...args);
        cache.set(key, output);
        return output;
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */
```
