class SquareRootInput {
    public boolean checkPerfectNumber(int num) {
        if (num <= 5){
            return false;
        }
        int sum = 0;
        for (int i=1; i*i <= num; ++i){
            if (0 == num % i){
                sum += i;
                if (i*i < num) {
                    sum += num / i;
                }
            }
        }
        return sum - num == num;
    }
}
