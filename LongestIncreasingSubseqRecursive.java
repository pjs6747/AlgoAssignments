import java.util.Scanner;

public class LongestIncreasingSubseqRecursive {
    static int max;

    private static int _lis(int A[], int n)
    {
        if (n == 1)
            return 1;

        int res, maxEnding = 1;

        for (int i = 1; i < n; i++)
        {
            res = _lis(A, i);
            if (A[i-1] < A[n-1] && res + 1 > maxEnding)
                maxEnding = res + 1;
        }

        if (max < maxEnding)
            max = maxEnding;

        return maxEnding;
    }

    private static int lis(int A[], int n)
    {
        max = 1;
        _lis( A, n);
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

        System.out.println(lis(A, n));
    }
}
