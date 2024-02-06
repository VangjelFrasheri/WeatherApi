package com.oyd.weather.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static String getCurrentDateInMeteoFormat() {
		
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD'T'hh:mm:ss");  
	  
	   LocalDateTime today = LocalDateTime.now();
	   
	   //7PM to get weather at class time. Will eventually be passed in
	   today = today.withHour(19).withMinute(0);
	   
	   System.out.println(dtf.format(today));  
	   return dtf.format(today);
	}
	
	public static String getDateRangeInMeteoFormat(int numbOfDays) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DD'T'hh:mm:ss");
		LocalDateTime today = LocalDateTime.now().withHour(19).withMinute(0);
		LocalDateTime futureDate = LocalDateTime.now().plusDays(numbOfDays-1).withHour(19).withMinute(0);
		

		String todayString = today.toString();
		todayString = todayString.substring(0, todayString.length()-10);

		String futureDateString = futureDate.toString();
		futureDateString = futureDateString.substring(0, futureDateString.length()-10);

		
		String dateRangeFormatted = todayString + "Z--" + futureDateString + "Z";
		return dateRangeFormatted;
	}
}
