## [2619. Array Prototype Last](https://leetcode.com/problems/array-prototype-last)

```Tag```: ```This```

#### Difficulty: Easy

Write code that enhances all arrays such that you can call the ```array.last()``` method on any array and it will return the last element. If there are no elements in the array, it should return ```-1```.

![image](https://github.com/quananhle/Data-Structure-and-Algorithms/assets/35042430/6a97a2e0-7234-49f7-a722-eaeba08f6265)

---

__Example 1:__
```
Input: nums = [1,2,3]
Output: 3
Explanation: Calling nums.last() should return the last element: 3.
```

__Example 2:__
```
Input: nums = []
Output: -1
Explanation: Because there are no elements, return -1.
```

__Constraints:__

- ```0 <= arr.length <= 1000```
- ```0 <= arr[i] <= 1000```

---

### Approach 1: Extending Array Prototype to Include a .last() Method

#### ```if```

```JavaScript
Array.prototype.last = function() {
    if (this.length === 0) {
        return -1;
    }
    return this[this.length - 1];
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
```

#### Ternary Operator

```JavaScript
Array.prototype.last = function() {
    return this.length === 0 ? -1 : this[this.length - 1];
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
```

### Nullish Coalescing Operator

```JavaScript
Array.prototype.last = function() {
    return this[this.length - 1] ?? -1;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
```

### ```pop()```

```JavaScript
Array.prototype.last = function() {
    let val = this.pop()
    return val !== undefined ? val : -1;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
```

### Array.prototype.slice()


```JavaScript
Array.prototype.last = function() {
    return this.length ? this.slice(-1)[0] : -1;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
```

### Default Parameters

```JavaScript
Array.prototype.last = function() {
    const [lastElement = -1] = this.slice(-1);
    return lastElement;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
```

### Nullish Coalescing Operator With Array.prototype.at()


```JavaScript
Array.prototype.last = function() {
    return this.at(-1) ?? -1;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
```
