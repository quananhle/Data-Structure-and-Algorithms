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

---

### Use-cases for Time Limit

#### Long Running Processes

You may have code which repeats over and over again. A common example of this would be loading data into a cache and keeping it in sync with the data source.

```JavaScript
async function repeatProcessIndefinitely() {
  while (true) {
    try {
      await someProcess();
    } catch (e) {
      console.error(e);
    }
  }
}
```

If ```someProcess``` were to ever never fulfill, the loop would get frozen and nothing would happen. Forcing ```someProcess``` to throw an error would unfreeze the process.

An important consideration is that code in ```someProcess``` can still continue executing even if the promise was rejected. So you might have multiple blocks of code executing in parallel. A better solution may be fix the underlying issue which caused the freeze or to implement proper cancellation. Consider solving Design Cancellable Function to implement true cancellation.

To force the promise ```someProcess()``` returns to reject after an hour:

```JavaScript
const ONE_HOUR_IN_MS = 3600 * 1000;
const timeLimitedProcess = timeLimit(someProcess, ONE_HOUR_IN_MS);
```

### Notify Users of Failure

Imagine a user requested to download a file which you expect should take less than 10 seconds to download. If the download is taking too long, rather than let the user wait, it may be better to just give up and show the user an error message.

Similar to the first use-case, this really should only be done as a last resort. It's likely better to implement a loading indicator and/or fix the underlying issue causing the slowness.

---

### Approach 1: Call Function Inside New Promise

```JavaScript
/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
	return async function(...args) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                reject("Time Limit Exceeded");
            }, t);
            fn(...args).then(resolve).catch(reject);
        })
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */
```
