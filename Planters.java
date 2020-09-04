import java.util.Scanner;

public class Planters {

    public static void main(String[] args) {
        int p;
        int r;
        int[] plants;
        int[] pots;
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        String[] input2 = sc.nextLine().split(" ");
        String[] input3 = sc.nextLine().split(" ");

        p = Integer.parseInt(input1[0]);
        r = Integer.parseInt(input1[1]);
       plants = new int[p];
       pots = new int[r];

       for (int i = 0; i < p; i++) {
           plants[i] = Integer.parseInt(input2[i]);
       }

        for (int i = 0; i < r; i++) {
            pots[i] = Integer.parseInt(input3[i]);
        }

        for (int i = 0; i < plants.length; i++) {
           int nextBiggestPot = -1;
           int nextBiggestPotIndex = -1;
           for (int j = 0; j < pots.length; j++) {
               int pot = pots[j];
               if (pot > nextBiggestPot && pot > plants[i]) {
                   nextBiggestPot = pot;
                   nextBiggestPotIndex = j;
               }
           }

           if (nextBiggestPot == -1) {
               System.out.println("NO");
               System.exit(0);
           }
           else {
               plants[i] = nextBiggestPotIndex;
           }
       }
       System.out.println("YES");
    }
}