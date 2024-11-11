package Bsp11;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(-5, 0);
        Point b = new Point(0, 2);
        Point c = new Point(5, 0);
        Point d = new Point(0, -2);
        System.out.println(a.getDistance(b));
        System.out.println(b.getDistance(c));
        System.out.println(c.getDistance(d));
        System.out.println(d.getDistance(a));

    }
}
