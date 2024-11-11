package Bsp10;

public class TimedTask extends Task {
	private Date deadline;

	public TimedTask(String title, Date deadline) {
		super(title);
		this.deadline = deadline;
	}

	public Date getDeadline() {
		return deadline;
	}

	public String toString() {
		return super.toString() + "@" + deadline;
	}
}
