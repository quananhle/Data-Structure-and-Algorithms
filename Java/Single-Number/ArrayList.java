class ArrayList {
    public int singleNumber(int[] nums) {
        //initialize an array list no_duplicate_list
        List<Integer> no_duplicate_list = new ArrayList<>();
        //for each int num in array nums
        for (int num : nums) {
            //check if no_duplicate_list already contained int num
            //if not
            if (!no_duplicate_list.contains(num)) {
                //add num to no_duplicate_list
                no_duplicate_list.add(num);
            } 
            else {
                //otherwise, remove from no_duplicate_list
                no_duplicate_list.remove(new Integer(num));
            }
        }
        //return the num at the first index in no_duplicate_list
        return no_duplicate_list.get(0);
    }
}
