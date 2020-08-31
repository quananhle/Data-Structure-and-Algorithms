class Array {
    public int singleNumber(int[] nums) {
        //sort the array nums
        Arrays.sort(nums);
        //loop each two indices through the array
        for(int i=0; i < nums.length; i=i+2) {
            //check if the next index is still in the array
            if(i+1 < nums.length) {
                //check if element at index i is not the same as the element next to it
                if(nums[i] != nums[i+1]){
                    //return element at index i
                    return nums[i];
                }
            }
            //otherwise, once reached the end of the array
            else {
                //return element at index i
                return nums[i];
            }
        }
        //given a non-empty array of integers, if there is only 1 integer in the array
        return nums[0];
    }
}
