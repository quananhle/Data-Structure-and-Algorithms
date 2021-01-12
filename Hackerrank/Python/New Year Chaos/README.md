## [New Year Chaos](https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays)

![Alt text](New_Year_Chaos.png?raw=true "New-Year-Chaos")

__Code__: Orange

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
