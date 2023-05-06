## [2620. Counter](https://leetcode.com/problems/counter/?utm_campaign=PostD2&utm_medium=Post&utm_source=Post&gio_link_id=xogkVqBo)

#### Difficulty: Easy

Given an integer ```n```, return a ```counter``` function. This counter function initially returns ```n``` and then returns ```1``` more than the previous value every subsequent time it is called (```n```, ```n + 1```, ```n + 2```, etc).

---

__Example 1:__
```
Input: 
n = 10 
["call","call","call"]
Output: [10,11,12]
Explanation: 
counter() = 10 // The first time counter() is called, it returns n.
counter() = 11 // Returns 1 more than the previous time.
counter() = 12 // Returns 1 more than the previous time.
```

__Example 2:__
```
Input: 
n = -2
["call","call","call","call","call"]
Output: [-2,-1,0,1,2]
Explanation: counter() initially returns -2. Then increases after each sebsequent call.
```

__Constraints:__

- ```-1000 <= n <= 1000```
- At most ```1000``` calls to ```counter()``` will be made

---

```JavaScript
/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    n = n - 1;
    return function() {
        n++;
        return n;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */
 ```
 
 ```JavaScript
 /**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    return function() {
        return n++;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */
 ```
