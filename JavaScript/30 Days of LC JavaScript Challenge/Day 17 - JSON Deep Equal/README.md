## [2628. JSON Deep Equal](https://leetcode.com/problems/json-deep-equal)

```Tag```: ```JSON / Recursion / Important Utilities```

#### Difficulty: Medium

Given two objects ```o1``` and ```o2```, check if they are __deeply equal__.

For two objects to be deeply equal, they must contain the same keys, and the associated values must also be deeply equal. Two objects are also considered deeply equal if they pass the ```===``` equality check.

You may assume both objects are the output of ```JSON.parse```. In other words, they are valid JSON.

Please solve it without using lodash's ```_.isEqual()``` function.

---

__Example 1:__
```
Input: o1 = {"x":1,"y":2}, o2 = {"x":1,"y":2}
Output: true
Explanation: The keys and values match exactly.
```

__Example 2:__
```
Input: o1 = {"y":2,"x":1}, o2 = {"x":1,"y":2}
Output: true
Explanation: Although the keys are in a different order, they still match exactly.
```

__Example 3:__
```
Input: o1 = {"x":null,"L":[1,2,3]}, o2 = {"x":null,"L":["1","2","3"]}
Output: false
Explanation: The array of numbers is different from the array of strings.
```

__Example 4:__
```
Input: o1 = true, o2 = false
Output: false
Explanation: true !== false
```

__Constraints:__

- ```1 <= JSON.stringify(o1).length <= 10^5```
- ```1 <= JSON.stringify(o2).length <= 10^5```
- ```maxNestingDepth <= 1000```

---

Let us see when to use __Strict Equality__```(===)```, __Loose Equality__```(==)``` and ```Object.is``` :

1. Behavior of __Strict Equality__```(===)```, __Loose Equality__```(==)``` and ```Object.is```  when the operands are of different types:
- __Strict Equality__```(===)```: If the operands are of different types, they are considered not equal.
- __Loose Equality__```(==)```: The loose equality operator performs type coercion before comparison. If the operands are of different types, it attempts to convert them to a common type.
- ```Object.is``` Method: Similar to strict equality ```('===')```, if the operands are of different types, they are considered not equal.
2. Behavior of __Strict Equality__```(===)```, __Loose Equality__```(==)``` and __Object.is__  for primitive types:
- __Strict Equality__```(===)```: For primitive types (numbers, strings, booleans), strict equality compares their values. If the values are the same, they are considered equal; otherwise, they are considered not equal.
- __Loose Equality__```(==)```: The loose equality operator performs type coercion before comparison. For primitive types, it behaves similarly to strict equality.
- ```Object.is``` Method: ```Object.is``` compares values using the SameValueZero algorithm. It treats positive and negative zeros as not equal and treats NaN as equal to NaN. For primitive types, it compares their values.
3. Behavior of __Strict Equality__```(===)```, __Loose Equality__```(==)``` and __Object.is__  for objects and arrays:
- __Strict Equality__```(===)```: For objects and arrays, strict equality compares their references. They are considered equal only if they refer to the same object/array in memory.
- __Loose Equality__```(==)```: For objects and arrays, it also performs reference comparison and checks if they refer to the same object/array in memory.
- ```Object.is``` Method: For objects and arrays, it compares their references.

In summary, 
> __Strict Equality__```(===)``` compares values for primitive types and references for objects and arrays. 
> __Loose Equality__```(==)``` performs type coercion and compares values for primitive types and references for objects and arrays. 
> ```Object.is``` compares values using the SameValueZero algorithm and treats certain cases differently, such as positive and negative zeros and NaN.

Some examples to understand __Strict Equality__```(===)```, __Loose Equality__```(==)``` and ```Object.is```:

```JavaScript
console.log(5 === 5);                     // true (both operands are numbers with the same value)
console.log(5 === '5');                   // false (operands are of different types: number vs string)
console.log(true === true);               // true (both operands are booleans with the same value)
console.log(null === null);               // true (both operands are null)
console.log(undefined === undefined);     // true (both operands are undefined)

console.log(5 == 5);                      // true (both operands are numbers with the same value)
console.log(5 == '5');                    // true (loose equality performs type coercion, '5' is coerced to a number 5)
console.log(true == true);                // true (both operands are booleans with the same value)
console.log(null == null);                // true (both operands are null)
console.log(undefined == undefined);      // true (both operands are undefined)

const obj1 = { name: 'I_Am_Batman' };
const obj2 = { name: 'I_Am_Batman' };
const obj3 = obj1;

console.log(obj1 === obj2);               // false (objects have different references in memory)
console.log(obj1 === obj3);               // true (both variables reference the same object)

console.log(Object.is(5, 5));             // true (both operands are numbers with the same value)
console.log(Object.is(5, '5'));           // false (operands are of different types: number vs string)
console.log(Object.is(true, true));       // true (both operands are booleans with the same value)
console.log(Object.is(null, null));       // true (both operands are null)
console.log(Object.is(undefined, undefined)); // true (both operands are undefined)
console.log(Object.is(obj1, obj2));       // false (objects have different references in memory)
console.log(Object.is(obj1, obj3));       // true (both variables reference the same object)
```

### Approach 1: Comparative Recursion

```JavaScript
/**
 * @param {any} o1
 * @param {any} o2
 * @return {boolean}
 */
var areDeeplyEqual = function(o1, o2) {
    if (o1 === o2) {
        return true;
    }
    if (o1 === null || o2 === null) {
        return false;
    }
    if (String(o1) !== String(o2)) {
        return false;
    }
    if (typeof o1 !== 'object') {
        return o1 === o2;
    }
    if (Array.isArray(o1)) {
        if (o1.length !== o2.length) {
            return false;
        }
        for (let i = 0; i < o1.length; ++i) {
            if (!areDeeplyEqual(o1[i], o2[i])) {
                return false;
            }
        }
        return true;
    }
    if (Object.keys(o1).length !== Object.keys(o2).length) {
        return false;
    }
    for (const key in o1) {
        if (!areDeeplyEqual(o1[key], o2[key])) {
            return false;
        }
    }
    return true;
};
```

### Approach 2: Iterative Solution

```JavaScript
/**
 * @param {any} o1
 * @param {any} o2
 * @return {boolean}
 */
function helper(key, val) {
    if (val && typeof val === "object" && !Array.isArray(val)) {
        return Object.fromEntries(Object.entries(val).sort());
    }
    else {
        return val;
    }
}
var areDeeplyEqual = function(o1, o2) {
    const stringifieldO1 = JSON.stringify(o1, helper);
    const stringifieldO2 = JSON.stringify(o2, helper);
    return stringifieldO1 === stringifieldO2;
};
```
