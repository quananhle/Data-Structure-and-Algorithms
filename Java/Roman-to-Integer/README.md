#### Left-to-Right Pass

| Symbol        | Value         |
| ------------- |:-------------:|
| I             | 1             |
| V             | 5             |
| X             | 10            |
| L             | 50            |
| C             | 100           |
| D             | 500           |
| M             | 1000          |

Each symbol adds its own value, except for when a smaller valued symbol is before a larger valued symbol. In those cases, instead of adding both symbols to the total, we need to subtract the large from the small, adding that instead.

Therefore, the simplest algorithm is to use a pointer to scan through the string, at each step deciding whether to add the current symbol and go forward 1 place, or add the difference of the next 2 symbols and go forward 2 places. Here is this algorithm in pseudocode.

**Note: Cannot make the assumption that the input is always valid**

```{java}
public int romanToInt(String str) {
```
       
##### Pseudocode
```
total = 0
i = 0
while i < s.length:
    if at least 2 symbols remaining AND value of s[i] < value of s[i + 1]:
        total = total + (value of s[i + 1]) - (value of s[i])  
        i = i + 2
    else:
        total = total + (value of s[i])
        i = i + 1
return total
```

##### Complexity Analysis

Let nnn be the length of the input string (the total number of symbols in it).

* Time complexity : $\mathcal{O}$(1).

       As there is a finite set of roman numerals, the maximum number possible number can be 3999, which in roman numerals is MMMCMXCIX. As such the time complexity is O(1)O(1)O(1).

       If roman numerals had an arbitrary number of symbols, then the time complexity would be proportional to the length of the input, i.e. O(n)O(n)O(n). This is assuming that looking up the value of each symbol is O(1)O(1)O(1).

* Space complexity : O(1)O(1)O(1).

       Because only a constant number of single-value variables are used, the space complexity is O(1)O(1)O(1).

