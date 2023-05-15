## [2632. Curry](https://leetcode.com/problems/curry)

#### Difficulty: Medium

Given a function ```fn```, return _a curried version of that function_.

A __curried__ function is a function that accepts fewer or an equal number of parameters as the original function and returns either another curried function or the same value the original function would have returned.

In practical terms, if you called the original function like ```sum(1,2,3)```, you would call the curried version like ```csum(1)(2)(3)```, ```csum(1)(2,3)```, ```csum(1,2)(3)```, or ```csum(1,2,3)```. All these methods of calling the curried function should return the same value as the original.

---

__Example 1:__
```
Input: 
fn = function sum(a, b, c) { return a + b + c; }
inputs = [[1],[2],[3]]
Output: 6
Explanation:
The code being executed is:
const curriedSum = curry(fn);
curriedSum(1)(2)(3) === 6;
curriedSum(1)(2)(3) should return the same value as sum(1, 2, 3).
```

__Example 2:__
```
Input:
fn = function sum(a, b, c) { return a + b + c; }
inputs = [[1,2],[3]]
Output: 6
Explanation:
curriedSum(1, 2)(3) should return the same value as sum(1, 2, 3).
```

__Example 3:__
```
Input:
fn = function sum(a, b, c) { return a + b + c; }
inputs = [[],[],[1,2,3]]
Output: 6
Explanation:
You should be able to pass the parameters in any way, including all at once or none at all.
curriedSum()()(1, 2, 3) should return the same value as sum(1, 2, 3).
```

__Example 4:__
```
Input:
fn = function life() { return 42; }
inputs = [[]]
Output: 42
Explanation:
currying a function that accepts zero parameters should effectively do nothing.
curriedLife() === 42
```

__Constraints:__

- ```1 <= inputs.length <= 1000```
- ```0 <= inputs[i][j] <= 10^5```
- ```0 <= fn.length <= 1000```
- ```inputs.flat().length == fn.length```
- function parameters explicitly defined

---

Currying is a powerful technique in functional programming that transforms a function with multiple arguments into a sequence of functions. It allows you to create flexible and reusable code by enabling partial application of function arguments. In this article, we will discuss the concept and implementation of currying in JavaScript.

Currying in JavaScript has several practical applications that can help improve code readability, maintainability, and reusability. Here are some practical use cases of currying:

1. Reusable utility functions: Currying can help create reusable utility functions that can be easily customized for specific use cases. Currying allows you to create a function that returns another function with a partially applied argument. In this case, we have a curried add function that takes two arguments, a and b. When you call add with a single argument, it returns a new function that takes the second argument b and adds it to the initially provided a.

```JavaScript
const add = a => b => a + b;

// Create a new function 'add5' by calling the curried 'add' function with the value 5.
// The returned function will take a single argument 'b' and add it to 5.
const add5 = add(5);

// Now, when we call 'add5' with a value (e.g., 3), it adds 5 to the input value, resulting in 8.
const result = add5(3); // 8
```

2. Event handling: In event-driven programming, currying can be used to create event handlers with specific configurations, while keeping the core event handling function generic.

```JavaScript
const handleClick = buttonId => event => {
   console.log(`Button ${buttonId} clicked`, event);
};

const button1Handler = handleClick(1);
document.getElementById("button1").addEventListener("click", button1Handler);
```

3. Customizing API calls: Currying can help create more specific API calls based on a generic API call function.

```JavaScript
const apiCall = baseUrl => endpoint => params =>
        fetch(`${baseUrl}${endpoint}`, { ...params });

const myApiCall = apiCall("https://my-api.com");
const getUser = myApiCall("/users");
const updateUser = myApiCall("/users/update");

// Usage:
getUser({ userId: 1 });
updateUser({ userId: 1, name: "John Doe" });
```

4. Higher-order functions and functional composition: Currying enables the creation of higher-order functions that can be composed to create more complex functionality.

```JavaScript
const compose = (f, g) => x => f(g(x));

const double = x => x * 2;
const square = x => x * x;

const doubleThenSquare = compose(square, double);

const result = doubleThenSquare(5); // (5 * 2)^2 = 100
```

---
