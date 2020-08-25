## Counting Elements

Given an integer array ```arr```, count how many elements ```x``` there are, such that ```x + 1``` is also in ```arr```.

If there are duplicates in ```arr```, count them seperately.

* Example 1:
```
Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
```
* Example 2:
```
Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
```
* Example 3:
```
Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
```
* Example 4:
```
Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.
```
* Example 5:
```
Input: arr = [1,1,2]
Output: 2
Explanation: Both 1s are counted because 2 is in the array.
```
**Constraints**:

    1 <= arr.length <= 1000
    0 <= arr[i] <= 1000



```{python}
    def countElements(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
```
### Approach 1:

The simplest way of solving this problem is to loop through each integer, x, checking whether or not it should be counted. This requires checking whether or not x + 1 is in arr.

```
define function count_elements(arr):
    count = 0
    for each x in arr:
        if integer_in_array(arr, x + 1):
            count = count + 1
    return count
```

To implement the integer_in_array function in the above algorithm, we can use linear search. To do a linear search, we need to loop through each integer of arr. If we find the integer that we're looking for, then return true. If we get to the end of arr, then we know the integer is not there, and so should return false.

```{python}
define function integer_in_array(arr, target):
    for each x in arr:
        if target is equal to x:
            return true
    return false
```

#### Complexity Analysis

Let N be the length of the input array, arr.

* Time complexity : O(N<superscript>2</superscript>).<sup>2</sup>

    We loop through each of the NNN integers x, checking whether or not x + 1 is also in arr. Checking whether or not x + 1 is in arr is done using linear search, which requires checking through all NNN integers in arr. Because we're doing NNN operations NNN times, we get a time complexity of O(N2)O(N^2)O(N2).

    Space complexity : O(1)O(1)O(1).

    We are only using a constant number of single-value variables (e.g. count), giving us a space complexity of O(1)O(1)O(1).
