## [Cut the sticks](https://www.hackerrank.com/challenges/cut-the-sticks/problem)


![Alt text](Cut_the_sticks.png?raw=true "Cut-the-sticks")

__Code__: Orange

**O(N)** time complexity using __Min Heap__ and __Counter__

```{Python}
from collections import Counter
from heapq import heapify, heappop, heappush
# Complete the cutTheSticks function below.
def cutTheSticks(arr):
    ans = list()
    # Heapify a min heap
    heap = []
    heapify(heap)  
# O(N) - Generate a hash table with distinct length of sticks as keys and their amounts as values  
    counter = Counter(arr)    
# O(N) - Add length of sticks to heap
    ans.append(len(arr))        
# O(1) - Initialize the list with len(arr)
    length = len(arr)
    # O(N) - Push keys elements of counter to min heap with the shortest value as root
    for i in list(counter.keys()):    
        heappush(heap, i)
    # O(N) - Loop through arr
    while length > 1:
    # O(1) - Get the root value of min heap which is the length of shortest sticks
        minimum = heap[0] 
# O(1) - Append the remain length after subtract all the shortest sticks   
        ans.append(length - counter.get(minimum))    
# O(1) - Update the new length of arr
        length = ans[-1]    
# O(1) - Delete the shortest length
        del(counter[minimum])    
# O(1) - Update the min heap
        heappop(heap)        
# O(1) - Check if there are more than 1 stick at the end that can be removed altogether, and make the list append 0 stick    
    if ans[-1] == 0:            
# O(1) - Remove 0
        ans.remove(0)            
    return ans
    # Total: 0(N+N+N+N) = 0(N) time complexity
```

**O(N<sup>2</sup>)** time complexity

```{Python}
def cutTheSticks(arr):
    ans = []
    while len(arr) >= 1:
        ans.append(len(arr))
        minimum = min(arr)
        arr = [i-minimum for i in arr if i != minimum]
    return ans
```
