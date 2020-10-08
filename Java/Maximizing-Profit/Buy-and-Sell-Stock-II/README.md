## Best Time to Buy and Sell Stock II

__Code__: Green

Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

```{JAVA}
public int maxProfit(int[] prices) {
```

__Example 1__:

```
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
```

__Example 2__:

```
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
```

__Example 3__:

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

### Approach: Peak Valley

```PeakValley.py```

__Algorithm__:

Say the given array is: ```[7, 1, 5, 3, 6, 4]```. If we plot the numbers of the given array on a graph, we get:

![Alt text](images/122_maxprofit_1.PNG?raw=true "Maximum Profit")

If we analyze the graph, we notice that the points of interest are the consecutive valleys and peaks.

Mathematically speaking: __TotalProfit__ = ∑<sub>i</sub>(height(peak<sub>i</sub>) − height(valley<sub>i</sub>)) 

The key point is we need to consider every peak immediately following a valley to maximize the profit. In case we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over one of the transactions leading to an overall lesser profit.

For example, in the above case, if we skip peak<sub>i</sub> and valley<sub>j</sub> trying to obtain more profit by considering points with more difference in heights, the net profit obtained will always be lesser than the one obtained by including them, since C will always be lesser than A+B.
![Alt text](images/122_maxprofit_1.PNG?raw=true "Maximum Profit")
