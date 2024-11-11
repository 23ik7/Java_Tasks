// Vorname Nachname, Matrikelnummer

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bsp04 {
    public static void main(String[] args) {
        // TODO: implement this.

        //createPassword();

        System.out.println(minSpecial("\"q?q", 2));
        
        
       
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
            return "";
        }

        System.out.print("Passwort wiederholen: ");
        passW = SavitchIn.readLine();

        if (passW.equals("stop")){
            System.out.println();
            System.out.println("Eingabe abgebrochen!");
            return "";
        }
        
        if (pass.equals(passW) == false){

            

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

                if (passW.equals("stop")){
                System.out.println();
                System.out.println("Eingabe abgebrochen!");
                return "";
        }
            }

            if (minLength(passW, 8) != true){
                System.out.println();
                System.out.println("Passwort zu kurz!");
                
            }
            if (fitFirstCharacter(passW) != true){
                System.out.println();
                System.out.println("Erstes Zeichen kein Buchstabe!");
                
            }
            if (minUpperCase(passW, 2) != true){
                System.out.println();
                System.out.println("Zu wenige Grossbuchstaben!");
                
            }
            if (minLowerCase(passW, 2) != true){
                System.out.println();
                System.out.println("Zu wenige Kleinbuchstaben!");
                
            }
            if (minDigit(passW, 2) != true){
                System.out.println();
                System.out.println("Zu wenige Ziffern!");
                
            }
            if (minSpecial(passW, 1) != true){
                System.out.println();
                System.out.println("Zu wenige Sonderzeichen!");
                
            }
            if (isolatedSpecial(passW)!= true){
                System.out.println();
                System.out.println("Sonderzeichen nebeneinander!");
                
            }
            if (fitFirstCharacter(passW)  && minLength(passW, 8)  && minUpperCase(passW, 2)  && minLowerCase(passW, 2)  && minDigit(passW, 2) && isolatedSpecial(passW)  && minSpecial(passW, 1)){
                System.out.println();
                System.out.println("Passwort gültig.");
                }
            return passW;
        }

        else {
            
            
            if (minLength(passW, 8) != true){
                System.out.println();
                System.out.println("Passwort zu kurz!");
                
            }

            if (fitFirstCharacter(passW) != true){
                System.out.println();
                System.out.println("Erstes Zeichen kein Buchstabe!");
                
            }

            if (minUpperCase(passW, 2) != true){
                System.out.println();
                System.out.println("Zu wenige Grossbuchstaben!");
                
            }
            if (minLowerCase(passW, 2) != true){
                System.out.println();
                System.out.println("Zu wenige Kleinbuchstaben!");
                
            }
            if (minDigit(passW, 2) != true){
                System.out.println();
                System.out.println("Zu wenige Ziffern!");
                
            }
            if (minSpecial(passW, 1) != true){
                System.out.println();
                System.out.println("Zu wenige Sonderzeichen!");
                
            }
            if (isolatedSpecial(passW)!= true){
                System.out.println();
                System.out.println("Sonderzeichen nebeneinander!");
                
            }
            if (fitFirstCharacter(passW)  && minLength(passW, 8)  && minUpperCase(passW, 2)  && minLowerCase(passW, 2)  && minDigit(passW, 2) && isolatedSpecial(passW)  && minSpecial(passW, 1)){
                System.out.println();
                System.out.println("Passwort gültig.");
                }
            return passW;
        }
        
    }

    // Check whether `pwd` contains at least `min` characters.
    public static boolean minLength (String pwd, int min) {
        if (pwd.length() >= min)
            return true;
        else    
            return false;
    }

    // Check whether the first character of `pwd` is a letter.
    public static boolean fitFirstCharacter (String pwd) {
        if (Character.isUpperCase(pwd.charAt(0)) || Character.isLowerCase(pwd.charAt(0)))
            return true;
        else
            return false;
    }
    

    // ============================= PART 2 =============================
    // Check whether `pwd` contains at least `min` uppercase characters.
    public static boolean minUpperCase (String pwd, int min) {
        char ch;
        int c = 0;
        for (int i = 0; i < pwd.length(); i++){

            ch = pwd.charAt(i);
            if (Character.isUpperCase(ch)){
                c++;
            }
        }
        if (c >= min){
            return true;
        }
        else{
            return false;
        }
         
    }

    // Check whether `pwd` contains at least `min` lowercase characters.
    public static boolean minLowerCase (String pwd, int min) {
        char ch;
        int c = 0;
        for (int i = 0; i < pwd.length(); i++){

            ch = pwd.charAt(i);
            if (Character.isLowerCase(ch)){
                c++;
            }
        }
        if (c >= min){
            return true;
        }
        else{
            return false;
        }
    
    }

    // Check whether `pwd` contains at least `min` digits.
    public static boolean minDigit (String pwd, int min) {
        char dig;
        int c = 0;
        for (int i = 0; i < pwd.length(); i++){

            dig = pwd.charAt(i);
            if (Character.isDigit(dig)){
                c++;
            }
        }
        if (c >= min){
            return true;
        }
        else{
            return false;
        } 
    }

    // Check whether `pwd` contains at least `min` of any of the following
    // characters (in any combination): 
    //
    //    ! " # % & ' ( ) * + , - . / @
    //
    public static boolean minSpecial (String pwd, int min) {

        String specials = "!\"#%&'()*+,\\-./@" ;

        char ch;
        int c = 0;
        for (int i = 0; i < pwd.length(); i++){

            
            ch = pwd.charAt(i);
            if (specials.indexOf(ch) != -1){/*Character.isDigit(ch) != true && Character.isUpperCase(ch) != true && Character.isLowerCase(ch) != true){*/
                c++;
            }
        }
        if (c >= min){
            return true;
        }
        else{
            return false;
        }
        
    }

    // Check whether `pwd` contains only isolated special characters.
    public static boolean isolatedSpecial (String pwd) {

        char ch0;
        char ch;
        int c = 0;
        for (int i = 0; i < pwd.length(); i++){

            
            ch = pwd.charAt(i);

            if ((i+1) < pwd.length()){
                ch0 = pwd.charAt(i+1);
            }
                
            else{
                ch0 = '1';
            }
            
            
            if ((Character.isDigit(ch) != true && Character.isUpperCase(ch) != true && Character.isLowerCase(ch) != true) && (Character.isDigit(ch0) != true && Character.isUpperCase(ch0) != true && Character.isLowerCase(ch0) != true)){
              c++;
            }
        }
        if (c > 0){
            return false;
        }
        else{
            return true;
        }
        
        
        /*Pattern special = Pattern.compile ("[!\\#%&'()*+,-./@]");
        Matcher hasSpecial = special.matcher(pwd);

        return hasSpecial.find();*/
    }
}
