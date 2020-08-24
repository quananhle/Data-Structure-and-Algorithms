class RightToLeftSolution {
    static Map<String, Integer> values = new HashMap<>();
    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
    }
    public int romanToInt(String str) {
        //get the last symbol of str
        String currentSymbol = str.substring(str.length() - 1);
        //get its value
        int currentValue = values.get(currentSymbol);
        int total = currentValue;
        //loop starting from the symbol next to last
        for (int i = str.length() - 2; i >= 0; i--) {
            //get the symbol
            String previousSymbol = str.substring(i, i+1);
            //get its value
            int previousValue = values.get(previousSymbol);
            //compare the values; if previousValue smaller than currentValue, deduct previousValue from total
            if (previousValue < currentValue) {
                total -= previousValue;
            }
            //otherwise, add up
            else {
                total += previousValue;
            }
            //update previousValue to the currentValue
            currentValue = previousValue;
        }
        return total;
    }
}
