import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Pavel
 */
public class Main {
    private static int count = 0;
    private static int countEveryStep = 0;

    public static void main(String[] args) throws InterruptedException {

        String point;
        String[] points;
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter first Knight point (like this: 1 5)  -> ");
            point = br.readLine();

            points = point.split(" ");
            x1 = Integer.parseInt(points[0]);
            y1 = Integer.parseInt(points[1]);

            System.out.print("Enter second Knight point (like this: 1 8) -> ");
            point = br.readLine();

            points = point.split(" ");
            x2 = Integer.parseInt(points[0]);
            y2 = Integer.parseInt(points[1]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        HashSet<Point> startPoint = new HashSet<>();
        startPoint.add(new Point(x1, y1));
        move(startPoint, new HashSet<>(), x2, y2);
    }

    static void move(HashSet<Point> set, HashSet<Point> grandSet, int x2, int y2) throws InterruptedException {
        count++;

        HashSet<Point> childSet = new HashSet<>();

        for (Point point : set) {

            int x = point.x;
            int y = point.y;

            ArrayList<Point> list = new ArrayList<>();

            list.add(new Point(x + 1, y + 2));
            list.add(new Point(x + 1, y - 2));
            list.add(new Point(x - 1, y + 2));
            list.add(new Point(x - 1, y - 2));
            list.add(new Point(x + 2, y + 1));
            list.add(new Point(x + 2, y - 1));
            list.add(new Point(x - 2, y + 1));
            list.add(new Point(x - 2, y - 1));

            list.removeIf(p -> (p.x < 1 || p.x > 8) || (p.y < 1 || p.y > 8));

//            System.out.println("step " + count);
//            for (Point obj : list) {
//                System.out.printf("%d,%d -> %d,%d%n", x, y, obj.x, obj.y);
//            }
//            System.out.println("countEveryStep = " + ++countEveryStep);

            for (Point p : list) {
                if (p.x == x2 && p.y == y2) {
                    System.out.printf("%s %d steps%n", "Eureka!!!", count);
                    System.exit(1);
                }
            }
            childSet.addAll(list);
        }

//        System.out.println(childSet.removeAll(grandSet));
//        System.out.println();
//        for (Point p : childSet)
//            System.out.println(p);
//        System.out.println();
//        for (Point p : grandSet)
//            System.out.println(p);
//        System.out.println();

        move(childSet, set, x2, y2);
    }
}

