import java.util.Arrays;

public class String {

    public static void main(String[] args) {
        System.out.println(sumOfNumbers(43018));
        System.out.println(sumOfNumbers(11111));
        System.out.println(sumOfNumbers(12345));
        System.out.println(sumOfNumbers(987654321));
    }
    public static String sumOfNumbers(int number) {
        String str = "";
        //split number into its digits and store them into an array of String
        String[] arrStr = Integer.toString(number).split("");
        //loop through the length of str to the last index;
        for (int i = 0; i < arrStr.length-1; i++) {
            //if integer value of element in array str at index i > 0
            if (Integer.valueOf(arrStr[i]) > 0) {
                //nested loop starting from i to the last index of str
                for (int j = i; j < arrStr.length-1; j++) {
                    //added '0' into string element at index i of str
                    arrStr[i] += '0';
                }
            }
        }
        //str string representation of array arrStr
        str = Arrays.toString(arrStr).replace(", 0","").replace(",", " +");
        return str.substring(1, str.length()-1);
    }
}
