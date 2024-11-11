import java.util.Arrays;
import java.util.Random;

public class Bsp06 {
    public static void main(String[] args) {
        
        char [] dna = {'T', 'C', 'G' , 'G', 'A', 'C', 'T', 'G'}; //Arrays.toString(name) prints array as a string to easier reading
        char [] pattern = {'A', '*', 'T'};
        char [] promoter = {'T', '*', 'G'};
        char [] terminator = {'C', '*', 'G'};


        System.out.print("DNA: [");
        for (int i = 0; i < dna.length; i++){
            if (i != (dna.length-1)){
                System.out.print(dna[i]+", ");
            } 
            else if (i == dna.length-1) {
                System.out.println(dna[i] + "]");
            }
        }

        System.out.print("Pattern: [");
        for (int n = 0; n < pattern.length; n++){
            if (n != (pattern.length-1)){
                System.out.print(pattern[n]+", ");
            } 
            else if (n == pattern.length-1) {
                System.out.println(pattern[n] + "]");
            }
        } 
        //searchPattern(pattern, dna);

        //System.out.println(createSequence(4));

        //System.out.println("Match count = " + getNumberOfMatches(pattern, dna));
        System.out.println(cutTailAt(3, dna));

        

        System.out.print("Promoter: [");
        for (int i = 0; i < promoter.length; i++){
            if (i != (promoter.length-1)){
                System.out.print(promoter[i]+", ");
            } 
            else if (i == promoter.length-1) {
                System.out.println(promoter[i] + "]");
            }
        }

        System.out.print("Terminator: [");
        for (int i = 0; i < terminator.length; i++){
            if (i != (terminator.length-1)){
                System.out.print(terminator[i]+", ");
            } 
            else if (i == terminator.length-1) {
                System.out.println(terminator[i] + "]");
            }
        }

        System.out.print("Gene Sequence: [");
        for (int i = 0; i < searchGeneSequence(promoter, terminator, dna).length; i++){
            if (i != (searchGeneSequence(promoter, terminator, dna).length-1)){
                System.out.print(searchGeneSequence(promoter, terminator, dna)[i]+", ");
            } 
            else if (i == searchGeneSequence(promoter, terminator, dna).length-1) {
                System.out.println(searchGeneSequence(promoter, terminator, dna)[i] + "]");
            }
        }
        System.out.print("Match Position = ");
        System.out.println(searchWildCardPattern(pattern, dna));
        
    }




    /**
     * Searches the first occurrence of a pattern in the DNA.
     *
     * @param pattern the pattern to be searched
     * @param dna     the DNA sequence
     * 
     * @return the position of the first character of the first pattern 
     *         found in the DNA; -1, if pattern is not found
     */
    public static int searchPattern(char[] pattern, char[] dna) {
        String dnaString = new String(dna);
        String patString = new String(pattern); 

        if (dnaString.indexOf(patString) != -1) {

            System.out.println("Match Position = " + dnaString.indexOf(patString));
            return dnaString.indexOf(patString);
        }

        else {
            return -1;
        }

        
    }

    /** 
     * Returns a random base sequence of given length.
     *
     * @return a random base sequence (containing the four DNA bases)
     */
    public static char[] createSequence(int length) {
        char [] dnaBase = {'A', 'C', 'G', 'T'};
        char [] randSeq = new char[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randInd = random.nextInt(dnaBase.length);
            randSeq[i] = dnaBase[randInd];
        }
        

        return randSeq;
    }

    /**
     * Returns the number of occurrences of a pattern in the DNA.
     *
     * @param pattern the pattern to be searched
     * @param dna     the DNA sequence
     * 
     * @return the number of occurrences
     */
    public static int getNumberOfMatches(char[] pattern, char[] dna) {
        int occur = 0;

        if (Arrays.equals(pattern, dna)) {
            occur = 1;
            return occur;
        }

        for (int i = 0; i < dna.length/*i <= dna.length - pattern.length*/; i++) {
            boolean appear = true;

            for (int n = 0; n < pattern.length; n++) {
                if (dna[i + n] != pattern[n]) {
                    appear = false;
                    break;
                }
                
            } 

            if (appear) {
                occur++;
            }

        }    
        return occur;
    }

    /**
     * Returns the remainder (tail) of the array from the given position.
     *
     * @return the tail array (index 0 is at position 'pos' of 'sequence')
     */
    public static char[] cutTailAt(int pos, char[] sequence) {
        //String strSeq = new String(sequence);
        char [] empty = new char[0];
        if (pos < 0 || pos >= sequence.length) {
            return empty;
        }

        return Arrays.copyOfRange(sequence, pos, sequence.length);
    }
    
    // =========================================================================
    //  Part 2
    // =========================================================================
    
    /**
     * Searches the first occurrence of a wildcard pattern in the DNA. 
     * 
     * The wildcard pattern may include the wildcard character '*', which 
     * matches any base.
     *
     * @param pattern the wildcard pattern to be searched
     * @param dna     the DNA sequence
     * 
     * @return the position of the first character of the first wildcard 
     *         pattern found in the DNA; -1, if pattern is not found
     */
    public static int searchWildCardPattern(char[] pattern, char[] dna) {
        for (int i = 0; i < dna.length/*i <= dna.length - pattern.length*/; i++) {

            int n = 0;

            for (n = 0; n < pattern.length; n++) {
                if (pattern[n] != '*' && dna[i + n] != pattern[n]) {
                    break;
                }

            }
            
            if (n == pattern.length) {
                return i; 
            }   

        }
               
        return -1;
    }


    /**
     * Searches the first gene sequence in the DNA with the given promoter 
     * and terminator.
     *
     * @param promoter   the start wildcard pattern of a gene
     * @param terminator the end wildcard pattern of a gene
     * 
     * @return the gene sequence between promoter and terminator (may be 
     *         empty); null, if promoter or terminator not found
     */
    public static char[] searchGeneSequence(char[] promoter, char[] terminator, char[] dna) {
        int prom = searchWildCardPattern(promoter, dna);
        int term = searchWildCardPattern(terminator, Arrays.copyOfRange(dna, prom + promoter.length, dna.length));

        if (prom == -1) {
            return null;
        }
        
        if (term == -1) {
            return null;
        }
        
        return Arrays.copyOfRange(dna, prom + promoter.length, prom + promoter.length + term);
    }
}
