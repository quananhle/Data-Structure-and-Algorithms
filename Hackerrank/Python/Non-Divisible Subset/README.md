## [Non-Divisible Subset](https://www.hackerrank.com/challenges/non-divisible-subset/problem)




__Code__: Orange

```{Python}
def nonDivisibleSubset(k, s):
    counts = [0] * k
    for number in s:
        counts[number % k] += 1
    print(counts)
    count = min(counts[0], 1)
    print(count)
    for i in range(1, k//2+1):
        if i != k - i:
            count += max(counts[i], counts[k-i])
            print (counts[i], " ", counts[k-i])
    if k % 2 == 0: 
        count += 1
    return count
```
