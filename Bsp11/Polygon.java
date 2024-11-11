package Bsp11;

import java.util.ArrayList;

/** 
 * A polygon with a list of different polygon points. 
 * 
 * The edges of the polygon are the lines connecting the points starting at 
 * the first point in the list. Each point is connected to the next point in 
 * the list. The last point is connected to the first point.
 *
 */
abstract public class Polygon {
    protected final ArrayList<Point> points;

    public Polygon (ArrayList<Point> points) {
        this.points = points;
        //int ind = 1;
        for (int i = 0; i < points.size(); i++) {
            for(int j = i + 1; j < points.size(); j++) {
                if (points.get(i).equals(points.get(j))) {
                    points.remove(j);
                    //points.remove(ind);
                    //ind++;
                }
            }
            
        }
    }


    /** Returns the points of the polygon.
     *
     * @return		the points
     *
     */
    public ArrayList<Point> getPoints() {
        return points;
    }


    /** Checks if the other polygon is equal to this polygon.
     *
     * @param other		another polygon
     *
     * @return		true, if equal
     *
     */
    public boolean equals(Object other) {
        Polygon newPol = (Polygon) other;
        if (points.size() != newPol.getPoints().size()) {
            return false;
        }
        else {
            for (int i = 0; i < points.size(); i++) {
                if(!points.get(i).equals(newPol.getPoints().get(i))) {
                    return false;
                }
            }

            return true;
        }
    }


    /** Calculates the circumference of the polygon.
     *
     * @return		the length
     *
     */
    public double getCircumference() {
        double cir = 0;
        
        for (int i = 0; i < points.size() - 1; i++) {
            cir = cir + points.get(i).getDistance(points.get(i + 1));
        }
        return cir + points.get(0).getDistance(points.get(points.size() - 1));
    }


    /** Calculates the area of the polygon.
     *
     * @return		the length
     *
     */
    abstract public double getArea();


    /** Ensures that there are exactly `count` polygon points.
     *
     * @param count	the correct number of points
     *
     */
    protected void repair(int count) {
        int diff = 0;
            if (count > points.size()) {
                diff = count - points.size();
                for (int i = 0; i < diff; i++) {
                    Point nP = new Point(i, i);
                    points.add(nP);
                }
            }

            else if (count < points.size()) {
                diff = points.size() - count;
                for (int j = 0; j < diff; j++) {
                    points.remove(points.size() - 1);
                }
            }
        
    }


    /** Eliminates identical points from the polygon list.
     *
     * @param a			a vector
     * @param b			a vector
     *
     */
    protected void clean() {
        
    }

    /** Returns the string representation of this polygon.
     *
     * @return		the polygon string
     *
     */
    public String toString() {
        String res = "";
        for (int i = 0; i < points.size(); i++) {
            if (i != points.size() - 1) {
                res += ((Point) points.get(i)).toString() + ", ";
            }
            else {
                res += ((Point) points.get(i)).toString();
            }
             
        }
        return "[" + res + "]";
    }
    
    // Ignore this. It’s only here for the tests to work properly.
    protected Polygon() { points = null; }
}
