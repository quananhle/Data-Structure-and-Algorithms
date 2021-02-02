## [Ice Cream Parlor](https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=nutanix)

__Code__: Orange


```{Python}
def whatFlavors(cost, money):
    remains = dict()
    for index, c in enumerate(cost):
        if c not in remains:
            remains[money - c] = index + 1
        else:
            print(remains[c], index + 1)
```
