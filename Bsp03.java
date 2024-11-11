import java.util.Random;

public class Bsp03 {
    public static void main(String[] args) {
        
        //Teil 1
        System.out.print("? Maximale Anzahl der Wuerfe: ");
        int anzW = SavitchIn.readLineInt();

        int countPunkte = 0;
        int countEins = 0;
        int countDopEins = 0;

        for (int i = 0; i < anzW; i++){

            int rzahl1 = rollDie();
            int rzahl2 = rollDie();

            System.out.print("(" + rzahl1 + "," + rzahl2 + ")");

            if (hasDoubleOne(rzahl1, rzahl2)){
                System.out.print(" Doppelte 1 (Ruecksetzung) ");
                countDopEins++;
                System.out.println("#" + countDopEins);
            }
            else if (hasSingleOne(rzahl1, rzahl2)){
              System.out.print(" Einfache 1 (keine Punkte) ");
              countEins++;
              System.out.println("#" + countEins);
                
            }
            else{
                System.out.print(" Punkte ");
              countPunkte++;
              System.out.println("#" + countPunkte);
            }
        }
        System.out.print("? Anzahl der Spieler:innen: ");
        int n = SavitchIn.readLineInt();
        pig(n);

    }


    // PART 1
    // Computes a random number between 1 and 6.
    public static int rollDie() {

        return PRNG.randomInt(6) + 1;

        //Random wurf = new Random();

        //return wurf.nextInt(6) + 1;
    }

    // Returns whether exactly one of d1 or d2 (but not both!) is equal to 1.
    public static boolean hasSingleOne(int d1, int d2) {
        if ((d1 == 1 && d2 != 1) || (d1 != 1 && d2 == 1))
            return true;
        else
            return false;
    }

    // Returns whether both d1 and d2 are each equal to 1.
    public static boolean hasDoubleOne(int d1, int d2) {
        if (d1 == 1 & d2 == 1)
            return true;
        else
            return false;
    }

    // PART 2
    // Simulate the game Pig for `n` players; note that
    // `n` is always >= 1.
    public static int pig(int n) {

        int sum = 0;

        int winner = 0;
        int maxWur = 0;
        int maxPunkte = 0;
        
        //int rz1 = rollDie();
        //int rz2 = rollDie();

        for (int y = 1; y < n + 1; y++){
           System.out.println("##### Spieler:in " + y);
           
           int fsum = 0;
           int rz1 = 0;
           int rz2 = 0;
           int x = 0; 

            while ((hasSingleOne(rz1, rz2) != true) && hasDoubleOne(rz1, rz2) != true){ 
                //for (int x = 1; x < y + 1; x++){

                    rz1 = rollDie();
                    rz2 = rollDie();

                    if (hasSingleOne(rz1, rz2)){
                        //sum = rz1 + rz2;
                        //fsum = fsum + sum;
                        x++;
                        System.out.println(x + ". Wurf: " + "(" + rz1 + ", " + rz2 + ")" + " | " + fsum);
                        break;
                    }

                    else if (hasDoubleOne(rz1, rz2)){  
                    fsum = 0;
                    x++;
                    System.out.println(x + ". Wurf: " + "(" + rz1 + ", " + rz2 + ")" + " | " + fsum);
                    break;
                    }

                    else {
                    sum = rz1 + rz2;
                    fsum = fsum + sum;
                    x++;
                    System.out.println(x + ". Wurf: " + "(" + rz1 + ", " + rz2 + ")" + " | " + fsum);
                    }
            

            }

            if (fsum > maxPunkte){
                maxPunkte = fsum;
                winner = y;
            }

            if (x > maxWur){
                maxWur = x;
            }



        }

        System.out.println("##### Gewinner:in: Spieler:in " + winner);
        System.out.println("##### Anzahl der Wuerfe: " + maxWur);
        System.out.println("##### Maximale Punktezahl: " + maxPunkte);
        
        return maxPunkte;

    }
}
