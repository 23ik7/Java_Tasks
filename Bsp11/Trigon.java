package Bsp11;

import java.util.ArrayList;

/** 
 * A polygon with three different points.
 */
public class Trigon extends Polygon {

    /** 
     * Constructs a trigon with a list of three points. 
     * 
     * If the polygon list contains more than three points, only uses the 
     * first three.  If the list contains less than three points, adds 
     * arbitrary points.
     *
     * @param points		the points
     *
     */
    public Trigon (ArrayList<Point> points) {
        super(points);
        repair(3);
    }


    /** 
     * Calculates the area of the trigon. 
     * 
     * @return		the area
     *
     */
    public double getArea() {
        double area = 0;

        double side1 = points.get(0).getDistance(points.get(1));
        double side2 = points.get(1).getDistance(points.get(2));
        double side3 = points.get(0).getDistance(points.get(2));

        double sp = (side1 + side2 + side3) / 2;

        area = Math.sqrt(sp * (sp - side1) * (sp - side2) * (sp - side3));


        return area;
    }
}
