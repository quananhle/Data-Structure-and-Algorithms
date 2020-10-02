class FastSolution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        buying_price_loc = 0
        profit = 0
        for i, selling_price in enumerate(prices[1:], start=1):
            profit = max(profit, selling_price - prices[buying_price_loc])
            if selling_price - prices[buying_price_loc] < 0:
                buying_price_loc = i			
        return profit
