## [Minimum Swaps 2](
https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&h_r%5B%5D%5B%5D=next-challenge&h_r%5B%5D%5B%5D=next-challenge&h_v%5B%5D%5B%5D=zen&h_v%5B%5D%5B%5D=zen&playlist_slugs%5B%5D%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D%5B%5D=arrays)



__Code__: Orange

```{Python}
def minimumSwaps(arr):
    sorted_arr = sorted(arr)
    index_dict = {key:value for value,key in enumerate(arr)}
    swaps = 0
    for i,v in enumerate(arr):
        correct_value = sorted_arr[i]
        if v != correct_value:
            to_swap_ix = index_dict[correct_value]
            arr[to_swap_ix],arr[k] = arr[i], arr[to_swap_ix]
            index_dict[v] = to_swap_ix
            index_dict[correct_value] = i
            swaps += 1
    return swaps
```
