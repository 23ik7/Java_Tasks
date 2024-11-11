import java.util.Arrays;

public class Bsp08 {
  public static void main(String[] args) {
    // Test your implementation here.
    // creates a new fixed size table named "F1", which can hold up to five rows
// creates a new fixed size table named "F1", which can hold up to five rows
FixedSizeTable fst = new FixedSizeTable("F1", 5);

// for reference, i.e., to check the behavior of the addRow() method
int insertions = 0;
// every row contains exactly ten values
int dimension = 10;

// inserts five rows into our fixed size table
for (int i = 0; i < 5; ++i) {
  // creates a new Row object that can hold 10 values
  Row row = new Row(dimension);

  // assigns a random value to each entry in our Row object
  for (int j = 0; j < dimension; ++j) {
    row.setValue(j, PRNG.randomDouble());
  }

  // adds our Row object to our fixed size table and increments a counter for
  // every successful insertion (i.e., if we insert more than five rows, this
  // counter should stop at five).
  if (fst.addRow(row)) {
    ++insertions;
  }
}

// prints some statistics about our fixed size table
System.out.println("Tabelle " + fst.getName() + ":");
System.out.println("  * Erfolgreich eingefügte Einträge: " + insertions);
System.out.println("  * Dimensionen: " + fst.getMaxDimension());
System.out.println("  * Kapazität: " + fst.getCapacity());
System.out.println("  * Größe: " + fst.getSize());
System.out.println();

// prints the second row (i.e., the corresponding Row object)
System.out.println("Zeile 2: " + fst.getRow(1));
System.out.println();

// prints our fixed size table in its initial state, including how many entries
// are used from the overall capacity in the format "<size> / <max. capacity>"
System.out.println(fst);
System.out.println(fst.getSize() + " / " + fst.getCapacity());
System.out.println();

// shrinks our fixed size table to store at most three rows, i.e., the last two
// rows are lost in the process
fst.resize(3);

// prints our fixed size table after shrinking it
System.out.println(fst);
System.out.println(fst.getSize() + " / " + fst.getCapacity());
System.out.println();

// grows our fixed size table to store at most ten rows, i.e., there are seven
// unused rows (i.e., they are null)
fst.resize(10);

// prints our fixed size table after growing it
System.out.println(fst);
System.out.println(fst.getSize() + " / " + fst.getCapacity());
System.out.println();

// shrinks our fixed size table to store at most eight rows, i.e., no rows
// are lost in the process
fst.resize(8);

// prints our fixed size table after shrinking it again
System.out.println(fst);
System.out.println(fst.getSize() + " / " + fst.getCapacity());
System.out.println();

// prints the averages of all row of our fixed size table
// Hint: import java.util.Arrays; and you are allowed to use Arrays.toString()
System.out.println(Arrays.toString(fst.getRowAverages()));

// prints the averages of all column of our fixed size table
// Hint: import java.util.Arrays; and you are allowed to use Arrays.toString()
System.out.println(Arrays.toString(fst.getColumnAverages()));
  }
}