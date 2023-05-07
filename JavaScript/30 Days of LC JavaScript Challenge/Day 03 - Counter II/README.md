## [2665. Counter II](https://leetcode.com/problems/counter-ii/?utm_campaign=PostD3&utm_medium=Post&utm_source=Post&gio_link_id=xRxVYOXo)

#### Difficulty: Easy

Write a function ```createCounter```. It should accept an initial integer ```init```. It should return an object with three functions.

The three functions are:

- ```increment()``` increases the current value by 1 and then returns it.
- ```decrement()``` reduces the current value by 1 and then returns it.
- ```reset()``` sets the current value to init and then returns it.
 
---

__Example 1:__
```
Input: init = 5, calls = ["increment","reset","decrement"]
Output: [6,5,4]
Explanation:
const counter = createCounter(5);
counter.increment(); // 6
counter.reset(); // 5
counter.decrement(); // 4
```

__Example 2:__
```
Input: init = 0, calls = ["increment","increment","decrement","reset","reset"]
Output: [1,2,1,0,0]
Explanation:
const counter = createCounter(0);
counter.increment(); // 1
counter.increment(); // 2
counter.decrement(); // 1
counter.reset(); // 0
counter.reset(); // 0
```

__Constraints:__

- ```-1000 <= init <= 1000```
- total calls not to exceed ```1000```

---

### Approach 1: Closure

```JavaScript
/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let curr = init;
    return {
        increment: function() {
            curr++;
            return curr;
        },
        decrement: function() {
            curr--;
            return curr;
        },
        reset: function() {
            curr = init;
            return curr;
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
 ```
 
### Approach 2: Closure with Shortened Syntax
 
```JavaScript
/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let curr = init;
    return {
        increment: () => ++curr,
        decrement: () => --curr,
        reset: () => (curr = init),
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
```
