## [2667. Create Hello World Function](https://leetcode.com/problems/create-hello-world-function/?utm_campaign=PostD1&utm_medium=Post&utm_source=Post&gio_link_id=QPDw0kJR)

#### Difficulty: Easy

Write a function ```createHelloWorld```. It should return a new function that always returns ```"Hello World"```.
 
---

__Example 1:__
```
Input: args = []
Output: "Hello World"
Explanation:
const f = createHelloWorld();
f(); // "Hello World"

The function returned by createHelloWorld should always return "Hello World".
```

__Example 2:__
```
Input: args = [{},null,42]
Output: "Hello World"
Explanation:
const f = createHelloWorld();
f({}, null, 42); // "Hello World"

Any arguments could be passed to the function but it should still always return "Hello World".
```

__Constraints:__

- ```0 <= args.length <= 10```

---


