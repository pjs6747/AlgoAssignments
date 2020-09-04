import java.util.Scanner;

public class SizeDoubleS {
    public static void main(String[] args) {
        int n;
        int[] s;
        int[] output;
        int ENDOFOUTPUT = -1;
        Scanner sc = new Scanner(System.in);
        String[] input2;

        n = Integer.parseInt(sc.nextLine());
        input2 = sc.nextLine().split(" ");
        s = new int[n];
        output = new int[n*n];
        output[0] = ENDOFOUTPUT;

        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(input2[i]);
        }

        int outputIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = s[i] + s[j];
                boolean newNumber = true;
                for (int test : output) {
                    if (test == ENDOFOUTPUT) {
                        break;
                    }
                    else if (test == sum ) {
                        newNumber = false;
                        break;
                    }
                }
                if (newNumber) {
                    output[outputIndex] = sum;
                    output[outputIndex+1] = ENDOFOUTPUT;
                    outputIndex++;
                }
            }
        }
        System.out.println(outputIndex);
    }
}
