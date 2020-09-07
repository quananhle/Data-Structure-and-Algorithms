class Math {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (int)(n * (n + 1 ))/2;
        for(int i = 0;i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
