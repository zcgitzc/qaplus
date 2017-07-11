package com.qaplus.utils;

import java.util.Date;

public class Festival {
	private String name;
	private String date;
	private String startYear;
	private int rangeDays;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		Date festivalDate = SuperDate.parse(date,
				DateFormatPatterns.DATE_PATTERN_DEFAULT);
		int days = SuperDate.daysBetween(new Date(), festivalDate);
		this.rangeDays = days;
		this.date = date;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public int getRangeDays() {
		return rangeDays;
	}

	@Override
	public String toString() {
		return "Festival [name=" + name + ", date=" + date + ", startYear="
				+ startYear + ", rangeDays=" + rangeDays + "]";
	}

}
