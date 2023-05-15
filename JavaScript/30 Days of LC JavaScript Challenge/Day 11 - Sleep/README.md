## [2621. Sleep](https://leetcode.com/problems/sleep)

#### Difficulty: Easy

Given a positive integer ```millis```, write an asyncronous function that sleeps for ```millis``` milliseconds. It can resolve any value.

---

__Example 1:__
```
Input: millis = 100
Output: 100
Explanation: It should return a promise that resolves after 100ms.
let t = Date.now();
sleep(100).then(() => {
  console.log(Date.now() - t); // 100
});
```

__Example 2:__
```
Input: millis = 200
Output: 200
Explanation: It should return a promise that resolves after 200ms.
```

__Constraints:__

- ```1 <= millis <= 1000```

---
