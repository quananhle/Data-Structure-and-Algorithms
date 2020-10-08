class PeakValley {
    public int maxProfit(int[] prices) {
        int i = 0;
        int floorPrice = prices[0];
        int ceiliPrice = prices[0];
        int maxProfit = 0;
        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] >= prices[i+1]){
                i++;
            }
            floorPrice = prices[i]; 
            while(i < prices.length - 1 && prices[i] <= prices[i+1]){
                i++;
            }
            ceiliPrice = prices[i];
            maxProfit += ceiliPrice - floorPrice;
        }
        return maxProfit;
    }
}
