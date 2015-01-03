package com.sn.common.utils;

public class DateTimeUtils {

	public static int getYear(String date) {
		//2015/01/03
		return Integer.parseInt(date.split("/")[0]);
	}

	public static int getMonth(String date) {
		return Integer.parseInt(date.split("/")[1])-1;
	}

	public static int getDay(String date) {
		return Integer.parseInt(date.split("/")[2]);
	}

	public static int getHour(String time) {
		// 1:35 AM
		return Integer.parseInt(time.split(":")[0]);
	}

	public static int getMinute(String time) {
		String minuteStr = time.split(":")[1];
		String minuteArr[] = minuteStr.split(" ");
		int minute = Integer.parseInt(minuteArr[0]);
		if("PM".equals(minuteArr[1])){
			minute+=12;
		}
		return minute;
	}
}
