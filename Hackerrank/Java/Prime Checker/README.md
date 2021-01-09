## [Prime Checker](https://www.hackerrank.com/challenges/prime-checker/problem)


__Code:__ Orange



```{Java}
import static java.lang.System.in;
class Prime {
    void checkPrime(int... numbers) {
        for (int number : numbers) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
    private boolean isPrime(int number){
        if (number < 2 || (number % 2 == 0 && number != 2)){
            return false;
        }
        else if (number == 2){
            return true;
        }
        else {
            for (int i=2; i <= (number/2); ++i){
                if (number % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
```
##### Explain: Iterate from 2 to number / 2, if number is divisible by any number between 2 and number / 2, then it is not prime
