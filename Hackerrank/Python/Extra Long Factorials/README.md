## [Extra Long Factorials](https://www.hackerrank.com/challenges/extra-long-factorials/problem)

#### Code: Orange

![Alt text](Extra_Long_Factorials?raw=true "Extra-Long-Factorials")

```{Python}
def extraLongFactorials(n):
    res = [None]*500
    res[0] = 1
    res_size = 1
    ans = []
    x = 2
    while x <= n : 
        res_size = multiply(x, res, res_size) 
        x = x + 1
    i = res_size-1
    while i >= 0 : 
        ans.append(res[i]) 
        i = i - 1
    print (int(''.join(str(an) for an in ans)))
```
