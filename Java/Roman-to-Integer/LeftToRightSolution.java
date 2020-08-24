class LeftToRightSolution {
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
        int total = 0;
        //pointer
        int i = 0;
        //go through the length of the String str
        while (i < str.length()) {
            //return substring of str from i to i+1 to get the current symbol
            String currentSymbol = str.substring(i, i+1);
            //map the key currentSymbol to get its value
            int currentValue = values.get(currentSymbol);
            int nextValue = 0;
            //if not the last symbol
            if (i+1 < str.length()) {
                //returning the substring of str from i+1 to i+2 to get the next symbol
                String nextSymbol = str.substring(i+1, i+2);
                //map the key nextSymbol to get its value
                nextValue = values.get(nextSymbol);
            }
            //compare the value of the currentSymbol and the value of the nextSymbol
            //if the value of the nextSymbol is bigger than the value of the currentSymbol standing before it
            if (currentValue < nextValue) {
                //deduct the value of currentSymbol
                total += (nextValue - currentValue);
                //move to the symbol after the nextSymbol
                i += 2;
            }
            //otherwise, add to the value of total
            else {
                total += currentValue;
                i += 1;    
            }
        }
        return total;
    }
}
