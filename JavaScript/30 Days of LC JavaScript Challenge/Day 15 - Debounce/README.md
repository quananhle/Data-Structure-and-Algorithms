## [2627. Debounce](https://leetcode.com/problems/debounce)

#### Difficulty: Medium

Given a function ```fn``` and a time in milliseconds ```t```, return _a debounced version of that function_.

A __debounced function__ is a function whose execution is delayed by ```t``` milliseconds and whose execution is cancelled if it is called again within that window of time. The debounced function should also recieve the passed parameters.

For example, let's say ```t = 50ms```, and the function was called at ```30ms```, ```60ms```, and ```100ms```. The first 2 function calls would be cancelled, and the 3rd function call would be executed at ```150ms```. If instead ```t = 35ms```, The 1st call would be cancelled, the 2nd would be executed at ```95ms```, and the 3rd would be executed at ```135ms```.

![image](https://assets.leetcode.com/uploads/2023/04/08/screen-shot-2023-04-08-at-11048-pm.png)

Debounce Schematic
The above diagram shows how debounce will transform events. Each rectangle represents 100ms and the debounce time is 400ms. Each color represents a different set of inputs.

Please solve it without using ```lodash's _.debounce()``` function.

---

__Example 1:__
```
Input: 
t = 50
calls = [
  {"t": 50, inputs: [1]},
  {"t": 75, inputs: [2]}
]
Output: [{"t": 125, inputs: [2]}]
Explanation:
let start = Date.now();
function log(...inputs) { 
  console.log([Date.now() - start, inputs ])
}
const dlog = debounce(log, 50);
setTimeout(() => dlog(1), 50);
setTimeout(() => dlog(2), 75);

The 1st call is cancelled by the 2nd call because the 2nd call occurred before 100ms
The 2nd call is delayed by 50ms and executed at 125ms. The inputs were (2).
```

__Example 2:__
```
Input: 
t = 20
calls = [
  {"t": 50, inputs: [1]},
  {"t": 100, inputs: [2]}
]
Output: [{"t": 70, inputs: [1]}, {"t": 120, inputs: [2]}]
Explanation:
The 1st call is delayed until 70ms. The inputs were (1).
The 2nd call is delayed until 120ms. The inputs were (2).
```

__Example 3:__
```
Input: 
t = 150
calls = [
  {"t": 50, inputs: [1, 2]},
  {"t": 300, inputs: [3, 4]},
  {"t": 300, inputs: [5, 6]}
]
Output: [{"t": 200, inputs: [1,2]}, {"t": 450, inputs: [5, 6]}]
Explanation:
The 1st call is delayed by 150ms and ran at 200ms. The inputs were (1, 2).
The 2nd call is cancelled by the 3rd call
The 3rd call is delayed by 150ms and ran at 450ms. The inputs were (5, 6).
```

__Constraints:__

- ```0 <= t <= 1000```
- ```1 <= calls.length <= 10```
- ```0 <= calls[i].t <= 1000```
- ```0 <= calls[i].inputs.length <= 10```

---

This question asks you to implement the debounce higher-order function. After the debounced function is called, the provided function should be called with the same arguments but with some delay ```t```. However, if the debounced function was called again before ```t``` milliseconds have elapsed, the execution of the provided function should be cancelled and the timer reset.

To give a concrete example of debounce in action:

```JavaScript
const start = Date.now();
function log() {
  console.log(Date.now() - start);
}

setTimeout(log, 10); // logs: 10
setTimeout(log, 20); // logs: 20
setTimeout(log, 50); // logs: 50
setTimeout(log, 60); // logs: 60
```

As expected, the ```log``` function is called with the delay specified by ```setTimeout```.

However, if we debounce the ```log``` function:

```JavaScript
const start = Date.now();
function log() {
  console.log(Date.now() - start);
}
const debouncedLog = debounce(log, 20);

setTimeout(debouncedLog, 10); // cancelled
setTimeout(debouncedLog, 20); // logs: 40
setTimeout(debouncedLog, 50); // cancelled
setTimeout(debouncedLog, 60); // logs: 80
```

In the above example, the function call at ```t=10ms``` is cancelled because the call at ```t=20ms``` happened within ```20ms```. The call at ```t=20ms``` was delayed by ```20ms```.

Similarly, the function call at ```t=50ms``` is canceled because the call at ```t=60ms``` happened within ```20ms```. The call at ```t=60ms``` was delayed by ```20ms```.

### Use-cases for Debounce

The main use-case is when you don't want the result of some user interaction to effect the user experience.

A classic use-case of debounce is when the user is typing into a search field. If you were to show new results every single time a character was typed, the act of re-rendering the new filtered list could potentially take longer than the time it takes to type another character. This will result in a frustrating delay when the user is typing (something you have probably experienced).

Ideally, what should happen is the function that renders the filtered list is debounced. That way, it only renders AFTER the user is done typing.

Another example would be zooming out on a chart via pinch-and-zoom. More data will need to be downloaded once zoomed out. However, it would be extremely inefficient if a new request was made at 60 frames per second as the user zooms out. Just like in the typing example, you should only query for more data when the user is DONE zooming out.

```JavaScript
async function fetchNewData(startDate, endDate) {
  // Request Logic
}
const debouncedFetch = debounce(fetchNewData, 300);

chart.on('zoom', (startDate, endDate) => {
  debouncedFetch(startDate, endDate);
});
```

### Approach 1: setTimeout + clearTimeout

```JavaScript
/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    let timeout;
    return function(...args) {
        clearTimeout(timeout);
        timeout = setTimeout(() => {
            fn(...args);
        }, t);
    };
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */
 ```
 
 ### Approach 2: setInterval + clearInterval
 
 ```JavaScript
 /**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    let interval;
    return function(...args) {
        const lastCall = Date.now();
        clearInterval(interval);
        interval = setInterval(() => {
            if (Date.now() - lastCall >= t) {
                fn(...args);
                clearInterval(interval);
            }
        }, 1);
    };
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */
 ```
