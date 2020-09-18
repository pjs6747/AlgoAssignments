import java.util.Scanner;

public class WeightedByProductInversions {
    public static void main(String[] args) {
        Scanner sc;
        int n;
        int[] input;
        long weight;

        //initialize variables
        sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        input = new int[n];
        weight = 0;
        int counter = 0;
        for (String string : sc.nextLine().split(" ")) {
            input[counter] = Integer.parseInt(string);
            counter++;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (input[i] > input[j]) {
                    weight += input[i]*input[j];
                }
            }
        }
        System.out.println(weight);
    }
}
