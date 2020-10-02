class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        buying_price = prices[0]
        max_profit = 0
        for i in range(1, len(prices)):
            profit = prices[i] - buying_price
            if max_profit < profit:
                max_profit = profit
            elif prices[i] < buying_price:
                buying_price = prices[i]
        return max_profit
