import java.util.Scanner;

public class DoubleTrouble {
    static int minMove = Integer.MAX_VALUE;
    static int a;
    static int b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        String[][] maze = new String[a][b];

        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for (int i = 0; i < a; i++) {
            input = sc.nextLine().split("");
            for (int j = 0; j < b; j++) {
                String ch = input[j];
                if (ch.equals("1")) {
                    x1 = j;
                    y1 = i;
                } else if (ch.equals("2")) {
                    x2 = j;
                    y2 = i;
                }
                maze[i][j] = ch;
            }
        }
        int count = 1;
        makeMove(maze, x1, y1, x2, y2, count);

        if (minMove == Integer.MAX_VALUE) {
            System.out.println("STUCK");
        }
        else{
            System.out.println(minMove);
        }
    }

    public static void makeMove(String[][] maze, int x1, int y1, int x2, int y2, int count) {
        if (count > 50) {
            return;
        }
        // both left maze
        if ((x1 == 0 && x2 == 0) || (x1 == b - 1 && x2 == b - 1) || (y1 == 0 && y2 == 0) || (y1 == a - 1 && y2 == a - 1)) {
            if (count < minMove) {
                minMove = count;
            }
            return;
        } else if (x1 < 0 || x2 < 0 || x1 > b || x2 > b || y1 < 0 || y2 < 0 || y1 > a || y2 > a) {
            return;
        }

        // MOVE LEFT
        if (x1 > 0 && x2 > 0) {
            String[][] newMaze = deepCopyArray(maze);

            int newx1 = x1;
            if (!newMaze[y1][x1 - 1].equals("x")) {
                newx1 = x1 - 1;
                newMaze[y1][newx1] = "1";
                newMaze[y1][x1] = ".";
            }

            int newx2 = x2;
            if (newMaze[y2][x2 - 1].equals(".")) {
                newx2 = x2 - 1;
                newMaze[y2][newx2] = "2";
                newMaze[y2][x2] = ".";
            }
            if (x1 != newx1 || x2 != newx2) {
                makeMove(newMaze, newx1, y1, newx2, y2, count + 1);
            }
        }

        // MOVE RIGHT
        if (x1 < b - 1 && x2 < b - 1) {
            String[][] newMaze = deepCopyArray(maze);

            int newx1 = x1;
            if (!newMaze[y1][x1 + 1].equals("x")) {
                newx1 = x1 + 1;
                newMaze[y1][newx1] = "1";
                newMaze[y1][x1] = ".";
            }

            int newx2 = x2;
            if (newMaze[y2][x2 + 1].equals(".")) {
                newx2 = x2 + 1;
                newMaze[y2][newx2] = "2";
                newMaze[y2][x2] = ".";
            }
            if (x1 != newx1 || x2 != newx2) {
                makeMove(newMaze, newx1, y1, newx2, y2, count + 1);
            }
        }

        // MOVE UP
        if (y1 > 0 && y2 > 0) {
            String[][] newMaze = deepCopyArray(maze);

            int newy1 = y1;
            if (!newMaze[y1 - 1][x1].equals("x")) {
                newy1 = y1 - 1;
                newMaze[newy1][x1] = "1";
                newMaze[y1][x1] = ".";
            }

            int newy2 = y2;
            if (newMaze[y2 - 1][x2].equals(".")) {
                newy2 = y2 - 1;
                newMaze[newy2][x2] = "2";
                newMaze[y2][x2] = ".";
            }
            if (y1 != newy1 || y2 != newy2) {
                makeMove(newMaze, x1, newy1, x2, newy2, count + 1);
            }
        }

        // MOVE DOWN
        if (y1 < a - 1 && y2 < a - 1) {
            String[][] newMaze = deepCopyArray(maze);

            int newy1 = y1;
            if (!newMaze[y1 + 1][x1].equals("x")) {
                newy1 = y1 + 1;
                newMaze[newy1][x1] = "1";
                newMaze[y1][x1] = ".";
            }

            int newy2 = y2;
            if (newMaze[y2 + 1][x2].equals(".")) {
                newy2 = y2 + 1;
                newMaze[newy2][x2] = "2";
                newMaze[y2][x2] = ".";
            }
            // make sure one moved
            if (y1 != newy1 || y2 != newy2) {
                makeMove(newMaze, x1, newy1, x2, newy2, count + 1);
            }
        }
    }

    private static String[][] deepCopyArray(String[][] arr) {
        String[][] ret = new String[arr.length][];
        for(int i = 0; i < arr.length; i++)
            ret[i] = arr[i].clone();
        return ret;
    }
}
