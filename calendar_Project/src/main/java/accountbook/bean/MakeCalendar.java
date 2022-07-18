package accountbook.bean;

import java.util.Calendar;

public class MakeCalendar {
	private int year;
	private int month;
	private int[] months;
	private int[] days;
	private final int totalDay = 42;
	
	public void makeDays(int year, int month) {
		Calendar sDay = Calendar.getInstance(); // 시작일
		Calendar eDay = Calendar.getInstance(); // 끝일
		
		sDay.set(year, month-1, 1); // 입력월의 1일로 설정
		eDay.set(year, month-1, sDay.getActualMaximum(Calendar.DATE)); // 입력월의 말일로 설정
		
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK)+1); // 1일이 속한 주의 일요일로 날짜 설정
		eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK)); // 말일이 속한 주의 토요일로 날짜 설정
		
		months = new int[totalDay];
		days = new int[totalDay];
		// sDay 와 eDay 사이의 day에 해당하는 숫자를 구하는 for문
		// sDay.before(eDay) || sDay.equals(eDay)
		for(int n = 0; n < totalDay; sDay.add(Calendar.DATE,1), n++) {
			month = sDay.get(Calendar.MONTH);
			int day = sDay.get(Calendar.DATE);
			months[n] = month;
			days[n] = day;
		}
	}
	
	// getter setter
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int[] getDays() {
		return days;
	}
	public int[] getMonths() {
		return months;
	}

}
