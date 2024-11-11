public class Database {
    int capacity;
    int size;
    VariableSizeTable[] tables;
    
    /**
     * Create a new database with the given capacity.
     */
    public Database(int capacity) {
        this.capacity = capacity;
        tables = new VariableSizeTable[capacity];
        this.size = 0;
    }

    /**
     * Return the tables in this database.
     */
    public VariableSizeTable[] getTables() {
        return tables;
    }

    /**
     * Return the capacity of this database.
     */
    public int getCapacity() {
        return capacity; 
    }

    /**
     * Return the number of tables in this database.
     */
    public int getSize() {
        return size;
    }

    /**
     * Add the given table to this database.
     *
     * If the database is full, double the capacity of the database.
     *
     * @return the index of the table in this database.
     */
    public int addTable(VariableSizeTable table) {
        VariableSizeTable[] finalT = new VariableSizeTable[capacity];
        if (size == capacity) {
            capacity = 2 * capacity;
            for (int i = 0; i < capacity; i++) {
                if (i < tables.length) {
                    finalT[i] = tables[i];
                }

                else {
                    finalT[i] = null;
                }
            }
            finalT[size] = table;
            size +=1;
            tables = finalT;
            return size-1;
        }
        else {
            int index = 0;
            for (int i = 0; i < tables.length; i++) {
                if (tables[i] == null) {
                    tables[i] = table;
                    index = i;
                    break;
                }
            }
            size += 1;
            return index;
        } 
    }

    /**
     * Find a table by name.
     *
     * @return the table with the given name, or null if no such table exists.
     */
    public VariableSizeTable findTable(final String name) {
        if (size == 0) {
            return null;
        }
        else {
            
            for (int i = 0; i < tables.length; i++) {
                
                if (name.equals(tables[i].getName())) {
                    return tables[i];
                }
            }
        
            return null;
        
        }
    }

    /**
     * Compute the union of two tables.
     *
     * Find two tables A and B by name and combine them into a new table. The
     * capacity of the resulting table is the sum of the sizes (not capacities!)
     * of A and B, and the *values* of A and B are copied into the new table; 
     * i.e. a *new* row is created for each row in A and B, and the values of 
     * the old rows are copied into the new rows. The size of each of the new 
     * rows is the maximum size amongst all rows in A and B.
     *
     * @param nameA the name of the first table.
     * @param nameB the name of the second table.
     * @param nameUnion the name of the new table.
     * @return the union table of A and B, or `null` if either table does 
     *   not exist.
     */
    public VariableSizeTable union(String nameA, String nameB, String nameUnion) {
        if (findTable(nameA) == null || findTable(nameB) == null) {
            return null;
        }
        else {
            int home = findTable(nameA).getSize() + findTable(nameB).getSize();
            VariableSizeTable output = new VariableSizeTable(nameUnion, home);
            int perem = 0;
            int ruka = 0;
            for (int i = 0; i < findTable(nameA).getSize(); i++) {
                for (int j = perem; j < findTable(nameA).getCapacity(); j++) {
                    if (findTable(nameA).getRow(j) != null) {
                        output.setRow(i, findTable(nameA).getRow(j));
                        perem = j + 1;
                        break;
                    }
                }
                ruka = i + 1;
            }
            
            perem = 0;
            for (int i = 0; i < findTable(nameB).getSize(); i++) {
                for (int j = perem; j < findTable(nameB).getCapacity(); j++) {
                    if (findTable(nameB).getRow(j) != null) {
                        output.setRow(ruka, findTable(nameB).getRow(j));
                        perem = j + 1;
                        ruka += 1;
                        break;
                    }
                }
            }
            int max = output.getMaxDimension();
            for (int i = 0; i < output.capacity; i++) {
                if (output.getRow(i).getDimension() != max) {
                    Row java = new Row(max);
                    for (int j = 0; j < max; j++) {
                        java.setValue(j, output.getRow(i).getValue(j));
                    }
                    output.setRow(i, java);
                }
            }
            return output;
        }
    }

    /**
     * Return a string representation of this database.
     */
    @Override
    public String toString() {
        return null; // TODO: implement.
    }
}