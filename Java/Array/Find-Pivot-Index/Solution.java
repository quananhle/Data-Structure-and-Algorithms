class Solution {
    public int pivotIndex(int[] nums) {
        //check if array nums is not empty
        if (nums.length > 0){
            int leftSum = 0;
            int rightSum = 0;
            //calculate the sum of all elements starting from index 1
            for (int i = 1; i < nums.length; ++i){
                //store in to rightSum
                rightSum += nums[i];
            }
            int i = 0;
            //loop through the entire array
            while (i < nums.length){
                if (leftSum == rightSum){
                    //return the position of pivot index
                    return i;
                }
                else{
                    //left sum iterate from index 0
                    leftSum += nums[i];
                }
                //if not the last index
                if (i < nums.length-1){
                    //deduct the element at index i+1 from rightSum
                    rightSum -= nums[i+1];
                }
                ++i;
            }
        }
        //if array nums is empty or no pivot index
        return -1;
    }
}
