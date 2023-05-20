## [2676. Throttle](https://leetcode.com/problems/throttle)

#### Difficulty: Medium

Given a function ```fn``` and a time in milliseconds ```t```, return _a throttled version of that function_.

A throttled function is first called without delay and then, for a time interval of ```t``` milliseconds, can't be executed but should store the latest function arguments provided to call ```fn``` with them after the end of the delay.

For instance, ```t = 50ms```, and the function was called at ```30ms```, ```40ms```, and ```60ms```. The first function call would block calling functions for the following ```t``` milliseconds. The second function call would save arguments, and the third call arguments should overwrite currently stored arguments from the second call because the second and third calls are called before ```80ms```. Once the delay has passed, the throttled function should be called with the latest arguments provided during the delay period, and it should also create another delay period of ```80ms + t```.

![image](https://assets.leetcode.com/uploads/2023/04/08/screen-shot-2023-04-08-at-120313-pm.png)

The above diagram shows how throttle will transform events. Each rectangle represents ```100ms``` and the throttle time is ```400ms```. Each color represents a different set of inputs.

---

__Example 1:__
```
Input: t = 100, calls = [{"t":20,"inputs":[1]}]
Output: [{"t":20,"inputs":[1]}]
Explanation: The 1st call is always called without delay
```

__Example 2:__
```
Input: t = 50, calls = [{"t":50,"inputs":[1]},{"t":75,"inputs":[2]}]
Output: [{"t":50,"inputs":[1]},{"t":100,"inputs":[2]}]
Explanation: 
The 1st is called a function with arguments (1) without delay.
The 2nd is called at 75ms, within the delay period because 50ms + 50ms = 100ms, so the next call can be reached at 100ms. Therefore, we save arguments from the 2nd call to use them at the callback of the 1st call.
```

__Example 3:__
```
Input: t = 70, calls = [{"t":50,"inputs":[1]},{"t":75,"inputs":[2]},{"t":90,"inputs":[8]},{"t": 140, "inputs":[5,7]},{"t": 300, "inputs": [9,4]}]
Output: [{"t":50,"inputs":[1]},{"t":120,"inputs":[8]},{"t":190,"inputs":[5,7]},{"t":300,"inputs":[9,4]}]
Explanation: 
The 1st is called a function with arguments (1) without delay.
The 2nd is called at 75ms within the delay period because 50ms + 70ms = 120ms, so it should only save arguments. 
The 3rd is also called within the delay period, and because we need just the latest function arguments, we overwrite previous ones. After the delay period, we do a callback at 120ms with saved arguments. That callback makes another delay period of 120ms + 70ms = 190ms so that the next function can be called at 190ms.
The 4th is called at 140ms in the delay period, so it should be called as a callback at 190ms. That will create another delay period of 190ms + 70ms = 260ms.
The 5th is called at 300ms, but it is after 260ms, so it should be called immediately and should create another delay period of 300ms + 70ms = 370ms.
```

__Constraints:__

- ```0 <= t <= 1000```
- ```1 <= calls.length <= 10```
- ```0 <= calls[i].t <= 1000```
- ```0 <= calls[i].inputs[i], calls[i].inputs.length <= 10```

---



