class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        max_profit = 0
        for i in range(1, len(prices)):
            profit = prices[i] - prices[0]
            if max_profit < profit:
                max_profit = profit
            elif prices[i] < prices[0]:
                prices[0] = prices[i]
        return max_profit
