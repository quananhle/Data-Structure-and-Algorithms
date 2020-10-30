class BruteForce {
    public boolean checkPerfectNumber(int num) {
        //smallest positive perfect number is 6
        if (num <= 5){
            return false;
        }
        int sum = 0;
        for (int i=1; i <= num/2; ++i){
            //if i is the positive divisor of num
            if (0 == num % i){
                //add it up to sum
                sum += i;
            }
            if (sum > num){
                //break out of the loop early if sum is already larger than num
                return false;
            }
        }
        return sum == num;
    }
}
