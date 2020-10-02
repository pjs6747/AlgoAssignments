import java.util.Scanner;

public class Donut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int[][] locations;

        // Create inputs
        n = Integer.parseInt(sc.nextLine());
        locations = new int[n][2];

        // Fill car locations
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            if (x > maxX) maxX = x;
            if (y > maxY) maxY = y;

            locations[i][0] = x;
            locations[i][1] = y;
        }

        // Find lowest total distance from all possible spots
        int lowestDistance = Integer.MAX_VALUE;
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                int totalDistance = 0;
                for (int i = 0; i < n; i++) {
                    int xCar = locations[i][0];
                    int yCar = locations[i][1];

                    totalDistance += Math.abs(xCar - x);
                    totalDistance += Math.abs((yCar - y));
                }
                if (totalDistance < lowestDistance) lowestDistance = totalDistance;
            }
        }

        // Print lowest distance
        System.out.println(lowestDistance);
    }
}
