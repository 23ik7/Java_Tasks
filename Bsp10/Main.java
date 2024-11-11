package Bsp10;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
        Task t0 = new Task("ExampleTask0");
        Date deadline1 = Date.createDate(2024, 1, 30);
        Task t1 = new TimedTask("ExampleTask1", deadline1);
        TaskList tlist1 = new TaskList("List1", 5);
        tlist1.addTask(t0);                                                //returns true
        tlist1.addTask(t1);                                                //returns true
        System.out.println(tlist1.getTitle() + Arrays.toString(tlist1.tasks)); // outputs: List1[ExampleTask0, ExampleTask1 (2024-01-30), null, null, null]
        Task t2 = new Task("ExampleTask2");
        TaskList tlist2 = new TaskList("List2", 5);
        tlist2.addTask(t2);                                                    //returns true
        System.out.println(tlist2.getTitle() + Arrays.toString(tlist2.tasks)); // outputs: List2[ExampleTask2, null, null, null, null]
        Task t3 = new TimedTask("ExampleTask3", deadline1);
        TaskList tlist12 = new TaskList("List12", 5);
        tlist12.addTask(tlist1);                                            //returns true
        tlist12.addTask(t3);                                                //returns true
        tlist12.addTask(tlist2);                                            //returns true

        Task t4 = new Task("ExampleTask4");
        System.out.println(tlist1.addTask(t4));                            // outputs: false (list is locked)
        System.out.println(tlist1.getCount());                                //outputs: 2
        System.out.println(tlist2.getCount());                                //outputs: 1
        System.out.println(tlist12.getCount());                            //outputs: 4
        tlist12.removeTask("List1");                                        //returns reference to tlist1
        System.out.println(tlist12.getCount());                            //outputs: 2
        tlist1.addTask(t4);                                                //returns true, list is unlocked
        System.out.println(tlist1.getTitle() + Arrays.toString(tlist1.tasks)); // outputs: List1[ExampleTask0, ExampleTask1 (2024-01-30), ExampleTask4, null, null]
        System.out.println(tlist1.getCount());                                //outputs: 3

        /// Teil 2
        System.out.println("------------");

        tlist12.setDone(true);
        System.out.println(t2.isDone());// outputs: true
        tlist12.addTask(tlist1);        // returns true
        System.out.println(tlist1);        // outputs: List1:[ExampleTask0,ExampleTask1 (2024-01-30),ExampleTask4]
        System.out.println(tlist12);// outputs: List12:[List1:[ExampleTask0,ExampleTask1 (2024-01-30),ExampleTask4],ExampleTask3 (2024-01-30),List2:[ExampleTask2]]
        System.out.println(tlist12.isDone());            // outputs: false
        System.out.println(tlist12.addStrictTask(t4));    // outputs: false
        System.out.println(tlist12.getCount());        // outputs: 5
	}
}
