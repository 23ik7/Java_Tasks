public class Row {
    int dimension;
    double[] values;
    


    /**
     * Creates a new row.
     * 
     * All entries are initially set to `Double.NaN`.
     * 
     * @param dimension The number of elements of that this row contains.
     */
    public Row(int dimension) {

        this.dimension = dimension;
        values = new double[dimension];

        
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.NaN;
        }
         
    }

    /**
     * Get the dimension of this row.
     */
    public int getDimension() {
        return dimension; 
    }

    /**
     * Get the values stored in this row.
     */
    public double[] getValues() {
        return values; 
    }

    /**
     * Sets the values of this row.
     * 
     * This replaces the entire array, not just its elements, and updates
     * the dimension of this row (according to the length of the given
     * `double` array).
     *
     * @param values The `double` array that replaces the `double` array
     *   of the current row.
     */
    public void setValues(double[] values) {

        this.values = values;

        this.dimension = values.length;
    }

    /**
     * Get a value in this row.
     * 
     * @param index The index of the value to get.
     * @return If the index is invalid (that is, negative or our of bounds),
     *   `Double.NaN`; otherwise, the value at that index (which may also be
     *   `Double.NaN`).
     */
    public double getValue(int index) {
        if (index < 0 || index >= values.length) {
            return Double.NaN;
        }
        else {
            return values[index];
        }
    }

    /**
     * Set a value in this row.
     * 
     * @param index The index of the value to set.
     * @param value The value to set the element at that index to.
     * @return `false` if the index is invalid (that is, negative or our of 
     *   bounds), or if the element at that index already has the value `value`;
     *   `true` otherwise.
     */
    public boolean setValue(int index, double value) {
        if (index < 0 || index >= values.length || values[index] == value 
        || Double.isNaN(value)) {
            return false;
        }
        else {
            values[index] = value;    
            return true;
            
        }

    }

    /**
     * Get the average of all values in this row.
     * 
     * @return The arithmetic mean of all non-NaN entries in this row; note that
     * NaN entries are to be excluded entirely; e.g. if a row has 10 entries;
     * only three of which—`a`,`b`, `c`—are not NaN, then this should return
     * `(a + b + c) / 3`.
     */
    public double getAverage() {
        if (values.length == 0) {
            return Double.NaN;
        }
        int c = 0;
        double s = 0;
        double r = 0;
        for (int i = 0; i < dimension; i++) {
            if (values[i] != Double.NaN) {
                c++;
                s += values[i];

            }
        }
        r = s / c;
        return r; 
    }

    /**
     * Convert a row to a string.
     */
    @Override
    public String toString() {
        String s = new String();
        double vs[] = getValues();

        s += "|";

        for (int i = 0; i < vs.length; ++i) {
            s += String.format(" %5.3f ", vs[i]);
            s += (i < vs.length ? "|" : "");
        }

        s += String.format(" %5.3f ", getAverage());
        s += "|";

        return s;
    }
}
