## [2649. Nested Array Generator](https://leetcode.com/problems/nested-array-generator)

```Tag```: ```Generators```

#### Difficulty: Medium

Given a multi-dimensional array of integers, return a generator object which yields integers in the same order as inorder traversal.

A multi-dimensional array is a recursive data structure that contains both integers and other multi-dimensional arrays.

inorder traversal iterates over each array from left to right, yielding any integers it encounters or applying inorder traversal to any arrays it encounters.

 
---

__Example 1:__
```
Input: arr = [[[6]],[1,3],[]]
Output: [6,1,3]
Explanation:
const generator = inorderTraversal(arr);
generator.next().value; // 6
generator.next().value; // 1
generator.next().value; // 3
generator.next().done; // true
```

__Example 2:__
```
Input: arr = []
Output: []
Explanation: There are no integers so the generator doesn't yield anything.
```

__Constraints:__

- ```0 <= arr.flat().length <= 10^5```
- ```0 <= arr.flat()[i] <= 10^5```
- ```maxNestingDepth <= 10^5```

---

### Recursive

```JavaScript
/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {
    if (!Array.isArray(arr)) {
        yield arr;
        return
    }
    for (let i = 0; i < arr.length; ++i) {
        yield* inorderTraversal(arr[i]);
    }
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */
 ```
 
 ### Iterative
 
 ```JavaScript
 /**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function* (arr) {
    const stack = [arr];
  
    while (stack.length > 0) {
        const current = stack.pop();

        if (!Array.isArray(current)) {
            yield current;
            continue;
        }

        for (let i = current.length - 1; i >= 0; i--) {
            stack.push(current[i]);
        }
    }
}

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */
 ```
 

