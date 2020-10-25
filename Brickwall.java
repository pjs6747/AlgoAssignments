import java.util.Scanner;



public class Brickwall {

    private static int dp[][][];
    private static int bottomRowLen = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c1 = Integer.parseInt(input[1]);
        int c2 = Integer.parseInt(input[2]);
        int c3 = Integer.parseInt(input[3]);
        int[] bottomRow = new int[n];

        input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (i != 0)
                bottomRow[i] = Integer.parseInt(input[i]) + bottomRow[i-1];
            else
                bottomRow[i] = Integer.parseInt(input[i]);
        }
        bottomRowLen = bottomRow[n - 1];

        boolean test = placeBricks(n, c1, c2, c3, bottomRow, 0, 0);
        if (test)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean placeBricks(int n, int c1, int c2, int c3, int[] bottomRow, int currentRow, int i) {
        // base case for false layer
        if (currentRow > bottomRowLen) {
            return false;
        }

        // base case for true completed layer
        if (currentRow == bottomRowLen) {
            return true;
        }

        // results of placements
        boolean placeOne = false;
        boolean placeTwo = false;
        boolean placeThree = false;

        // place single
        if (c1 > 0) {
            if (bottomRow[i] > currentRow + 1)
                placeOne = placeBricks(n, c1 - 1, c2, c3, bottomRow, currentRow + 1, i);
        }

        // place double
        if (c2 > 0) {
            if (bottomRow[i] < currentRow + 2)
                placeTwo = placeBricks(n, c1, c2 - 1, c3, bottomRow, currentRow + 2, i + 1);
        }

        // place triple
        if (c3 > 0) {
            int skip = 0;

            // check if triple crosses one or two lines
            if (i < n - 1 && bottomRow[i + 1] < currentRow + 3)
                skip = 2;
            else if (bottomRow[i] < currentRow + 3)
                skip = 1;

            placeThree = placeBricks(n, c1, c2, c3 - 1, bottomRow, currentRow + 3, i + skip);
        }

        // if any return true pass true higher
        return placeOne || placeTwo || placeThree;
    }
}
