Climbing the Leaderboard

https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

Orange

```{Python}
def climbingLeaderboard(ranked, player):
    # Write your code here
    ans =[]
    score_list = sorted(set(ranked), reverse=True)
    l = len(score_list)
    for s in player:
        while l > 0 and s >= score_list[l-1]:
            l -= 1
        ans.append(l+1)
    # print (*ans, sep='\n')    
    return ans
```
