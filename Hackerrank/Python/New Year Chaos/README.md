
Orange

```{Python}
def minimumBribes(q):
    moves = 0                
    for i,e in enumerate(q):
        if e - i > 3:
            print("Too chaotic")
            return
        for j in range(max(e-2,0),i):
            if q[j] > e:
                moves += 1     
    print (moves)
```
