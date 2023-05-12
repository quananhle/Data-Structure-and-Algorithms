## [Allow One Function Call](https://leetcode.com/problems/allow-one-function-call)

#### Difficulty: Easy

Given a function ```fn```, return _a new function that is identical to the original function except that it ensures ```fn``` is called at most once_.

The first time the returned function is called, it should return the same result as ```fn```.

Every subsequent time it is called, it should return ```undefined```.

---

__Example 1:__
```
Input: fn = (a,b,c) => (a + b + c), calls = [[1,2,3],[2,3,6]]
Output: [{"calls":1,"value":6}]
Explanation:
const onceFn = once(fn);
onceFn(1, 2, 3); // 6
onceFn(2, 3, 6); // undefined, fn was not called
```

__Example 2:__
```
Input: fn = (a,b,c) => (a * b * c), calls = [[5,7,4],[2,3,6],[4,6,8]]
Output: [{"calls":1,"value":140}]
Explanation:
const onceFn = once(fn);
onceFn(5, 7, 4); // 140
onceFn(2, 3, 6); // undefined, fn was not called
onceFn(4, 6, 8); // undefined, fn was not called
```

__Constraints:__

- ```1 <= calls.length <= 10```
- ```1 <= calls[i].length <= 100```
- ```2 <= JSON.stringify(calls).length <= 1000```

---

### Higher-Order Function

#### Example Use-cases of Functions That Modify Functions

Functions that modify or extends the behavior of functions are extremely common in JavaScript and are a key concept in __functional programming__. It is critical to fully understand them to be an effective developer.

They are very useful for writing elegant, reusable code, and have a variety of use-cases, a few of which will be discussed.

#### Throttle
Imagine you were implementing a search field. Querying the database for results every single time a character is typed could put unnecessary load on the database and the user interface. To prevent this, you could employ a technique known as throttling. By throttling the function responsible for sending requests to the database, we ensure that only a limited number of requests are sent per second, thereby optimizing system performance.

#### Memoize
A common optimization is to never call a pure function with the same inputs twice. Instead you can avoid the computation by just returning the previously cached result. This is also an important concept in dynamic programming. Benefitting from this optimization could be as simple calling memoize() on the function. memoizee is popular package for this.

#### Time Limit
Suppose you have a long running process that repeats itself (like syncing data from a database to an in-memory cache). If for some reason, an asynchronous function never returns a value (or takes a very long time), that process will become frozen. To guarantee that never happens, you could wrap the asynchronous functions used with time limits.

### Use-cases for Only Allowing One Function Call

The simple answer is it useful for initialization logic. You may have a function that initializes a cache (for example, load a file into memory) and you want to guarantee it only loads once.

You might be wondering, why not just simply avoid calling the function more than once, it's your code after all? Well for one, it's still nice to have that guarantee. But there are also cases where you may want perform the initialization logic lazily.

```
let json;
function loadJsonFromFile() {
  // logic to load file
  json = loadFile();
}

const loadFileOnce = once(loadJsonFromFile);

function getValue(key) {
  loadFileOnce();
  return json[key];
}
```

In this example, you may only want to do the expensive operation of loading the file AFTER ```getValue``` is called. For example, ```getValue``` might be part of a library and may never be called.

Another example of a common use-case is showing a welcome message or introduction when a user first clicks a button.

```
const button = document.querySelector('#start-button');
button.addEventListener('click', once(function() {
  displayWelcomeMessage();
}));
```

---

### Approach 1: Rest Syntax

```JavaScript
/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {
    let was_called = false;
    return function(...args){
        if (was_called) {
            return undefined
        }
        else {
            was_called = true;
            return fn(...args);
        }
    }
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
```

### Approach 2: Implicitly Return Undefined

```JavaScript
/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {
    let was_called = false;
    return function(...args){
        if (!was_called) {
            was_called = true;
            return fn(...args);
        }
    }
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
```

### Approach 3: Bind Function to a Context

JavaScript functions are sometimes bound to a ```this``` context. The most technically correct way to implement a higher-order function is to ensure the provided function is bound to the same context as the returned function.

The following code showcases how functions can behave differently depending on which ```this``` context they are bound to.

```JavaScript
const context = { Name: 'Alice' };

function getName() {
  return this.Name;
}
const boundGetName = getName.bind(context);

getName(); // undefined
getName.apply(context, []); // "Alice"
```

In the above example ```getName``` is NOT bound to context so it returns ```undefined```. However you can use the ```Function.apply``` method to call ```getName()``` AND set ```this``` to be context.

Now suppose you wanted to apply once to a method on a prototype.

```JavaScript
const Person = function(name) {
  this.name = name;
}

Person.prototype.getName = once(function() {
  return this.name;
});

const alice = new Person('Alice');
alice.getName(); // Expected Output: "Alice"
```

In order to get this behavior, you need to use the ```Function.apply``` method to ensure ```getName``` is provided with the appropriate context (the ```alice``` object in this case). Without this, ```getName``` will always return ```undefined```.

Note that this functionality is fairly niche, and isn't required in the problem. But it may be expected in a professional implementation.

```JavaScript
/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {
    let was_called = false;
    return function(...args){
        if (!was_called) {
            was_called = true;
            return fn.apply(this, args);
        }
    }
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
 ```
