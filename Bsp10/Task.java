package Bsp10;

public class Task {
	private String title;
	private boolean done;
	
	public Task(String title) {
		this.title=title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setDone(boolean done) {
		this.done=done;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public String toString() {
		return title;
	}


    // Ignore this. It’s only here for the tests to work properly.
    protected Task() {}
}
