package Bsp09;

import java.util.Arrays;

public class TaskList {
    private int capacity;
    private final Task[] tasks;
    

    /**
     * creates a new TaskList with the given maximum capacity;
     * if capacity is smaller than zero, the capacity is set to 0
     */
    public TaskList(int capacity) {
        if (capacity < 0) {
            this.capacity = 0;
        }
        else {
            this.capacity = capacity;
        }
        tasks = new Task[capacity];
    }

    /**
     * returns the maximum capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * returns the number of actual (non-null) Task objects managed by the tasks array
     */
    public int getCount() {
        int c = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null) {
                c++;
            }
        }
        return c;
    }

    /**
     * Adds the given task to the tasks array at the first free position; 
     * returns true if the task was added successfully; otherwise returns false 
     * (i.e., the list has already reached the maximum capacity, or another task 
     * with the same title already exists, or task is `null` or the task's title 
     * is `null`)
     */
    public boolean addTask(Task task) {
        if (getCount() == capacity || task == null || task.getTitle() == null) {
            return false;
        }

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == task) {
                return false;
            }
        }


        for (int j = 0; j < tasks.length; j++) {
            if (tasks[j] == null) {
                tasks[j] = task;
                return true;
            }
            
        }
        return false;
    }

    /**
     * adds a newly created `Task` with the given title to the tasks array at 
     * the first free position; returns the created task if the task was added 
     * successfully; otherwise returns null (i.e., the list has already reached 
     * the maximum capacity, or another task with the same title already exists,
     * or the title is `null`)
     */
    public Task addTask(String title) {
        if (getCount() == capacity || title == null) {
            return null;
        }

        Task nTask = new Task(title);
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks[i].getTitle().equals(title)) {
                return null;
            }
            else {
                tasks[i] = nTask;
                return nTask;
            }
        
        }
        return null;
    }

    /**
     * adds all given tasks to the tasks array (the order is retained; every 
     * task is added at the first free position); returns true if all the tasks 
     * were added successfully; otherwise returns false 
     * (see `addTask(Task task)`)
     */
    public boolean addTasks(Task[] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            addTask(tasks[i]);
        }
        return true;
    }

    /**
     * returns the task with the specified title, or `null` if no such task 
     * was found
     */
    public Task getTask(String title) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks[i].getTitle().equals(title)) {
                return tasks[i];
            }
        }
        return null; 
    }

    /**
     * returns the task at the specified index in the tasks array;
     * returns null if there is no task at this index, or the index is invalid 
     * (i.e., out-of-bounds).
     */
    public Task getTask(int idx) {
        if (idx > tasks.length || idx < 0) {
            return null;
        }

        for (int i = 0; i < tasks.length; i++) {
            if (i == idx) {
                return tasks[i];
            }
        }
        return null;
    }

    /**
     * prints the string representation (as obtained by `toString()`) of all 
     * tasks in the order of the tasks array; null-values are ignored. Tasks 
     * that are marked as done are only printed if `includeDone` is `true`
     */
    public void printTasks(boolean includeDone) {
        if (includeDone == true) {
            for (int i = 0; i < tasks.length; i++) {
                if (tasks[i] != null) {
                    System.out.println(tasks[i].toString());
                }
            }
        }
        else {
            for (int j = 0; j < tasks.length; j++) {
                if (tasks[j] != null && tasks[j].isDone() != true) {
                    System.out.println(tasks[j].toString());
                }
            }
        }
    }

    /**
     * returns all elements in the array tasks (including null) as a list in 
     * [...] (see example):
     * [task0, task1, null, ....]
     */
    public String toString() {
        return Arrays.toString(tasks); 
    }
    
    /** removes the task with the given title; returns the removed task or null 
      * if no task with that title was found 
      */
    public Task removeTask(String title) {
        Task nTask = new Task(title);
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks[i].getTitle().equals(title)) {
                tasks[i] = null;
            }
        }
        return nTask;
    }

    /** returns a `TaskList` that contains all tasks which are not yet done 
     * (in the original order); if the task is a `TimedTask` it is only part of 
     * the returned list, if its deadline has not yet passed; the capacity of 
     * the returned list must be equal to the number of tasks in the list (i.e.
     * it must not contain `null` values). 
     */
    public TaskList getTODOsDueUntil(Date deadline) {

        int c = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks[i].isDone() == false || 
            (tasks[i] instanceof TimedTask && ((TimedTask) tasks[i]).getDeadline().compareTo(deadline) < 0)) {
                c++;
            }
        }

        TaskList newTL = new TaskList(c);
        for (int j = 0; j < tasks.length; j++) {
            if (tasks[j] != null && tasks[j].isDone() == false || 
            (tasks[j] instanceof TimedTask && ((TimedTask) tasks[j]).getDeadline().compareTo(deadline) < 0)) {
                newTL.addTask(tasks[j]);
            }
        }
        return newTL; 
    }

    /** changes the tasks array to a compact representation by avoiding null 
     * values between individual tasks; this is achieved by shifting tasks to 
     * the leftmost free position while retaining the order of tasks; returns 
     * true only if at least one task changed its position 
     */
    public boolean compact() {
        int c = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null) {
                c++;
            }
        }

        TaskList newTL = new TaskList(c);
        for (int i = 0; i < tasks.length + 1; i++) {
            if (tasks[i] != null ) {
                newTL.addTask(tasks[i]);
                return true;
            }
        }
        return false; 
    }
}
