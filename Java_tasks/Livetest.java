import java.util.Scanner;

public class Livetest {
    public static void main(String[] args){

        int x;

        int ed = 0;
        int dv = 0;
        int ch = 0;

        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();

        while (x != 0) {

            if (x % 4 == 1 || x % 4 == 0){
                x = x - 4;
                ch++;
            }
            else if (x % 2 == 0){
                x = x - 2;
                dv++;
            }
            else if (x == 1){
                x = x - 1;
                ed++;
                
            }
            else {
            System.out.println("ungueltig");
            break;
            }
                        
        }
                System.out.print(ch);
                System.out.print(dv);
                System.out.print(ed);
    }
    
}
