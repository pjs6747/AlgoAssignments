import java.util.Scanner;

public class DoubleKnapsackWithSolution {


    private static int dp[][][];

    public static void main (String[] args) {
        // important variables
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int w1 = Integer.parseInt(input[1]);
        int w2 = Integer.parseInt(input[2]);
        int[][] arr = new int[n][2];

//        Test variables
//        int n = 5;
//        int w1 = 10;
//        int w2 = 10;
//        int[][] arr = {{6, 1}, {5, 7}, {6, 9}, {8, 6}, {3, 3}};

        // array to store results
        dp = new int[n][w1][w2];

        // fill array with weight and cost
        for (int i = 0; i < n; i++) {
            input = sc.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        // fill dp with -1
        for (int i = 0; i < n ; i++)
            for (int j = 0; j < w1 ; j++)
                for (int k = 0; k < w2 ; k++)
                    dp[i][j][k] = -1;

        findMax(arr, n, w1, w2, 0);

        //find max from collected data
        int maxCost = 0;
        for (int i = 0; i < n ; i++)
            for (int j = 0; j < w1 ; j++)
                for (int k = 0; k < w2 ; k++) {
                    if (dp[i][j][k] > maxCost)
                        maxCost = dp[i][j][k];
                }
        System.out.println(maxCost);
    }

    private static int findMax(int[][] arr, int n, int w1_r, int w2_r, int i)
    {
        // base case
        if (i == n)
            return 0;

        // results of storage
        int fill_w1 = 0;
        int fill_w2 = 0;
        int fill_none = 0;

        // pack item into first sack
        if (w1_r >= arr[i][0])
            fill_w1 = arr[i][1] + findMax(arr, n, w1_r - (arr[i][0]), w2_r, i + 1);

        // pack item into second sack
        if (w2_r >= arr[i][0])
            fill_w2 = arr[i][1] + findMax(arr, n, w1_r, w2_r - arr[i][0], i + 1);

        // do not pack item
        fill_none = findMax(arr, n, w1_r, w2_r, i + 1);

        // add the maximum result to dp
        dp[i][w1_r - 1][w2_r - 1] = Math.max(fill_none, Math.max(fill_w1, fill_w2));
        return dp[i][w1_r - 1][w2_r - 1];
    }
}
