## [2677. Chunk Array](https://leetcode.com/problems/chunk-array)

```Tag```: ```JSON / Recursion / Important Utilities```

#### Difficulty: Easy

Given an array ```arr``` and a chunk size ```size```, return _a chunked array_. A chunked array contains the original elements in ```arr```, but consists of subarrays each of length ```size```. The length of the last subarray may be less than ```size``` if ```arr.length``` is not evenly divisible by ```size```.

You may assume the array is the output of ```JSON.parse```. In other words, it is valid JSON.

Please solve it without using lodash's ```_.chunk``` function.

---

__Example 1:__
```
Input: arr = [1,2,3,4,5], size = 1
Output: [[1],[2],[3],[4],[5]]
Explanation: The arr has been split into subarrays each with 1 element.
```

__Example 2:__
```
Input: arr = [1,9,6,3,2], size = 3
Output: [[1,9,6],[3,2]]
Explanation: The arr has been split into subarrays with 3 elements. However, only two elements are left for the 2nd subarray.
```

__Example 3:__
```
Input: arr = [8,5,3,2,6], size = 6
Output: [[8,5,3,2,6]]
Explanation: Size is greater than arr.length thus all elements are in the first subarray.
```

__Example 4:__
```
Input: arr = [], size = 1
Output: []
Explanation: There are no elements to be chunked so an empty array is returned.
```

__Constraints:__

- ```arr``` is a valid JSON array
- ```2 <= JSON.stringify(arr).length <= 10^5```
- ```1 <= size <= arr.length + 1```

---

### Use Cases:

__Pagination__:

- When implementing pagination in a web application, you often need to split a large list of items into smaller chunks or pages. The chunking operation allows you to divide the items into manageable portions, making it easier to display and navigate through the data.
- In the example usage, let's say we have an array of ```10``` items and want to display ```3``` items per page. We specify the current page number as ```2```4. The function will be called with these parameters, and the resulting chunked array (representing the items for the second page) should be logged to the console.

```JavaScript
function paginateArray(array, pageSize, pageNumber) {
// Calculate the starting index of the current page
const startIndex = (pageNumber - 1) * pageSize;

// Create a chunk of the array based on the page size
const chunkedArray = array.slice(startIndex, startIndex + pageSize);

return chunkedArray;
}

// Example usage
const data = [
'Racoon 1', 'Racoon 2', 'Racoon 3', 'Racoon 4', 'Racoon 5',
'Racoon 6', 'Racoon 7', 'Racoon 8', 'Racoon 9', 'Racoon 10'
];

const pageSize = 3; // Number of items per page
const pageNumber = 2; // Current page number

const result = paginateArray(data, pageSize, pageNumber);
console.log(result);
```

__Parallel Processing__:

- In parallel computing or distributed systems, data is often divided into chunks and processed simultaneously by multiple processors or nodes. Chunking the data allows for efficient distribution and parallel execution of tasks, improving overall performance.

__Image Processing__:

- In image processing applications, large images are often divided into smaller blocks or tiles to enable processing and analysis at a more granular level. Each tile can be independently processed, allowing for parallelization and efficient utilization of computational resources.

__Data Analysis and Aggregation__:

- When dealing with large datasets, it can be beneficial to divide the data into smaller chunks for analysis and aggregation purposes. This approach allows for parallel or distributed processing, enabling faster data processing and efficient resource utilization.

__File Upload and Transfer__:

- When uploading or transferring large files, the data is typically sent in smaller chunks to handle potential network limitations and ensure reliable delivery. The receiving end can process each chunk independently and reassemble them to reconstruct the original file.

### Approach 1: Using Brute Force

Complexity Analysis:

- __Time Complexity__: ```O(n)```, where ```n``` is the length or size of the input array.
- __Space Complexity__: ```O(n)```, where ```n``` is the length or size of the input array.

```JavaScript
/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    const array = [];
    let i = 0;
    while (i < arr.length) {
        let count = size;
        const temp = [];
        while (count-- > 0 && i < arr.length) {
            temp.push(arr[i]);
            i++;
        }
        array.push(temp);
    }
    return array;
};
```

### Approach 2: Using Slicing

- __Time Complexity__: ```O(n)```, where ```n``` is the length or size of the input array.
- __Space Complexity__: ```O(1)```.

```JavaScript
/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    const array = [];
    let i = 0;

    while (i < arr.length) {
        array.push(arr.slice(i, i + size));
        i += size;
    }
    
    return array;
};
```

### Approach 3: Using Splice and Slice

- __Time Complexity__: ```O(n^2)```, where ```n``` is the length or size of the input array.
- __Space Complexity__: ```O(n)```, where ```n``` is the length or size of the input array.

```JavaScript
/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    let array = [[]];
    let temp = [];

    for (let i = 0; i < arr.length; i = i + size) {
        for (let j = 0; j < size; j++) {
            temp[j] = arr[j + i];
            if (j + i === arr.length) {
                temp.splice(j);
                break;
            }
        }
        array = [...array, [...temp]];
    }

    return array.slice(1);
};
```

### Approach 4: Using Reduce

```JavaScript
/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    return arr.reduce((array, elem) => {
        const lastChunk = array[array.length - 1];
        if (!lastChunk || lastChunk.length === size) {
            array.push([elem]);
        }
        else {
            lastChunk.push(elem);
        }
        return array;
    }, []);
};
```

### Approach 5: Push

```JavaScript
/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    const res = [];
    let currentChunk = [];

    for (const element of arr) {
        if (currentChunk.length === size) {
            res.push(currentChunk);
            currentChunk = [];
        }
        currentChunk.push(element);
    }
    if (currentChunk.length) {
        res.push(currentChunk);
    }
    return res;
};
```

### Approach 6: Using Ceiling

```JavaScript
/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    return Array.from({length: Math.ceil(arr.length / size)}, function(_, i) {
        return arr.slice(i * size, i * size + size);
    })
};
```
