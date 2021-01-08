## [Recursive Digit Sum](https://www.hackerrank.com/challenges/recursive-digit-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking)


__Code:__ Orange


```{Python}
def superDigit(n, k):
    return (calNum(calNum(n) * int(k)))

def calNum(num):
    return num if len(num) == 1 else calNum(str(sum([int(x) for x in num])))
```    
