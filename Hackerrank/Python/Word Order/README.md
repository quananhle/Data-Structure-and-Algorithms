## [Word Order](https://www.hackerrank.com/challenges/word-order/problem)

![Alt text](Word_Order.png?raw=true "Word-Order")

__Code__: Orange

Using Counter

```{Python}
from collections import Counter
words = [input().strip() for _ in range (int(input()))]
words_dict = Counter(words)
print(len(words_dict))
print(*words_dict.values())
```
