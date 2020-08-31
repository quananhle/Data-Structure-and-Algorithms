class Math {
    public int singleNumber(int[] nums) {
        int sumOfSet = 0, sumOfNums = 0;
        //initialize a set
        Set<Integer> set = new HashSet();
        //for each int num in array nums
        for (int num : nums) {
            //check if set has not contained int num
            if(!set.contains(num)) {
                //add num to set
                set.add(num);
                //calculate sum of all num in set
                sumOfSet += num;
            }
            //calculate sum of all num in array nums
            sumOfNums += num;
        }
        //sumOfNums = sumOfSet * 2 + the single element 
        return 2 * sumOfSet - sumOfNums;
    }
}
