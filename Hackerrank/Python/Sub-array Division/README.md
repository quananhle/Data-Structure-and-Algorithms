## [Sub-array Division](https://www.hackerrank.com/challenges/the-birthday-bar/problem)




```{Python}
def birthday(s, d, m):
    count = 0
    possible_step = len(s)- m + 1
    for i in range (possible_step):
        if sum(s[i:i+m]) == d:
            count += 1
    return count
```

One-liner solution

```{Python}
    return len([1 for i in range(len(s)- m + 1) if sum(s[i:i+m])==d])
```
