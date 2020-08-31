class Set {
    public int singleNumber(int[] nums) {
        //initialize a set
        Set<Integer> set = new HashSet();
        //for each int num in array nums
        for (int num : nums) {
            //check if set has not contained int num
            if(!set.contains(num)) {
                //add num to set
                set.add(num);
            }
            else {
                //otherwise, if num is already in the set, remove num from set
                set.remove(num);
            }
        }
        //return the first element in set
        return set.iterator().next();
    }
}
