## 

https://www.hackerrank.com/challenges/ctci-ransom-note/forum?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps


```{Python}
from collections import Counter
# Complete the checkMagazine function below.
def checkMagazine(magazine, note):
    enough = False
    magazine_words = Counter(magazine)
    ransom_words = Counter(note)
    magazine_keys = [key for key in magazine_words.keys()]
    ransom_keys = [key for key in ransom_words.keys()]
    for key in ransom_keys:
        if key not in magazine_keys:
            enough = False 
            break
        else:
            if magazine_words[key] >= ransom_words[key]:
                enough = True 
            else:
                enough = False
                break
    if enough == True:
        print ('Yes')
    else:
        print ('No')
```
  
#### One-line solution
  
```{Python}
from collections import Counter

def ransom_note(magazine, rasom):
    return (Counter(rasom) - Counter(magazine)) == {}
```
