## [2636. Promise Pool](https://leetcode.com/problems/promise-pool)

#### Difficulty: Medium

Given an array of asyncronous functions ```functions``` and a pool limit ```n```, return _an asyncronous function ```promisePool```_. It should return a promise that resolves when all the input functions resolve.

Pool limit is defined as the maximum number promises that can be pending at once. ```promisePool``` should begin execution of as many functions as possible and continue executing new functions when old promises resolve. ```promisePool``` should execute ```functions[i]``` then ```functions[i + 1]``` then ```functions[i + 2]```, etc. When the last promise resolves, ```promisePool``` should also resolve.

For example, if ```n = 1```, ```promisePool``` will execute one function at a time in series. However, if ```n = 2```, it first executes two functions. When either of the two functions resolve, a 3rd function should be executed (if available), and so on until there are no functions left to execute.

You can assume all ```functions``` never reject. It is acceptable for ```promisePool``` to return a promise that resolves any value.

---

__Example 1:__
```
Input: 
functions = [
  () => new Promise(res => setTimeout(res, 300)),
  () => new Promise(res => setTimeout(res, 400)),
  () => new Promise(res => setTimeout(res, 200))
]
n = 2
Output: [[300,400,500],500]
Explanation:
Three functions are passed in. They sleep for 300ms, 400ms, and 200ms respectively.
They resolve at 300ms, 400ms, and 500ms respectively. The returned promise resolves at 500ms.
At t=0, the first 2 functions are executed. The pool size limit of 2 is reached.
At t=300, the 1st function resolves, and the 3rd function is executed. Pool size is 2.
At t=400, the 2nd function resolves. There is nothing left to execute. Pool size is 1.
At t=500, the 3rd function resolves. Pool size is zero so the returned promise also resolves.
```

__Example 2:__
```
Input:
functions = [
  () => new Promise(res => setTimeout(res, 300)),
  () => new Promise(res => setTimeout(res, 400)),
  () => new Promise(res => setTimeout(res, 200))
]
n = 5
Output: [[300,400,200],400]
Explanation:
The three input promises resolve at 300ms, 400ms, and 200ms respectively.
The returned promise resolves at 400ms.
At t=0, all 3 functions are executed. The pool limit of 5 is never met.
At t=200, the 3rd function resolves. Pool size is 2.
At t=300, the 1st function resolved. Pool size is 1.
At t=400, the 2nd function resolves. Pool size is 0, so the returned promise also resolves.
```

__Example 3:__
```
Input:
functions = [
  () => new Promise(res => setTimeout(res, 300)),
  () => new Promise(res => setTimeout(res, 400)),
  () => new Promise(res => setTimeout(res, 200))
]
n = 1
Output: [[300,700,900],900]
Explanation:
The three input promises resolve at 300ms, 700ms, and 900ms respectively.
The returned promise resolves at 900ms.
At t=0, the 1st function is executed. Pool size is 1.
At t=300, the 1st function resolves and the 2nd function is executed. Pool size is 1.
At t=700, the 2nd function resolves and the 3rd function is executed. Pool size is 1.
At t=900, the 3rd function resolves. Pool size is 0 so the returned promise resolves.
```

__Constraints:__

- ```0 <= functions.length <= 10```
- ```1 <= n <= 10```

---

### Use-case for Promise Pool

Imagine you have a long list of files you have to download, and you can only download them one at a time. If you requested all of them at once in parallel (using ```Promise.all```), several bad things could happen:

1. The environment may cancel requests because it detects that there are too many to handle.
2. The database may become unresponsive under the heavy load.
3. Too much network traffic could cause higher priority requests to get delayed.
4. The app could become unresponsive trying to process all the data at once.

An alternative approach could be to process one file at a time:

```JavaScript
for (const filename of files) {
  await download(filename);
}
```

However, this is slow and doesn't take advantage of parallelization.

The optimal approach is to decide on a reasonable limit on the number of concurrent requests and use a promise pool. Using the implementation asked for in this problem, it would look like this:

```JavaScript
const files = ["data.json", "data2.json", "data3.json"];

// weird double arrow function because we want to create functions
// but we don't want to execute them until later
const functions = files.map(filename => () => download(filename));

const POOL_LIMIT = 2;
await promisePool(functions, POOL_LIMIT);
```

### Approach 1: Recursive Helper Function

1. Every time we execute a new function, we increment ```functionIndices``` and we increment ```inProgressCount```.
2. Every time a promise resolves, we decrement ```inProgressCount```, and repeat step 1 while ```inProgressCount < n``` and there are still functions left to execute
3. If at any point, ```functionIndices == functions.length``` and ```inProgressCount == 0```, we are done and should resolve the returned promise.

```JavaScript
/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Function}
 */
var promisePool = async function(functions, n) {
    return new Promise((resolve) => {
        let inProgressCount = 0;
        let functionIndices = 0;
        function helper() {
            // Base case
            if (functionIndices >= functions.length) {
                if (inProgressCount === 0) {
                    resolve();
                    return;
                }
            }
            while (inProgressCount < n && functionIndices < functions.length) {
                inProgressCount += 1;
                const promise = functions[functionIndices]();
                functionIndices += 1;
                promise.then(() => {
                    inProgressCount -= 1;
                    helper();
                });
            }
        }
        helper();
    })
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */
```

### Approach 2: Async/Await + Promise.all() + Array.shift()

We can define a recursive function evaluateNext that:

1. Immediately returns if there are no functions to execute (the base case).
2. Removes the first function from the list of functions (using ```Array.shift```).
3. Executes that same first function and waits for its completion.
4. Recursively calls itself and waits for its own completion. That way as soon as any function finishes, the next function in the queue is processed.

```JavaScript
/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Function}
 */
var promisePool = async function(functions, n) {
    async function evaluateNext() {
        if (functions.length === 0) {
            return;
        }
        const fn = functions.shift();
        await fn();
        await evaluateNext();
    }
    const nPromises = Array(n).fill().map(evaluateNext);
    await Promise.all(nPromises);
};
```

### Approach 3: 2-Liner

```JavaScript
/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Function}
 */
var promisePool = async function(functions, n) {
    const evaluateNext = () => functions[n++]?.().then(evaluateNext);
    return Promise.all(functions.slice(0, n).map(f => f().then(evaluateNext)));
};
```
