package Bsp09;

public class Date {
    private int year;
    private int month;
    private int day;
    
    /** PRIVATE constructor! creates a new Date */
    private Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /** 
     * STATIC method! creates and returns a new Date object with the 
     * specified year, month, and day; returns null if at least one parameter 
     * is invalid, where valid values for days are 1..31, for months 1..12, and 
     * for years 2024..9999; 
     */
    public static Date createDate(int year, int month, int day) {

        if (year < 2024 || year > 9999 || month < 1 || month > 12 
        || day < 1 || day > 31) {
            return null;
        }
        
        Date newDate = new Date(year, month, day);
        return newDate;
    }

    /** 
     * returns the string representation of this date in the format 
     * yyyy-mm-dd (e.g., 2024-01-31). 
     */
    //public String toString() {
        // Do not alter this function!
        //return "%04d-%02d-%02d".formatted(year, month, day);
    //}
    
    /** 
     * Compares this date with the specified date `d` for order. Returns a 
     * negative integer, zero, or a positive integer as this date is less 
     * (earlier) than, equal to, or greater (later) than the specified date 
     *`d`. 
     */
    public int compareTo(Date d) {

        if (this.year < d.year || (this.year == d.year && this.month < d.month 
        ) || (this.year == d.year && this.month == d.month 
        && this.day < d.day)) {
            return -1;
        }

        if (this.year == d.year && this.month == d.month 
        && this.day == d.day) {
            return 0;
        }

        if (this.year > d.year || (this.year == d.year && this.month > d.month 
        ) || (this.year == d.year && this.month == d.month 
        && this.day > d.day)) {
            return 1;
        }
        
        return 0;
    }
}
