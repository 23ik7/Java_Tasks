package Bsp10;

public class Date {
	private final int d, m, y;

	private Date(int y, int m, int d) {
		this.d = d;
		this.m = m;
		this.y = y;
	}

	public static Date createDate(int year, int month, int day) {
		if (day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 2024 && year <= 9999) {
			return new Date(year, month, day);
		}
		return null;
	}

	public String toString() {
		return y + String.format("-%02d", m) + String.format("-%02d", d);
	}
}
