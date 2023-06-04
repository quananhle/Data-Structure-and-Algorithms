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
