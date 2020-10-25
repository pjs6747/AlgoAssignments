import java.util.Scanner;

public class LongestKindOfIncrSubseq {
    public static void main(String[] args) {
        // get input values
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        int[] optList = new int[n];
        String[] aInput = sc.nextLine().split(" ");
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aInput[i]);
        }

        for(int i = 2; i < n; i++) {
            for(int j = 1; j < i; j++) {
                for(int k = 0; k < j; k++) {
                    int current = a[i];
                    int iVal = a[i];
                    int jVal = a[j];
                    int kVal = a[k];
                    int average = (a[j] + a[k])/2;

                    if (current > average) {
                        if (optList[i] < optList[j] + 1 || optList[k] < optList[j] + 1) {
                            optList[j] = optList[k] + 1;
                            optList[i] = optList[j] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(optList);
    }
}
