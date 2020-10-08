class PeakValley(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        i = 0
        valley_price = 0
        peak_price   = 0
        max_profit   = 0
        while i < len(prices)-1:
            while i < len(prices)-1 and prices[i] >= prices[i+1]:
                i += 1
            valley_prices = prices[i]
            while i < len(prices)-1 and prices[i] <= prices[i+1]:
                i += 1
            peak_prices = prices[i]
            max_profit += peak_prices - valley_prices
        return max_profit
