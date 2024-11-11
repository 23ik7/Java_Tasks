import java.util.Arrays;

public class Bsp05 {
	public static void main(String[] args) {

        /*System.out.println("Alle Primzahlen <= n");
        System.out.print("?n: ");
        int n = SavitchIn.readInt();

        System.out.println("Alle Primzahlen <= " + n + ":");
		
        printFirstPrimes(firstPrimes(n));

		System.out.print("\n?Iterationen: ");
		int m = SavitchIn.readInt();
		System.out.println("Zahl -> nächstliegende Primzahl");


		for (int i = 0; i < m; i++){
            int r = PRNG.randomInt(n);
            System.out.println(r + " -> " + closestPrime(firstPrimes(r + 100), r));
        }*/
        System.out.println(isPrime(2));
  
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

	/**
	 * Finds the prime number closest to m. 
	 * 
	 * That is, the smallest prime number bigger than m or the biggest 
	 * prime number smaller than m, whichever is closest to m. If both 
	 * are equally distanced from m, return the *smaller* value.
	 * 
	 * @param firstPrimes array indicating which numbers are prime and which not 
	 * @param m index into array 
	 * @return as above, or -1 if m is not an index in firstPrimes or there's no prime there 
	 */
	public static int closestPrime(boolean[] firstPrimes, int m) {
	    if (m < 0 || m >= firstPrimes.length){
	        return -1;
	    }
	    int a = 0;
	    for (int i = 0; i < firstPrimes.length; i++){
	        if (firstPrimes[i] == true){
	           a++; 
	        }
	    }
	    
	    if (a == 0){
	        return -1;
	    }
        int dias = 1000;
        int said = 1000;
        for (int i = 0; i < firstPrimes.length; i++){

            if (i == m){
                if (firstPrimes[i] == true){
                    return i;
                }
                else {
                    for (int x = i + 1; x < firstPrimes.length; x++) {
                        if(firstPrimes[x] == true) {
                            if (dias > (x - i)) {
                                dias = x - i;
                            }
                        }
                    }
                    for (int x = i - 1; x >= 0; x--) {
                        if(firstPrimes[x] == true) {
                            if (said > (i - x)) {
                                said = i - x;
                            }
                        }
                    }
                }
            }
        }
        if (dias < said) {
            return m + dias;
        }
        else {
            return m - said;
        }
    }
}