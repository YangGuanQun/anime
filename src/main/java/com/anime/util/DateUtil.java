package com.anime.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class DateUtil {
	
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	public static String dateToString(Date date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
	
	public static String dateToSmartString(Date date) {
		String clockPattern = "HH:mm";
		String dayPattern = "yyyy-MM-dd";
		Date today = new Date();
		Date yesterday = DateUtils.addDays(today, -1);
		String clock = new SimpleDateFormat(clockPattern).format(date);
		DateFormat df = new SimpleDateFormat(dayPattern);
		String day = df.format(date);
		if (df.format(date).equals(df.format(today))) {
			day = "今天";
		}
		if (df.format(date).equals(df.format(yesterday))) {
			day = "昨天";
		}
		return day + " " + clock;
	}
}
