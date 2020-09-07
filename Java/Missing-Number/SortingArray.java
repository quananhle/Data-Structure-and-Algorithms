class SortingArray {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        //special case handler
        //if the missing number is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        //if 0 is missing
        else if (nums[0] != 0) {
            return 0;
        }
        //otherwise, the missing number is in range [0..n]
        else {
            for (int i=1; i<nums.length; i++) {
                //e.g.: index 0, value=1; index 1, value=2
                int missingNum = nums[i-1]+1;
                if (nums[i] != missingNum) {
                    return missingNum;
                }
            }
        }
        //no missing number found
        return -1;
    }
}
