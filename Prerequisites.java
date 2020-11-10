import java.util.ArrayList;
import java.util.Scanner;

class Course {
    int name;
    ArrayList<Course> prereqs = new ArrayList();

    public Course(int name) {
        this.name = name;
    }

    public void addPrereq(Course course) {
        this.prereqs.add(course);
    }
}

public class Prerequisites {
    private static int max = 0;
    public static void main(String[] srgs) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Course[] courses = new Course[n+1];

        for (int i = 1; i < n + 1; i++) {
            courses[i] = new Course(i);
        }

        for (int i = 1; i < n + 1; i++) {
            String[] input = sc.nextLine().split(" ");
            for (String s : input){
                if (s.equals("0")) {
                    break;
                }
                courses[i].addPrereq(courses[Integer.parseInt(s)]);
            }
        }
        for (int i = 1; i < n + 1; i++) {
            Course c =courses[i];
            traceBack(c, 0);

        }
        System.out.println(max);
    }

    private static void traceBack(Course c, int total) {
        if (c.prereqs.size() == 0){
            if (total > max) {
                max = total;
            }
            return;
        }

        for (Course pre : c.prereqs) {
            traceBack(pre, total += 1);
        }
    }



}
