class LoopSolution {
    public int addDigits(int num) {
        int output = 0;
        while (num > 0) {
            output += num % 10;
            num = num / 10;
            if (num == 0 && output > 9) {
                 num = output;
                 output = 0;
            }
        }
        return output;
    }
}
