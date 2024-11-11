// EinfProg_VO1

import java.util.Scanner;

public class Kreis {

    public static void main(String[] args) {
        double radius;
        double umfang;
        double flaeche;
        final double PI = 3.14159;

        System.out.println();
        System.out.println("Radius bitte: ");

        Scanner scanner = new Scanner(System.in);
        radius = scanner.nextDouble();
        /* radius = SavitchIn.readLineDouble(); */

        umfang = 2 * PI * radius;
        flaeche = PI * radius * radius;

        System.out.println("Umfang = " + umfang);
        System.out.println("Flaeche = " + flaeche);
        System.out.println();

    }
}
