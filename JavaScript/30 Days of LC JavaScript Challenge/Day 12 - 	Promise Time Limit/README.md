## [2637. Promise Time Limit](https://leetcode.com/problems/promise-time-limit)

#### Difficulty: Easy

Given an asyncronous function ```fn``` and a time ```t``` in milliseconds, return a new __time limited__ version of the input function.

A time limited function is a function that is identical to the original unless it takes longer than ```t``` milliseconds to fullfill. In that case, it will reject with ```"Time Limit Exceeded"```.  Note that it should reject with a string, not an ```Error```.

---

__Example 1:__
```
Input: 
fn = async (n) => { 
  await new Promise(res => setTimeout(res, 100)); 
  return n * n; 
}
inputs = [5]
t = 50
Output: {"rejected":"Time Limit Exceeded","time":50}
Explanation:
The provided function is set to resolve after 100ms. However, the time limit is set to 50ms. It rejects at t=50ms because the time limit was reached.
```

__Example 2:__
```
Input: 
fn = async (n) => { 
  await new Promise(res => setTimeout(res, 100)); 
  return n * n; 
}
inputs = [5]
t = 150
Output: {"resolved":25,"time":100}
Explanation:
The function resolved 5 * 5 = 25 at t=100ms. The time limit is never reached.
```

__Example 3:__
```
Input: 
fn = async (a, b) => { 
  await new Promise(res => setTimeout(res, 120)); 
  return a + b; 
}
inputs = [5,10]
t = 150
Output: {"resolved":15,"time":120}
Explanation:
The function resolved 5 + 10 = 15 at t=120ms. The time limit is never reached.
```

__Example 4:__
```
Input: 
fn = async () => { 
  throw "Error";
}
inputs = []
t = 1000
Output: {"rejected":"Error","time":0}
Explanation:
The function immediately throws an error.
```

__Constraints:__

- ```0 <= inputs.length <= 10```
- ```0 <= t <= 1000```
- ```fn``` returns a promise
