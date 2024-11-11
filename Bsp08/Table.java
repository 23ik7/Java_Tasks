public class Table {
    String name;

    /**
     * Create a new table.
     * 
     * @param name The name of the table.
     */
    public Table(String name) {
        this.name = name;
    }

    /**
     * Set the name of this table.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the name of this table
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get a string representation of this table.
     */
    @Override
    public String toString() {
        return "{"+ name +"}";
    }
    
    // Ignore this. It’s here for the tests to work properly.
    protected Table() {}
}
