import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SmallestTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int next =  Integer.parseInt(sc.nextLine());
            if (next != lowest && next != secondLowest) {
                if (next < secondLowest) {
                    if (next < lowest) {
                        secondLowest = lowest;
                        lowest = next;
                    } else {
                        secondLowest = next;
                    }
                }
            }
        }

        System.out.println(lowest);
        System.out.println(secondLowest);
    }
}
