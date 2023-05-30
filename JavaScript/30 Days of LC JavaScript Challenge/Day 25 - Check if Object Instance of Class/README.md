## [2618. Check if Object Instance of Class](https://leetcode.com/problems/check-if-object-instance-of-class)

```Tag```: ```This```

#### Difficulty: Medium

Write a function that checks if a given value is an instance of a given class or superclass. For this problem, an object is considered an instance of a given class if that object has access to that class's methods.

There are no constraints on the data types that can be passed to the function. For example, the value or the class could be ```undefined```.

---

__Example 1:__
```
Input: func = () => checkIfInstanceOf(new Date(), Date)
Output: true
Explanation: The object returned by the Date constructor is, by definition, an instance of Date.
```

__Example 2:__
```
Input: func = () => { class Animal {}; class Dog extends Animal {}; return checkIfInstanceOf(new Dog(), Animal); }
Output: true
Explanation:
class Animal {};
class Dog extends Animal {};
checkIfInstance(new Dog(), Animal); // true

Dog is a subclass of Animal. Therefore, a Dog object is an instance of both Dog and Animal.
```

__Example 3:__
```
Input: func = () => checkIfInstanceOf(Date, Date)
Output: false
Explanation: A date constructor cannot logically be an instance of itself.
```

__Example 4:__
```
Input: func = () => checkIfInstanceOf(5, Number)
Output: true
Explanation: 5 is a Number. Note that the "instanceof" keyword would return false. However, it is still considered an instance of Number because it accesses the Number methods. For example "toFixed()".
```

---

### Approach 1: Iterating Through Prototype Chain

```JavaScript
/**
 * @param {any} obj
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || obj === undefined || typeof classFunction !== 'function') {
        return false;
    }

    let curr = Object.getPrototypeOf(obj);

    while (curr !== null) {
        if (curr === classFunction.prototype) {
            return true;
        }
        curr = Object.getPrototypeOf(curr);
    }

    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */
 ```

### Approach 2: Built-in instanceof method

```JavaScript
/**
 * @param {any} obj
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || obj === undefined || typeof classFunction !== 'function') {
        return false;
    }

    let inputObj = obj;

    if (typeof obj !== "object") {
        inputObj = Object(obj);
    }

    return inputObj instanceof classFunction;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */
```

### Approach 3: Iterating Through Prototype Chain With Generator Function

```JavaScript
/**
 * @param {any} obj
 * @param {any} classFunction
 * @return {boolean}
 */

function* prototypeGenerator(obj) {
    let curr = Object.getPrototypeOf(obj);
    while (curr !== null) {
        yield curr;
        curr = Object.getPrototypeOf(curr);
    }
}

var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || obj === undefined || typeof classFunction !== 'function') {
        return false;
    }

    for (const prototype of prototypeGenerator(obj)) {
        if (prototype === classFunction.prototype) {
            return true;
        }
    }

    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */
 ```
