class PeakValley(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        current_idx  = 0
        valley_price = 0
        peak_price   = 0
        max_profit   = 0
        #loop until the last element of list prices
        while current_idx < len(prices)-1:
            #loop if not 
            while current_idx < len(prices)-1 and prices[current_idx] >= prices[current_idx+1]:
                current_idx += 1
            valley_prices = prices[current_idx]
            while current_idx < len(prices)-1 and prices[current_idx] <= prices[current_idx+1]:
                current_idx += 1
            peak_prices = prices[current_idx]
            max_profit += peak_prices - valley_prices
        return max_profit
