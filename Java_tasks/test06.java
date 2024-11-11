public class test06 {
    char wildSign = '*';

        if (pattern[0] == wildSign){

        }
        for (int i = 0; i <= dna.length - pattern.length; i++) {
            boolean appear = true;

            for (int n = 0; n < pattern.length; n++) {
                if (dna[i + n] != pattern[n] || dna[i + n] != wildSign) {
                    appear = false;
                    break;
                }

                
            } 

        } 

        return -1;

        /*String dnanewString = new String(dna);
        String patnewString = new String(pattern);

        
        if (dnanewString.indexOf(patnewString) != -1) {
            for (char c : pattern){
                if (c == wildSign){
                   int index = patnewString.indexOf(wildSign);
                }
            }
        System.out.println("Match Position = " + dnanewString.indexOf(patnewString));
        return dnanewString.indexOf(patnewString);
        }

        else {
            return -1;
        }*/
}

public static int searchWildCardPattern(char[] pattern, char[] dna) {
        int dias = 0;
        int poh = 1;
        int c = 0;
        String dnaString = new String(dna);
        //String patString = new String(pattern);
        
        for (int n = 0; n < dna.length; n++){
            int j = 0;
            if (dnaString.charAt(n) == pattern[0] || pattern[0] == '*'){
                    for (int i = n + 1; j < pattern.length; i++) {
                        j++;
                        if(dnaString.charAt(i) == pattern[poh]|| pattern[poh] == '*'){
                            dias++;
                            poh++;
                        }
                        if (dias + poh == pattern.length) {
                            c = n;
                        }
                        break;
                    }
            }
            
            
        }

        if (dias + poh == pattern.length){
            System.out.print("Match Position = ");
            return c;
        }
        else {
            return -1;
        }

    }
