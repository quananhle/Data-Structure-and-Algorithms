## [2675. Array of Objects to Matrix](https://leetcode.com/problems/array-of-objects-to-matrix)

```Tag```: ```JSON / Recursion / Important Utilities```

#### Difficulty: Medium

Write a function that converts an array of objects ```arr``` into a matrix ```m```.

```arr``` is an array of objects or arrays. Each item in the array can be deeply nested with child arrays and child objects. It can also contain numbers, strings, booleans, and null values.

The first row ```m``` should be the column names. If there is no nesting, the column names are the unique keys within the objects. If there is nesting, the column names are the respective paths in the object separated by ```"."```.

Each of the remaining rows corresponds to an object in ```arr```. Each value in the matrix corresponds to a value in an object. If a given object doesn't contain a value for a given column, the cell should contain an empty string ```""```.

The colums in the matrix should be in lexographically ascending order.

---

__Example 1:__
```
Input:
arr = [
  {"b": 1, "a": 2},
  {"b": 3, "a": 4}
]
Output: 
[
  ["a", "b"],
  [2, 1],
  [4, 3]
]

Explanation:
There are two unique column names in the two objects: "a" and "b".
"a" corresponds with [2, 4].
"b" coresponds with [1, 3].
```

__Example 2:__
```
Input: 
arr = [
  {"a": 1, "b": 2},
  {"c": 3, "d": 4},
  {}
]
Output: 
[
  ["a", "b", "c", "d"],
  [1, 2, "", ""],
  ["", "", 3, 4],
  ["", "", "", ""]
]

Explanation:
There are 4 unique column names: "a", "b", "c", "d".
The first object has values associated with "a" and "b".
The second object has values associated with "c" and "d".
The third object has no keys, so it is just a row of empty strings.
```

__Example 3:__
```
Input: 
arr = [
  {"a": {"b": 1, "c": 2}},
  {"a": {"b": 3, "d": 4}}
]
Output: 
[
  ["a.b", "a.c", "a.d"],
  [1, 2, ""],
  [3, "", 4]
]

Explanation:
In this example, the objects are nested. The keys represent the full path to each value separated by periods.
There are three paths: "a.b", "a.c", "a.d".
```

__Example 4:__
```
Input: 
arr = [
  [{"a": null}],
  [{"b": true}],
  [{"c": "x"}]
]
Output: 
[
  ["0.a", "0.b", "0.c"],
  [null, "", ""],
  ["", true, ""],
  ["", "", "x"]
]

Explanation:
Arrays are also considered objects with their keys being their indices.
Each array has one element so the keys are "0.a", "0.b", and "0.c".
```

__Example 5:__
```
Input: 
arr = [
  {},
  {},
  {},
]
Output: 
[
  [],
  [],
  [],
  []
]

Explanation:
There are no keys so every row is an empty array.
```

__Constraints__:

- ```1 <= arr.length <= 1000```
- ```unique keys <= 1000```

---

### Use Cases:

- __Data Analysis__: Converting the array of objects into a matrix format can be useful for performing various data analysis tasks. It allows you to organize and structure the data in a tabular format, making it easier to perform calculations, aggregations, and statistical analysis.
- __Database Operations__: When interacting with databases, it is often necessary to convert the retrieved data into a matrix format to manipulate or display it. The matrix representation provides a structured format that can be easily integrated with database operations and queries.
- __Data Export__: If you need to export data from your application or system, converting it into a matrix format can be beneficial. Many data interchange formats, such as CSV (Comma-Separated Values) or Excel spreadsheets, follow a tabular structure similar to a matrix. Converting the data into a matrix makes it compatible with these formats, simplifying the exporting process.
- __Visualization__: Matrices are commonly used as input for various visualization techniques, such as charts, graphs, and heatmaps. By converting the array of objects into a matrix, you can feed the data directly into visualization libraries or tools, enabling you to create meaningful visual representations of the data.

### Approach 1: Recursive Approach

```JavaScript
/**
 * @param {Array} arr
 * @return {Matrix}
 */
var jsonToMatrix = function(arr) {
    const isObject = x => (x != null && typeof x === 'object');

    const getKeys = (object) => {
        const isObject = x => (x != null && typeof x === 'object');
        if (!isObject(object)) {
            return [''];
        }
        const result = [];
        for (const key of Object.keys(object)) {
            const childKeys = getKeys(object[key]);
            for (const childKey of childKeys) {
                result.push(childKey ? `${key}.${childKey}` : key);
            }
        }
        return result;
    }

    const keysSet = arr.reduce((acc, curr) => {
        getKeys(curr).forEach((k) => acc.add(k));
        return acc;
    }, new Set());

    const keys = Array.from(keysSet).sort();

    const getValue = (obj, path) => {
        const paths = path.split('.');
        let i = 0;
        let value = obj;
        while (i < paths.length) {
            if (!isObject(value)) {
                break;
            }
            value = value[paths[i++]];
        }
        if (i < paths.length || isObject(value) || value === undefined) {
            return '';
        }
        return value;
    }

    const matrix = [keys]
    arr.forEach(obj => {
        matrix.push(keys.map(key => getValue(obj, key)))
    })

    return matrix;
};
```

### Approach 2: Stack Approach

```JavaScript
/**
 * @param {Array} arr
 * @return {Matrix}
 */
var jsonToMatrix = function (arr) {
  const colMap = new Map();
  const res = [[]];

  const sortCols = (matrix) => {
  // Copy the column names from the first row of the matrix and sort them using localeCompare
  const sortedColNames = matrix[0].slice().sort((a, b) => a.localeCompare(b));

  // Create a new sorted matrix based on the sorted column names
  const sortedMatrix = matrix.map((row) => {
    const sortedRow = [];
    for (let i = 0; i < sortedColNames.length; i++) {
      const colIndex = matrix[0].indexOf(sortedColNames[i]);
      sortedRow.push(row[colIndex]);
    }
    return sortedRow;
  });

  return sortedMatrix;
  };


  for (let i = 0; i < arr.length; i++) {
    const stack = [[arr[i], []]];
    res.push(Array(colMap.size).fill(""));

    while (stack.length > 0) {
      const [front, path] = stack.pop();

      if (typeof front === "object" && front !== null) {
        const keys = Object.keys(front);
        
        for (let j = keys.length - 1; j >= 0; j--) {
          stack.push([front[keys[j]], path.concat(keys[j])]);
        }
      } 
      else if (Array.isArray(front)) {
        for (let j = front.length - 1; j >= 0; j--) {
          stack.push([front[j], path.concat(j)]);
        }
      } 
      else {
        let pathStr = path.join('.');

        if (!colMap.has(pathStr)) {
          res[0].push(pathStr);
          colMap.set(pathStr, res[0].length - 1);

          for (let j = 1; j < res.length; j++) {
            res[j][res[0].length - 1] = "";
          }
        }

        let j = colMap.get(pathStr);
        res[i + 1][j] = front;
      }
    }
  }

  return sortCols(res);
};
```
