import java.util.Scanner;

public class LongestIncreasingSubseqDP {

    static int lis(int A[],int n)
    {
        int lis[] = new int[n];
        int i,j,max = 0;

        // Initialize lis values
        for ( i = 0; i < n; i++ )
            lis[i] = 1;

       // Find best lis values
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( A[i] > A[j] &&
                        lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        // Pick max
        for ( i = 0; i < n; i++ )
            if ( max < lis[i] )
                max = lis[i];

        return max;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int A[] = new int[n];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        System.out.println(lis( A, n ));
    }
}
