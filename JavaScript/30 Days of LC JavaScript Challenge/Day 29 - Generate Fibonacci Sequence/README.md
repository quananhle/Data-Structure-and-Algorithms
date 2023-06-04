## [2648. Generate Fibonacci Sequence](https://leetcode.com/problems/generate-fibonacci-sequence)

```Tag```: ```Generators```

#### Difficulty: Easy

Write a generator function that returns a generator object which yields the fibonacci sequence.

The fibonacci sequence is defined by the relation ```Xn = Xn-1 + Xn-2```.

The first few numbers of the series are ```0, 1, 1, 2, 3, 5, 8, 13```.

---

__Example 1:__
```
Input: callCount = 5
Output: [0,1,1,2,3]
Explanation:
const gen = fibGenerator();
gen.next().value; // 0
gen.next().value; // 1
gen.next().value; // 1
gen.next().value; // 2
gen.next().value; // 3
```

__Example 2:__
```
Input: callCount = 0
Output: []
Explanation: gen.next() is never called so nothing is outputted
```

__Constraints:__

-- ```0 <= callCount <= 50```

---

### Approach 1: Using a ```while``` loop

The ```yield``` keyword pauses the function execution and returns the value of prev1, then it resumes from where it left off in the next call.

```JavaScript
/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    let prev1 = 0;
    let prev2 = 1;

    while (true) {
        yield prev1;
        const temp = prev1;
        prev1 = prev2;
        prev2 += temp;
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
 ```

### Approach 2: Using Destructuring Assignment in Fibonacci Sequence Update

```JavaScript
/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    let a = 0;
    let b = 1;

    while (true) {
        yield a;
        [a, b] = [b, a + b];
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
 ```
 
 ### Approach 3: Recursive
 
 ```JavaScript
 /**
 * @return {Generator<number>}
 */
var fibGenerator = function*(a = 0, b = 1) {
    yield a;

    yield *fibGenerator(b, a + b);
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
 ```
 
 ### Approach 4: Precomputed Array and Custom Iterator
 
 ```JavaScript
 /**
 * @return {Generator<number>}
 */
var fibGenerator = function() {
    const n = 50;

    const sequence = Array(n).fill(0);
    sequence[1] = 1;

    for (let i = 2; i < n; ++i) {
        sequence[i] = sequence[i - 1] + sequence[i - 2];
    }

    return sequence[Symbol.iterator]();
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
 ```
