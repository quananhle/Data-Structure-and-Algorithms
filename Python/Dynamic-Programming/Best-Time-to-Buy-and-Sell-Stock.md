## [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
        
Level: Green

---

You are given an array ```prices``` where ```prices[i]``` is the price of a given stock on the i<sup>th</sup> day.

You want to maximize your profit by choosing a __single day__ to buy one stock and choosing ___a different day___ in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return ```0```.

**Example 1:**
```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

**Example 2:**
```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.       
```       

**Constraints:**

1 <= ```prices.length``` <= 105
       
0 <= ```prices[i]``` <= 104

```{python}
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        min_price = sys.maxint
        max_profit = 0
        for i in range(len(prices)):
            if min_price > prices[i]:
                min_price = prices[i]
            elif (prices[i] - min_price > max_profit):
                max_profit = prices[i] - min_price
        return max_profit
```
