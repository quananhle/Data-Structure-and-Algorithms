## [Between Two Sets](https://www.hackerrank.com/challenges/between-two-sets/problem)

#### Code: Green

![Alt text](Apples_and_Oranges.png?raw=true "Apples-and-Oranges")

```{Python}
def countApplesAndOranges(s, t, a, b, apples, oranges):
    # print(sum([1 for apple in apples if (apple + a) >= s and (apple + a) <= t]))
    # print(sum([1 for orange in oranges if (orange + b) >= s and (orange + b) <= t]))
    
    print(sum(s <= a + d <= t for apple in apples))
    print(sum(s <= b + d <= t for orange in oranges))
    
```
