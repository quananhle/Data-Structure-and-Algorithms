## [1. Reverse String](https://leetcode.com/problems/reverse-string/)

```
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.
```

__Example 1:__
```
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```
__Example 2:__
```
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
```

Two pointers, 0(1) space complexity, 0(N) time complexity

```{Python}
    def reverseString(self, s):
        left = 0
        right = len(s)-1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1
```

## [2. Reverse String II](https://leetcode.com/problems/reverse-string-ii/)

```
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
```
__Example:__
```
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
```

0(N) space complexity, 0(N) time complexity

```{Python}
    def reverseStr(self, s, k):
        string = list(s)
        for i in range (0, len(string), 2*k):
            string[i:i+k] = string[i:i+k][::-1]
        return "".join(string)
```




## [3. Reverse String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)
