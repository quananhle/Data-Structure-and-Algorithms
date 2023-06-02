## [2695. Array Wrapper](https://leetcode.com/problems/array-wrapper)

```Tag```: ```Classes```

#### Difficulty: Easy

Create a class ```ArrayWrapper``` that accepts an array of integers in it's constructor. This class should have two features:

- When two instances of this class are added together with the ```+``` operator, the resulting value is the sum of all the elements in both arrays.
- When the ```String()``` function is called on the instance, it will return a comma separated string surrounded by brackets. For example, ```[1,2,3]```.

---

__Example 1:__
```
Input: nums = [[1,2],[3,4]], operation = "Add"
Output: 10
Explanation:
const obj1 = new ArrayWrapper([1,2]);
const obj2 = new ArrayWrapper([3,4]);
obj1 + obj2; // 10
```

__Example 2:__
```
Input: nums = [[23,98,42,70]], operation = "String"
Output: "[23,98,42,70]"
Explanation:
const obj = new ArrayWrapper([23,98,42,70]);
String(obj); // "[23,98,42,70]"
```

__Example 3:__
```
Input: nums = [[],[]], operation = "Add"
Output: 0
Explanation:
const obj1 = new ArrayWrapper([]);
const obj2 = new ArrayWrapper([]);
obj1 + obj2; // 0
```

__Constraints:__

- ```0 <= nums.length <= 1000```
- ```0 <= nums[i] <= 1000```
- Note: ```nums``` is the array passed to the constructor

---

### Approach 1: Implementing ```valueOf``` and ```toString``` methods in ```ArrayWrapper``` class

```JavaScript
/**
 * @param {number[]} nums
 */
var ArrayWrapper = function(nums) {
    this.nums = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    return this.nums.reduce((a, b) => a + b, 0);
}

ArrayWrapper.prototype.toString = function() {
    return "[" + this.nums.join(',') + "]"
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */
 ```
 
 ### Apprach 2: Using ```for``` loop in ```valueOf()``` method
 
 ```JavaScript
/**
 * @param {number[]} nums
 */
var ArrayWrapper = function(nums) {
    this.nums = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    let sum = 0;
    for (let i = 0; i < this.nums.length; ++i) {
        sum += this.nums[i];
    }
    return sum;
}

ArrayWrapper.prototype.toString = function() {
    return "[" + this.nums.join(',') + "]"
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */
```

### Apprach 3: Using ```toString()``` method in Array

```JavaScript
/**
 * @param {number[]} nums
 */
var ArrayWrapper = function(nums) {
    this.nums = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    return this.nums.reduce((a, b) => a + b, 0);
};

ArrayWrapper.prototype.toString = function() {
    return '[' + this.nums.toString() + ']';
};

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */
 ```
 
 ### Approach 4: Using Template Literals in ```toString()``` Method
 
 ```JavaScript
 /**
 * @param {number[]} nums
 */
var ArrayWrapper = function(nums) {
    this.nums = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    return this.nums.reduce((a, b) => a + b, 0);
}

ArrayWrapper.prototype.toString = function() {
    return `[${this.nums}]`;
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */
 ```

### Approach 5: Using ```JSON.stringify``` in ```toString()``` Method

```JavaScript
/**
 * @param {number[]} nums
 */
var ArrayWrapper = function(nums) {
    this.nums = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    return this.nums.reduce((a, b) => a + b, 0);
}

ArrayWrapper.prototype.toString = function() {
    return JSON.stringify(this.nums);
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */
```
