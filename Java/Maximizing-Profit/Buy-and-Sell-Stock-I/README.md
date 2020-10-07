## Best Time to Buy and Sell Stock 1

**Code**: Green

Say you have an array for which the i<sup>th</sup> element is the price of a given stock on day i.

If you were only permitted to complete **at most one transaction** (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

```{Java}
    public int maxProfit(int[] prices) {
```

__Example 1__:
```
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
```

__Example 2__:
```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

### Approach 1: 

```OnePassSolution.java``` and ```OnePassPointerSolution.java```

![Alt text](pic/121_profit_graph.png?raw=true "Maximum Profit")

#### Complexity Analysis

    Time complexity : O(n). Only a single pass is needed.

    Space complexity : O(1). Only two variables are used.

### Approach 2: 

```BruteForce.java``` 

We need to find out the maximum difference (which will be the maximum profit) between two numbers in the given array. Also, the second number (selling price) must be larger than the first one (buying price).

In formal terms, we need to find ```max⁡(prices[j]−prices[i])```, for every ```i``` and ```j``` such that ```j>i```

#### Complexity Analysis

    Time complexity : O(n2). Loop runs n(n−1)/2 ​ times.

    Space complexity : O(1). Only two variables profit are used. 
