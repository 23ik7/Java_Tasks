public class testBsp04 {
        public static void main(String[] args) {
            // TODO: implement this.
    
            
            createPassword();
           
        }
    
    
        // ============================= PART 1 =============================
        // Prompt the user for a password.
        public static String createPassword() {
    
            String pass;
            String passW;
     
            System.out.print("Passwort eingeben / stop für Abbruch: ");
            pass = SavitchIn.readLine();

            if (pass.equals("stop")){
                        System.out.println();
                        System.out.println("Eingabe abgebrochen!");
                        return "";}    
    
            System.out.print("Passwort wiederholen: ");
            passW = SavitchIn.readLine();

            if (passW.equals("stop")) {
                        System.out.println();
                        System.out.println("Eingabe abgebrochen!");
                        return "";}

            while (pass.equals(passW) == false) {
                    System.out.println( " Verschieden - neuer Versuch");
                
                    System.out.print("Passwort eingeben / stop für Abbruch: ");
                    pass = SavitchIn.readLine();
                    if (pass.equals("stop")){
                        System.out.println();
                        System.out.println("Eingabe abgebrochen!");
                        return "";
                    }
    
                    System.out.print("Passwort wiederholen: ");
                    passW = SavitchIn.readLine();
                    if (passW.equals("stop")) {
                        System.out.println();
                        System.out.println("Eingabe abgebrochen!");
                        return "";
                    }
                
            }
    
            /*if (pass.equals(passW) == false){
                while (pass.equals(passW) == false) {
    
                    System.out.println( " Verschieden - neuer Versuch");
                
                    System.out.print("Passwort eingeben / stop für Abbruch: ");
                    pass = SavitchIn.readLine();
    
                    System.out.print("Passwort wiederholen: ");
                    passW = SavitchIn.readLine();
                }
                return " Verschieden - neuer Versuch";

            }*/
            
            if (pass.equals(passW) == true) {
                System.out.println();
                System.out.println("Passwort gültig.");
                return passW;
                }
        }
}

if (fitFirstCharacter(passW) != true && minLength(passW, 8) != true && minUpperCase(passW, 2) != true && minLowerCase(passW, 2) != true && minDigit(passW, 2) != true && isolatedSpecial(passW) != true && minSpecial(passW, 2) != true){
                System.out.println();
                System.out.println("Passwort zu kurz!");
                System.out.println("Erstes Zeichen kein Buchstabe!");
                System.out.println("Zu wenige Grossbuchstaben!");
                System.out.println("Zu wenige Kleinbuchstaben!");
                System.out.println("Zu wenige Ziffern!");
                System.out.println("Zu wenige Sonderzeichen!");
                System.out.println("Sonderzeichen nebeneinander!");
                return passW;
            }
