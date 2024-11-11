public class CodeWarSRP {
    public static String rps(String p1, String p2) {
        if (p1.equals("scissors") && p2.equals("paper") || p1.equals("paper") && p2.equals("rock") || p1.equals("rock") && p2.equals("scissors"))
            return "Player 1 won!";//System.out.println("Player 1 won!");
        else if (p1.equals(p2))
            return "Draw!";//System.out.println("Draw!");
        else
            return "Player 2 won!";//System.out.println("Player 2 won!");
    }
}
