import java.util.Arrays;

public class Bsp05test {
	public static void main(String[] args) {

        System.out.println("Alle Primzahlen <= n");
        System.out.print("?n: ");
        int n = SavitchIn.readInt();

        System.out.println("Alle Primzahlen <= " + n + ":");
		
        printFirstPrimes(firstPrimes(n));

		System.out.print("\n?Iterationen: ");
		int m = SavitchIn.readInt();
		System.out.println("Zahl -> nächstliegende Primzahl");

		int r = 0;

		for (int i = 0; i < m; i++){
            r = PRNG.randomInt(n);
            System.out.println(r + " -> " + closestPrime(firstPrimes(n), r));
        }
	}
	
    /**
     * Checks whether a number is prime.
     * 
     * @return true if n is positive and prime, false otherwise.
     */
	public static boolean isPrime(int n) {
        if (n <= 1){

            return false;
        }
        
        for (int i = 2; i <= n/2; i++){

            if ((n%i) == 0){

                return false;
            }
            
        }

        return true;
		
	}

	/**
	 * Checks which natural numbers from 0 to n are primes
	 * 
	 * @param n maximum number to check
	 * @return array with n+1 elements with value true at index i if i is a prime
	 *  and false otherwise
	 */
	public static boolean[] firstPrimes(int n) {

        boolean[] boolAr = new boolean[n+1];


        for (int i = 0; i < boolAr.length; i++){

            boolAr[i] = isPrime(i);

            
            
        }
		return boolAr;
        
	}

	/**
	 * Prints prime numbers 
	 * 
	 * @param firstPrimes array indicating which numbers are prime
	 * @return number of primes in the array
	 */
    public static int printFirstPrimes(boolean[] firstPrimes) {



        int x = 0;

        for (int i = 0; i < firstPrimes.length; i++) {
            
            if (firstPrimes(firstPrimes.length)[i] == true){
                System.out.print(i + " ");
                x++;
            }
        }

        System.out.print("\n");

        System.out.println("Insgesamt: "+ x +" Primzahlen <= "+ (firstPrimes.length-1) +".");

		return x; 
	}


	public static int closestPrime(boolean[] firstPrimes, int m) {

        if(m >= firstPrimes.length || m < 0)
            return -1;

        int min = 0;
        boolean var1 = true;

        while(m-min>=0){

            if(firstPrimes[m-min]){

                var1 = false;
                break;
            }

            min++;
        }

        int max = 0;
        boolean var2 = true;

        while(m + max <= firstPrimes.length-1 ){

            if(firstPrimes[m+max]) {

                var2 = false;
                break;
            }

            max++;
        }

        if(var1 && var2){
            return -1;
        }
        else if(var1){
            return m+max;
        }
        else if(var2){
            return m-min;
        }  
        else{
           if(max < min)
                return m+max;
            else
                return m-min;
        }    
    }
}