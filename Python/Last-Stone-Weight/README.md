## Last Stone Weight

We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.

At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

**Example 1**:
```
Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
```
 

**Note**:
```
    1 <= stones.length <= 30
    1 <= stones[i] <= 1000
```

### Approach 1: Sorted List Simulation

To simplify the search-for-maximum process, we could instead maintain a sorted array. We'd need to sort the array at the start, and then ensure that each time we need to add a stone back, that we're maintaining the sorted order.

Unfortunately, inserting a stone into a sorted array is an O(N) operation. While we can use binary search to determine where we should put it, inserting it still ultimately requires shifting all of the stones after it down by one place.

#### Complexity Analysis

Let N be the length of stones.
* Time complexity : O(N<sup>2</sup>).

    The first part of the algorithm is sorting the list. This has a cost of O(NlogN).

   We're repeating the main loop up to N−1 times. And again, we're doing an O(N) operation each time; adding the new stone back into the array, maintaining sorted order by shuffling existing stones along to make space for it. Identifying the two largest stones was O(1) in this approach, but unfortunately this was subsumed by the inefficient adds. This gives us a total of O(N<sup>2</sup>).

    Because O(N<sup>2</sup>) is strictly larger than O(NlogN), we're left with a final time complexity of O(N<sup>2</sup>).

* Space complexity : Varies from O(N) to O(1).

    We can choose whether or not to modify the input list. If we do modify the input list, this will cost anywhere from O(N) to O(1) space, depending on the sorting algorithm used. However, if we don't, it will always cost at least O(N) to make a copy. Modifying the input has its pros and cons; it saves space, but it means that other functions can't use the same array.

An alternative to this approach is to simply sort inside the loop every time. This will be even worse, with a time complexity of O(N<sup>2</sup>logN).

### Approach 2: Swap Solution

Conceptually, the simplest way we could solve this problem is to repeatedly search for the 2 largest stones in the array, delete them, and then if they are not the same size, add the new stone size back in. We can repeat this process until there is only one stone left.

Because the array is not sorted, there is no need to preserve the original order. Removals should be done by swapping with the last value, not by shuffling all values along.

#### Complexity Analysis

Let N be the **length of stones**. 

* Time complexity : O(N<sup>2</sup>).

    The only non-O(1) method of StoneArray is findAndRemoveMax(). This method does a single pass over the array, to find the index of the maximum value. This pass has a cost of O(N). Once we find the maximum value, we delete it, although this only has a cost of O(1) because instead of shuffling along, we're simply swapping with the end.

    Each time around the main loop, there is a net loss of either 1 or 2 stones. Starting with N stones and needing to get to 111 stone, this is up to N−1 iterations. On each of these iterations, it finds the maximum twice. In total, we get O(N<sup>2</sup>).

    Note that even if we'd shuffled instead of swapped with the end, the findAndRemoveMax() method still would have been O(N), as the pass and then deletion are done one-after-the-other. However, it's often best to avoid needlessly large constants.

* Space complexity : O(N) or O(1).

    For the Python: We are not allocating any new space for data structures, and instead are modifying the input list. Note that this modifies the input. This has its pros and cons; it saves space, but it means that other functions can't use the same array.

    For the Java: We need to convert the input to an ArrayList, and therefore the ints to Integers. It is possible to write a O(1) space solution for Java, however it is long-winded and a lot of work for what is a poor overall approach anyway.
