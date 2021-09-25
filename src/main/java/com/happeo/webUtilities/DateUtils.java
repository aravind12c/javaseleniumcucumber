package com.happeo.webUtilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

	public static String fetchSpecifics(String dates, String key) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

		String returnvalue = null;
		try {
			Date date = formatter.parse(dates);
			if (key.equalsIgnoreCase("month")) {
				formatter = new SimpleDateFormat("MMM");
				returnvalue = formatter.format(date);
			} else if (key.equalsIgnoreCase("day")) {
				formatter = new SimpleDateFormat("dd");
				returnvalue = formatter.format(date);
			} else if (key.equalsIgnoreCase("year")) {
				formatter = new SimpleDateFormat("yyyy");
				returnvalue = formatter.format(date);
			} else {
				returnvalue = formatter.format(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return returnvalue;
	}

	public static String getMonth(String month) {
		String completemonth = null;
		switch (month) {
		case "JAN":
			completemonth = "January";
		case "FEB":
			completemonth = "February";
		case "MAR":
			completemonth = "March";
		case "APR":
			completemonth = "April";
		case "MAY":
			completemonth = "May";
		case "JUN":
			completemonth = "June";
		case "JUL":
			completemonth = "July";
		case "AUG":
			completemonth = "August";
		case "SEP":
			completemonth = "September";
		case "OCT":
			completemonth = "October";
		case "NOV":
			completemonth = "November";
		case "DEC":
			completemonth = "December";

		}
		return completemonth;
	}

	public static String dateAddition(int noOfDays) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		Calendar calendar = Calendar.getInstance();

		String returnvalue = null;
		try {
			Date date = formatter.parse(formatter.format(Calendar.getInstance().getTime()));
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
			returnvalue = formatter.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return returnvalue;
	}

}
