package Bsp11;


/** 
 * A 2D Point with integer coordinates.
 */
public class Point {
    int x;
    int y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }


    /** Returns the x-coordinate.
     *
     * @return		the x-coordinate
     *
     */
    public int getX() {
        return x; 
    }


    /** Returns the y-coordinate.
     *
     * @return		the y-coordinate
     *
     */
    public int getY() {
        return y;
    }


    /** Indicates if coordinates of other are equal to this.
     *
     * @return		true, if equal
     *
     */
    public boolean equals(Object other) {
        Point newP = (Point) other;
        if (getX() == newP.getX() && getY() == newP.getY()) {
            return true;
        }
        else {
            return false;
        } 
    }


    /** Returns the Euclidean distance of this to other.
     *
     * @param other		another point
     *
     * @return				the distance
     *
     */
    public double getDistance(Point other) {

        double x1 = getX();
        double y1 = getY();

        double x2 = other.getX();
        double y2 = other.getY();


        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }


    /** Returns the string representation of this point.
     *
     * @return		the point string
     *
     */
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}
