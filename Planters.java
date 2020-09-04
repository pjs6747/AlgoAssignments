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
       quickSort(plants, 0, plants.length - 1);

        for (int i = 0; i < r; i++) {
            pots[i] = Integer.parseInt(input3[i]);
        }
        quickSort(pots, 0, pots.length - 1);

        for (int i = 0; i < plants.length; i++) {
           boolean failed = true;
           for (int j = 0; j < pots.length; j++) {
               if (pots[j] > plants[i]) {
                   pots[j] = plants[i];
                   failed = false;
                   break;
               }
           }
           if (failed) {
               System.out.println("NO");
               System.exit(0);
           }
       }
       System.out.println("YES");
    }

    private static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] < pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    private static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
}