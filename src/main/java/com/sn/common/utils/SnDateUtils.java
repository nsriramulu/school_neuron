package com.sn.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SnDateUtils {

	public static String getCurrentTimeStamp() {
		DateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		  String timeStamp = format.format(new Date());
		  return timeStamp;
	}
}
