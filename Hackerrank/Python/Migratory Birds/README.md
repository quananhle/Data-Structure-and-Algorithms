## [Migatory Birds](https://www.hackerrank.com/challenges/migratory-birds/problem)

#### Code: Green

![Alt text](Migatory_Birds.png?raw=true "Migatory-Birds")

```{Python}
def migratoryBirds(arr):
    freq = {}
    for item in sorted(arr):
        if item in freq:
            freq[item] += 1
        else:
            freq[item] = 1
    key = list(freq.keys())
    val = list(freq.values())
    return key[val.index(max(val))]
```    

or using operator library

```{Java}
import operator
def migratoryBirds(arr):
  freq = {}
  for item in sorted(arr):
      if item in freq:
          freq[item] += 1
      else:
          freq[item] = 1
  return max(freq.iteritems(), key=operator.itemgetter(1))[0]
```
