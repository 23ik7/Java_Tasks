public class Bsp01 {
    public static void main(String[] args) {
        int monat;
        int tag;

        System.out.println();
        System.out.print("? Monat: ");
        monat = SavitchIn.readLineInt();

        System.out.print("? Tag: ");
        tag = SavitchIn.readLineInt();

        if (monat == 3 && tag == 26)
            System.out.println("Schalttag");

        else if (monat > 3 && monat < 10)
            System.out.println("Sommerzeit");

        else if (monat == 10 && tag < 29)
            System.out.println("Sommerzeit");

        else if (monat == 10 && tag == 29)
            System.out.println("Schalttag");

        else if (monat == 3 && tag >= 26)
            System.out.println("Sommerzeit");
        else
            System.out.println("Winterzeit");
    }
}
