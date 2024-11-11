package Bsp10;

import java.util.Arrays;

public class TaskList extends Task {

	final Task[] tasks; // NOT private!
	private int count;
    private int capacity;
    private boolean locked = false;

	public TaskList(String title, int capacity) {
        super(title);
        if (capacity < 0) {
            this.capacity = 0;
        }
        else {
            this.capacity = capacity;
        }
		tasks = new Task[Math.max(0, capacity)];
	}
	
    /**
     * Locks the list against additions and removal from tasks.
     *
     * After this method is called and until the unlock method
     * is called, no task additions or removals may succeed
     */
    public void lock() {
        locked = true;
    }

    /**
     * Unlocks the list. Task additions and removals may succeed
     * until lock() is called.
     */
    public void unlock() {
        locked = false;
    }

    /**
     * @return true if list is locked, false otherwise
     */
    public boolean isLocked() {
        if (locked == true) {
            return true;
        }
        else {
            return false;
        }
    }

	public int getCount() {
        int c = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null ) {
                if (tasks[i] instanceof TaskList) {
                    try {
                        c = c + ((TaskList) tasks[i]).getCount();
                    }
                    catch (StackOverflowError e) {
                        return c;
                    }
                }

                else {
                    c++;
                }
                
            }
        }
		return c; 
	}

   /**
     * Same as in A09 (and template code), plus:
     *
     * @param task to be added
     * @return false and does not add task if:
     * - this list is locked or if parameter task is the same as this list
     * - another task with same title exists in the task array of this list
     * The operation succeeds if another task with same title exists in a nested list (but not in this list).
     * If parameter task refers to a task list and it is added successfully, then that list becomes locked.
     */
	public boolean addTask(Task task) {
	    if ( locked || task == null || task.getTitle().equals(this.getTitle()) ) {
            return false;
        }
        
		if (task != null && task.getTitle() != null && !contains(task.getTitle()))
			for (int i = 0; i < tasks.length; i++)
				if (tasks[i] == null) {
                    if (task instanceof TaskList) {
                        ((TaskList) task).lock();
                    }
					tasks[i] = task;
					count++;
					return true;
				}
		return false;
	}

    /**
     * Same as in A09 (and template code), plus:
     *
     * @param title
     * @return null and does not remove if list is locked
     * If the removed tasks is a list, then that list becomes unlocked
     */
	public Task removeTask(String title) {
	    if (locked) {
            return null;
        }
		for (int i = 0; i < tasks.length; i++) {
			Task t = tasks[i];
			if (t != null && t.getTitle().equals(title)) {
				tasks[i] = null;
				count -= 1;
                if (t instanceof TaskList) {
                    ((TaskList) t).unlock();
                }
				return t;
			}
		}
		return null;
	}
		
	/** Helper */
	private boolean contains(String title) {
		for (Task t : tasks) {
			if (t != null && title.equals(t.getTitle()))
				return true;
		}
		return false;
	}
	
	/// =======================================================================
    ///  Part 2
    /// =======================================================================
	
    /**
     * Sets the "done" status for all tasks in all nested lists
     */
    @Override
    public void setDone(boolean done) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null ) {
                if (tasks[i] instanceof TaskList) {
                    try {
                        ((TaskList) tasks[i]).setDone(done);
                    }
                    catch (StackOverflowError e) {
                        
                    }
                }

                else {
                    tasks[i].setDone(done);
                }
                
            }
        }
    }

    /**
     * Returns true if all tasks in the nested lists are done, false otherwise
     */
    @Override
    public boolean isDone() {
        boolean help = true;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null ) {
                if (tasks[i] instanceof TaskList) {
                    try {

                        help = ((TaskList) tasks[i]).isDone();
                        
                    }
                    catch (StackOverflowError e) {
                        return help;
                    }
                }

                else {
                    if (!tasks[i].isDone()) {
                        help = false;
                    }  
                }
                
            }
        }
		return help; 
    }
	
    /**
     * Similar to addTask, with one difference:
     *
     * @param task
     * @return false (and operation does not succeed) if another task with the 
     *      same name exists in all lists
     */
    public boolean addStrictTask(Task task) {
        return true;
    }

    
    /**
     * String representation including all nested lists, see examples
     */
    @Override
    public String toString() {
        String s = getTitle() + ":[";
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null ) {
                if (tasks[i] instanceof TaskList) {
                    try {
                        if (i == tasks.length - 1) {
                            s = s + ((TaskList) tasks[i]).toString() + "]";
                        }
                        else {
                            s = s + ((TaskList) tasks[i]).toString() + ",";
                        }
                        
                    }
                    catch (StackOverflowError e) {
                        return s;
                    }
                }

                else {
                    if (tasks[i] instanceof TimedTask) {
                        if (i == tasks.length - 1) {
                            s = s + tasks[i].getTitle() + " (" + ((TimedTask) tasks[i]).getDeadline() + ")" + "]";
                        }
                        else {
                            s = s + tasks[i].getTitle() + " (" + ((TimedTask) tasks[i]).getDeadline() + ")" + ",";
                        }
                    }
                    else {
                        if (i == tasks.length - 1) {
                            s = s + tasks[i].getTitle() + "]";
                        }
                        else {
                            s = s + tasks[i].getTitle() + ",";
                        } 
                    }

                }
                
            }
        }
		return s; 
    }
}
