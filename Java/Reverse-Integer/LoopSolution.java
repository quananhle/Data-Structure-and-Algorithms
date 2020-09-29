public class LoopSolution{
    public static int reverse_integer(int num){
        //flag for negative input
        boolean negative = false;
        //if input is negative
        if (num<0){
            //remember
            negative = true;
            //change negative value to positive value
            num = (num*(-1));
        }
        int prevNum = 0;
        int newNum = 0;
        while (num != 0){
            //remainder
            int currentDigit = num%10;
            newNum = newNum*10 + currentDigit;
            //to handle overflow
            if((newNum-currentDigit)/10 != prevNum){
                System.out.format("Overflow, return %d instead!%n", 0);
                // throw new IllegalStateException("Overflow, return 0 instead!");
                return 0;
            }
            prevNum = newNum;
            num = num/10;
        }
        //if num is not negative return newNum, otherwise return -newNum
        return (negative==false) ? newNum : -newNum;
    }
    public static void main(String []args){
        System.out.println(reverse_integer(531));
        //leading zero output
        System.out.println(reverse_integer(100));
        //negative number
        System.out.println(reverse_integer(-321));
        //overflow
        System.out.println(reverse_integer(1000000045));
    }
}
