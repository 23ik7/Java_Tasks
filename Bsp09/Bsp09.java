package Bsp09;

public class Bsp09 {
    public static void main(String[] args) {
        Task t0 = new Task("ExampleTask0");
        Date deadline1 = Date.createDate(2024, 1, 31);
        Task t1 = new TimedTask("ExampleTask1", deadline1);

        System.out.println(t0); 
        System.out.println(((TimedTask)t1).getDeadline()); 
        System.out.println(t1);
    }
}
