## [Between Two Sets](https://www.hackerrank.com/challenges/between-two-sets/problem)

#### Code: Green

![Alt text](Between_Two_Sets.png?raw=true "Between-Two-Sets")


```{Python}
def getTotalX(a, b):
    # Write your code here
    count = 0
    for i in range(1, max(b)+1):
        if all(i % aa == 0 for aa in a):
            if all(bb %i  == 0 for bb in b):
                count += 1
    return count
    # return sum([1-(any(i%x for x in a) or any(x%i for x in b)) for i in range(max(a),min(b)+1)])
```
