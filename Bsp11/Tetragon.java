package Bsp11;

import java.util.ArrayList;

/** 
 * A polygon with four different points.
 */
public class Tetragon extends Polygon {

    /** 
     * Constructs a tetragon with a list of four points. 
     * 
     * If the polygon list contains more than four points, only uses the 
     * first four. If the list contains less than four points, adds arbitrary 
     * points.
     *
     * @param points		the points
     *
     */
    public Tetragon (ArrayList<Point> points) {
        super(points);
        repair(4);
    }

    /** 
     * Calculates the area of the tetragon.
     *
     * @return		the area
     */
    public double getArea() {
        double area = 0;

        ArrayList<Point> first = new ArrayList<>();
        first.add(points.get(0));
        first.add(points.get(1));
        first.add(points.get(3));

        ArrayList<Point> second = new ArrayList<>();
        second.add(points.get(1));
        second.add(points.get(2));
        second.add(points.get(3));

        Trigon tg1 = new Trigon(first);
        Trigon tg2 = new Trigon(second);

        area = tg1.getArea() + tg2.getArea();
        return area;
    }


    /** 
     * Checks, if tetragon is a rectangle.
     * 
     * @return	true, if rectangle
     *
     */
    public boolean isRectangle() {
        double d1 = points.get(0).getDistance(points.get(2));
        double d2 = points.get(1).getDistance(points.get(3));

        if (d1 == d2) {
            return true;
        }
        else {
            return false;
        }
    }
}
