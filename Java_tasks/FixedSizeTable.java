import java.util.Arrays;

public class FixedSizeTable extends Table {
    int capacity;
    int size;
    int index;
    Row [] rows;
    /**
     * Create a new fixed-size table.
     *
     * @param name The name of the table
     * @param capacity How many rows this table should store.
     */
    public FixedSizeTable(String name, int capacity) {
        rows = new Row[capacity];
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * Returns the capacity of the table.
     */
    public int getCapacity() {
        return capacity; 
    }

    /**
     * Returns the number of rows stored in the table.
     */
    public int getSize() {
        return size; 
    }

    /**
     * Returns the rows stored in the table.
     */
    public Row[] getRows() {
        return rows; 
    }

    /**
     * Sets the number of rows stored in the table.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Returns the row at the given index.
     *
     * @param index The index of the row to return.
     * @return The row at the given index or null if the index is out of bounds.
     */
    public Row getRow(int index) {
        if (index < 0 || index >= capacity) {
            return null;
        }
        else {
            return this.rows[index];
        }
        
    }

    /**
     * Sets the row at the given index.
     *
     * @param index The index of the row to set.
     * @param row The new value of the row.
     * @return true if the row was set, false otherwise, including if the index
     *   is out of bounds.
     */
    public boolean setRow(int index, Row row) {
        if (index < 0 || index >= capacity) {
            
            return false;
        }
        else {
            this.rows[index] = row;
            return true;
        }
        
    }

    /**
     * Resizes the table.
     *
     * If the new size is smaller than the old size, the table is truncated,
     * i.e. all rows with an index >= capacity are deleted; if the new size
     * is larger than the old size, the table is extended by adding new rows
     * that are initialized with `null`.
     *
     * @param capacity The new capacity of the table.
     * @return The new capacity of the table.
     */
    public int resize(int capacity) {
        
        if (capacity < this.capacity) {
            rows = Arrays.copyOf(rows, capacity);
            if (size > capacity) {
                size = capacity;
            }
        }
        
        rows = Arrays.copyOf(rows, capacity);
        
        this.capacity = capacity;
        return capacity;
        
    }

    /**
     * Adds a row to the table.
     *
     * @param row The row to add.
     * @return true if the row was added, false otherwise, i.e. if the table
     *   is full.
     */
    public boolean addRow(Row row) {
        int c = 0;
        for (int j = 0; j < rows.length; j++) {
            if (rows[j] != null) {
                c++;
            }
        }

        if (c == rows.length) {
            return false;
        }
        else {
            for(int i = 0; i < rows.length; i++) {
                if (rows[i] != null) {
                    rows[i] = row;
                break;
            }
        }

        return true;

        }

        //
        
    }

    /**
     * Returns the maximum dimension amongst rows in the table.
     *
     * The dimension of a `null` row is 0.
     */
    public int getMaxDimension() {
        if (rows == null) {
            return 0;
        }
        int max = 0;

        for(int i = 0; i < rows.length; i++) {
            if (rows[i] != null) {

                if (rows[i].dimension > max) {

                    max = rows[i].dimension;
                }
            }
            
        }
        return max;
    }

    /**
     * Returns the average of each row.
     *
     * Empty (i.e. NaN) values are excluded from the calculation entirely.
     *
     * @return If the table is not empty, a new array containing the
     *   average of each row or 0 if a row is `null`. If the table is empty,
     *   `null` is returned. If all entries are NaN, NaN is returned.
     */
    public double[] getRowAverages() {
        double[] newAr = new double[rows.length];
        if (rows == null || rows.length == 0) {
            return null;
        }
        else {
            for(int i = 0; i < rows.length; i++) {
                if (rows[i] != null) {
                    newAr[i] = rows[i].getAverage();
                }
            }
            return newAr;
        }
        
    }

    /**
     * Returns the average of each column.
     *
     * Empty (i.e. NaN) values are excluded from the calculation entirely.
     *
     * @return If the table is not empty, a new array containing the
     *   average of each column, or NaN iff all entries in a column are 
     *   NaN or there are no entries in that column at all. If the table
     *   is empty, `null` is returned.
     */
    public double[] getColumnAverages() {
        
        double[] colAv = new double[getMaxDimension()];
        double[] helpAr = new double[capacity];

        if (capacity == 0) {
            return null;
        }

        else {
            
            for (int i = 0; i < colAv.length; i++) {
                for (int j = 0; j < helpAr.length; j++) {
                    helpAr[j] = rows[j].getValue(i);
                }

                Row end = new Row(helpAr.length);
                end.setValues(helpAr);
                colAv[i] = end.getAverage();

            }

            return colAv;
        }
    }

    /**
     * Returns a string representation of the table.
     */
    @Override
    public String toString() {
        return null;
    }
    
    // Ignore this. It’s here for the tests to work properly.
    protected FixedSizeTable() {}
}
