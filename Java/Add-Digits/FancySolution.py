class FancySolution {
    public int addDigits(int num) {
      if (num == 0) {return 0;}
      elif (num % 9 == 0) {return 9;}
      else {return num % 9}
}
