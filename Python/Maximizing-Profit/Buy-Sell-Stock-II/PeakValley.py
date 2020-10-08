class PeakValley(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        current_idx  = 0
        next_idx     = current_idx + 1
        max_profit   = 0
        #loop until the last element of list prices
        while current_idx < len(prices)-1:
            #proof: if not at the last index and value of the current index is higher than the value of the next index
            if current_idx < len(prices)-1 and prices[current_idx] >= prices[next_idx]:
                #move from current index to the next
                current_idx += 1
            #store the value of current index as the floor/valley value
            valley_price = prices[current_idx]
            #proof: loop if not at the last index and value of the current index is lower than the value of the next index            
            if current_idx < len(prices)-1 and prices[current_idx] <= prices[next_idx]:
                #move from current index to the next                
                current_idx += 1
            #store the value of current index as the floor/valley value                
            peak_price = prices[current_idx]
            #calculate maximum profit by adding up the difference of peak value and valley value
            max_profit += peak_price - valley_price
        return max_profit
