public class solutions {

    // 1. Fibonacci sequence - first 10 numbers and their sum
    public static void fibonacciFirst10() {
        int n = 10;
        int first = 0, second = 1, next, sum = first + second;
        System.out.print("Fibonacci sequence (first 10 numbers): ");
        System.out.print(first + " " + second + " ");
        
        for (int i = 3; i <= n; i++) {
            next = first + second;
            System.out.print(next + " ");
            sum += next;
            first = second;
            second = next;
        }
        System.out.println("\nSum of first 10 Fibonacci numbers: " + sum);
    }

    // 2. Prime numbers from 1 to 1000
    public static void printPrimes() {
        System.out.println("\nPrime numbers between 1 and 1000:");
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Helper function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // 3. Fibonacci sequence with first 8 prime numbers
    public static void fibonacciWithPrimes() {
        System.out.println("\nFibonacci sequence with first 8 primes:");
        int count = 0, num = 2;
        int first = 0, second = 1;
        System.out.print("Prime numbers: ");
        while (count < 8) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
        
        System.out.println("\nFibonacci sequence (first 8 primes in place): ");
        count = 0;
        while (count < 8) {
            int next = first + second;
            if (isPrime(next)) {
                System.out.print(next + " ");
                count++;
            }
            first = second;
            second = next;
        }
        System.out.println();
    }

    // 4. Sequence: 0, 2, 1, 4, 1, 8, 2, 16, 3, 32...
    public static void sequence1(int limit) {
        System.out.println("\nSequence up to limit " + limit + ":");
        for (int i = 0, j = 0; j <= limit; i++, j = (int) Math.pow(2, i)) {
            System.out.print(i + "," + j + " ");
        }
        System.out.println();
    }

    // 5. Sequence: 0, -1, 1, -4, 1, -7, 2, -10, 3, -13...
    public static void sequence2(int limit) {
        System.out.println("\nSequence up to limit " + limit + ":");
        for (int i = 0, j = 0; i <= limit; i++) {
            if (i % 2 == 0) {
                System.out.print(i + "," + (j) + " ");
            } else {
                System.out.print(i + "," + (j += i) + " ");
            }
        }
        System.out.println();
    }

    // 6. Factorial of a number
    public static long factorial(int num) {
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println("\nFactorial of " + num + " is: " + fact);
        return fact;
    }

    // 7. Sequence: 2, 1, 4, 2, 6, 6, 8, 24, 10, ...
    public static void sequence3(int limit) {
        System.out.println("\nSequence up to limit " + limit + ":");
        int fact = 1;
        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 0) {
                fact *= i;
                System.out.print(i + "," + fact + " ");
            } else {
                System.out.print(i + "," + fact + " ");
            }
        }
        System.out.println();
    }

    // 8. Find GCD of two numbers
    public static void findGCD(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        System.out.println("\nGCD of " + a + " and " + b + " is: " + gcd);
    }

    // 9. Sum of series: 1/1! + 1/2! + 1/3!...
    public static void sumOfSeries(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / factorial(i);
        }
        System.out.println("\nSum of series 1/1! + 1/2! + ... : " + sum);
    }

    // 10. Display alphabets from A to Z
    public static void displayAlphabets() {
        System.out.println("\nAlphabets A to Z:");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // 11. Power of a number
    public static void power(int base, int exponent) {
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        System.out.println("\n" + base + " raised to the power of " + exponent + " is: " + result);
    }

    // 12. Display factors of a number
    public static void factors(int num) {
        System.out.println("\nFactors of " + num + ":");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // 13. Check if a number can be expressed as sum of two primes
    public static void checkSumOfTwoPrimes(int num) {
        boolean canBeSum = false;
        for (int i = 2; i <= num / 2; i++) {
            if (isPrime(i) && isPrime(num - i)) {
                canBeSum = true;
                break;
            }
        }
        System.out.println("\nCan " + num + " be expressed as sum of two primes? " + (canBeSum ? "Yes" : "No"));
    }

    // 14. Check if a number is palindrome
    public static void palindrome(int num) {
        int original = num, reverse = 0;
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        System.out.println("\nIs the number " + original + " a palindrome? " + (original == reverse ? "Yes" : "No"));
    }

    // 15. Generate 5 random numbers between 1 and 100
    public static void generateRandomNumbers() {
        System.out.println("\n5 Random numbers between 1 and 100:");
        for (int i = 0; i < 5; i++) {
            System.out.print((int) (Math.random() * 100 + 1) + " ");
        }
        System.out.println();
    }

    // 16. Sum of all integers greater than 100 and less than 200 divisible by 7
    public static void sumDivisibleBy7() {
        int sum = 0;
        for (int i = 101; i < 200; i++) {
            if (i % 7 == 0) {
                sum += i;
            }
        }
        System.out.println("\nSum of all integers greater than 100 and less than 200 divisible by 7 is: " + sum);
    }

    public static void main(String[] args) {
        fibonacciFirst10();
        printPrimes();
        fibonacciWithPrimes();
        sequence1(20);
        sequence2(20);
        factorial(5);
        sequence3(10);
        findGCD(36, 60);
        sumOfSeries(5);
        displayAlphabets();
        power(2, 3);
        factors(28);
        checkSumOfTwoPrimes(10);
        palindrome(121);
        generateRandomNumbers();
        sumDivisibleBy7();
    }
}
