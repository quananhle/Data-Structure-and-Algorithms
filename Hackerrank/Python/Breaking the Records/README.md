```{Python}
def breakingRecords(scores):
    highest_score = lowest_score = scores[0]
    highest_count = lowest_count = 0
    for i in range(1, len(scores)):
        if scores[i] > highest_score:
            highest_score = scores[i]
            highest_count += 1
        if scores[i] < lowest_score:
            lowest_score = scores[i]
            lowest_count += 1
    return(highest_count, lowest_count)
```

One line

```{Python}
import itertools
def breakingRecords(scores):
    return len(set(itertools.accumulate(scores, max)))-1, len(set(itertools.accumulate(scores, min)))-1
```
