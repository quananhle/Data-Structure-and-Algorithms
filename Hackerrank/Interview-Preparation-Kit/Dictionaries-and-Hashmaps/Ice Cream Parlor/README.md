## [Ice Cream Parlor](https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=nutanix)

__Code__: Orange


```{Python}
def whatFlavors(cost, money):
    remains = dict()
    for i, c in enumerate(cost):
        if c not in remains:
            remains[money - c] = i + 1
        else:
            print(remains[c], i + 1)
```
