

### Longest Common Prefix

```{java}
public String longestCommonPrefix(String[] strs) {
```

#### Horizontal scanning

To employ this idea, the algorithm iterates through the strings [S<sub>1</sub>…S<sub>n</sub>], finding at each iteration i the longest common prefix of strings LCP(S<sub>1</sub>…S<sub>i</sub>). When LCP(S<sub>1</sub>…S<sub>i</sub>) is an empty string, the algorithm ends. Otherwise after n iterations, the algorithm returns LCP(S<sub>1</sub>…S<sub>n</sub>).

##### Complexity Analysis

* Time complexity : **O(S)**, where S is the sum of all characters in all strings.

    In the worst case all n strings are the same. The algorithm compares the string S1 with the other strings [S<sub>2</sub>…Sn]. There are S character comparisons, where S is the sum of all characters in the input array.

* Space complexity : **O(1)**. We only used constant extra space. 

#### Vertical scanning

Imagine a very short string is at the end of the array. The above approach will still do S comparisons. One way to optimize this case is to do vertical scanning. We compare characters from top to bottom on the same column (same character index of the strings) before moving on to the next column.

##### Complexity Analysis

* Time complexity : **O(S)**, where S is the sum of all characters in all strings. In the worst case there will be n equal strings with length m and the algorithm performs S=m⋅n character comparisons. Even though the worst case is still the same as Approach 1, in the best case there are at most n⋅minLen comparisons where minLen is the length of the shortest string in the array.

* Space complexity : O(1). We only used constant extra space. 

    Because we're starting at the second-to-last-index, we know that index i + 1 always exists. We no longer need to handle its potential non-existence as a special case, and additionally we're able to (cleanly) use a for loop, as we're always moving along by 1 index at at time, unlike before where it could have been 1 or 2.



