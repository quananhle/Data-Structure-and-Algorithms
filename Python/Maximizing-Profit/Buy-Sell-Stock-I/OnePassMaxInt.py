class OnePass(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        min_price = sys.maxint
        max_profit = 0
        for i in range(len(prices)):
            if prices[i] < min_price:
                min_price = prices[i]
            elif (prices[i] - min_price > max_profit):
                max_profit = prices[i] - min_price
        return max_profit
