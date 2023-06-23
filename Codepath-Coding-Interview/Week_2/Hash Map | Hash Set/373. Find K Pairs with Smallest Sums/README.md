## [373. Find K Pairs with Smallest Sums](https://leetcode.com/problems/find-k-pairs-with-smallest-sums)

```Tag```:

#### Difficulty: Medium

You are given two integer arrays ```nums1``` and ```nums2``` sorted in ascending order and an integer ```k```.

Define a pair ```(u, v)``` which consists of one element from the first array and one element from the second array.

Return _the ```k``` pairs ```(u1, v1)```, ```(u2, v2)```, ..., ```(uk, vk)``` with the smallest sums_.

![image](https://github.com/quananhle/Data-Structure-and-Algorithms/assets/35042430/7ca249e2-b0ca-4e5a-8b5d-56ce23608bd1)

---

__Example 1:__
```
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
```

__Example 2:__
```
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
```

__Example 3:__
```
Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
```

__Constraints:__

- ```1 <= nums1.length, nums2.length <= 10^5```
- ```-10^9 <= nums1[i], nums2[i] <= 10^9```
- ```nums1``` and ```nums2``` both are sorted in ascending order.
- ```1 <= k <= 10^4```

---
