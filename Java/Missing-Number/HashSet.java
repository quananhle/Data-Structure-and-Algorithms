class HashSet {
    public int missingNumber(int[] nums) {
        //initialize a hash set that contains distinct elements from array nums
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        //if the array nums has n elements, there must be n + 1 missing element in total
        int expectedNumsCount = nums.length + 1;
        for (int n=0; n < expectedNumsCount; n++) {
            //if n is not in numSet
            if(!numSet.contains(n)) {
                return n
            }
        }
        //if no missing number found
        return -1;
    }
}
