class OnePassPointer {
    public int maxProfit(int[] prices) {
        //special case handler
        if (prices.length < 2){
            return 0;
        }
        int buyingPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i){
            int profit = prices[i] - buyingPrice;
            if (maxProfit < profit){
                maxProfit = profit;
            }
            else if (prices[i] < buyingPrice){
                buyingPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
