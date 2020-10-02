class BruteForce(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        max_profit = 0
        for i in range (len(prices)-1):
            for j in range(i+1, len(prices)):
                profit = prices[j] - prices[i]
                if(profit > max_profit):
                    max_profit = profit
        return max_profit
