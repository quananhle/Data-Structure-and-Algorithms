## [Two Strings](https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps)






```{Python}
from collections import Counter
# Complete the twoStrings function below.
def twoStrings(s1, s2):
    appear = False
    substring1 = Counter(s1)
    substring2 = Counter(s2)
    for key in substring1.keys():
        if key in substring2.keys():
            appear = True
            break
        else:
            appear = False
    if appear == True:
        return 'YES'
    else:
        return 'NO'
```

#### One-liner solution using set()

```{Python}
from collections import Counter
# Complete the twoStrings function below.
def twoStrings(s1, s2):
    return ('YES' if set(s1).intersection(set(s2)) else 'NO')
```
