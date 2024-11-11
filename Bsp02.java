import java.util.Scanner;

public class Bsp02 {
    public static void main(String[] args) {
        /* Mehl (in g): 200
            Zucker (in g): 100
            Eier (Stück): 2 */

        int mehl;
        int zucker;
        int eier;

        System.out.print("? Mehl: ");
        Scanner scanner = new Scanner(System.in);
        mehl = scanner.nextInt();
        //System.out.print("? Mehl: ");
        //mehl = SavitchIn.readLineInt();

        System.out.print("? Zucker: ");
        Scanner scanner1 = new Scanner(System.in);
        zucker = scanner1.nextInt();
        //zucker = SavitchIn.readLineInt();

        System.out.print("? Eier: ");
        Scanner scanner2 = new Scanner(System.in);
        eier = scanner2.nextInt();
        //eier = SavitchIn.readLineInt();

        int m = mehl / 200;
        int z = zucker / 100;
        int e = eier / 2;

        int min = 0;

        if (e <= m && e <= z) {
            System.out.println("Anzahl der Kuchen: " + e);
            min = e;
        } else if (m <= e && m <= z) {
            System.out.println("Anzahl der Kuchen: " + m);
            min = m;
        } else {
            System.out.println("Anzahl der Kuchen: " + z);
            min = z;
        }

        mehl -= min * 200;
        zucker -= min * 100;
        eier -= min * 2;

        //String formStr = String.format("Rest:  %dg Mehl,  %dg Zucker, %d Ei(er)", mehl, zucker, eier);

        System.out.println("Rest: " + mehl + "g Mehl, " + zucker + "g Zucker, " + eier + " Ei(er)");
        //System.out.println(formStr);

        //Teil 2

        System.out.print("? Kosten: ");
        double kosten = SavitchIn.readLineDouble();

        System.out.print("? Anzahl der Abnehmer: ");
        int anzn = SavitchIn.readLineInt();

        double gesamtSp = 0;
        boolean gewinn = false;

        for (int i = 0; i < anzn; i++) {
            System.out.print("? Spende: ");
            double spende = SavitchIn.readLineDouble();
            gesamtSp += spende;

            if (gesamtSp >= kosten && gewinn == false) {
                System.out.println("--- Gewinnzone ---");
                gewinn = true;

            }
        }
        System.out.println("Gesamtspenden: " + gesamtSp);
        if (gesamtSp < kosten || gesamtSp == 0)
            System.out.println("Verlust");
    }
}
