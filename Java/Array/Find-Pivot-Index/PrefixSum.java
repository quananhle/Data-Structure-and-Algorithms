class PrefixSum {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        //for each element in array nums
        for (int x : nums){
            //calculate the sum of all elements
            rightSum += x;
        }
        //loop through the end of the array
        for (int i = 0; i < nums.length; ++i){
            if (leftSum == rightSum - leftSum - nums[i]){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
