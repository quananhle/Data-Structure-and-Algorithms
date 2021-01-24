## [Find Prime](https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem)

__Code:__ Orange


#### O(N/2) = O(N) time complexity

```{Python}
arr = int(input())
for _ in range(arr):
    number = int(input())
    if number > 1:
        for i in range (2, number//2+1):
            if number % i == 0:
                print ("Not prime")
                break
        else:
            print ("Prime")
    else:
        print ("Not prime")
```

#### O(sqrt(N))

```{Python}
arr = int(input())
for _ in range(arr):
    number = int(input())
    if number > 1: 
        for i in range (2, int(math.sqrt(number))+1):
            if number % i == 0:
                print ('Not prime')
                break
        else:
            print ('Prime')
    else:
        print ('Not prime')
```


