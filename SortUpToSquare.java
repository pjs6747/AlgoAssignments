import java.util.Scanner;

public class SortUpToSquare {
    public static void main(String[] args) {
        //Count Sort
        Scanner sc;
        int n;
        int maxInt;
        int[] input;
        int[] output;
        int[] count;

        //Initialize variables
        sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        maxInt = n*n;
        input = new int[n];
        int counter = 0;
        for (String string : sc.nextLine().split(" ")) {
            input[counter] = Integer.parseInt(string);
            counter++;
        }
        output = new int[n];
        count = new int[maxInt];

        //Populate count with 0s
        for (int i = 0; i < maxInt; i++) {
            count[i] = 0;
        }

        //Populate count with number of occurrences of each int
        for (int i = 0; i < n; i++) {
            ++count[input[i]];
        }

        //Sum previous indexes
        for (int i = 1; i < maxInt; i++) {
            count[i] += count[i-1];
        }

        //Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[input[i]] - 1] = input[i];
            --count[input[i]];
        }

        //Print output
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (output[i] % 3 == 0) {
                total += i+1;
            }
        }
        System.out.println(total);
    }


}
