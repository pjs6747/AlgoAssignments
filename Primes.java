import java.util.Scanner;

public class Primes {
    private static boolean isPrime(int test) {
        if ( test <= 1) {
            return false;
        }

        for (int i = 2; i < test; i++) {
            if (test % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void printPrimes(int num) {
        for (int test = 2; test <= num; test++) {
            if (isPrime(test)) {
                System.out.println(test);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        if (num < 10000) {
            printPrimes(num);
        }
    }
}
