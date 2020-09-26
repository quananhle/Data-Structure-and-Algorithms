class FancySolution {
    public int addDigits(int num) {
#       if (num == 0) {return 0;}
#       else if (num % 9 == 0) {return 9;}
#       else {return num % 9;}
      return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
