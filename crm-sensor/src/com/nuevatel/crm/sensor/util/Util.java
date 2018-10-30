package com.nuevatel.crm.sensor.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.nuevatel.crm.sensor.constant.Constant;
@SuppressWarnings("finally")
public class Util {

	public static final Timestamp toDate(String timeStamp) {
		Timestamp result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(timeStamp);
			result = new Timestamp(date.getTime());
		} catch (ParseException ex) {
			ex.printStackTrace();
		} finally {
			return result;
		}
	}

	public static final Timestamp queryMainWinStartDate() {
		Timestamp result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(theDayBefore()+" "+"06:00:00");
			result = new Timestamp(date.getTime());
		} catch (ParseException ex) {
			ex.printStackTrace();
		} finally {
			return result;
		}
	}	
	public static final Timestamp queryStartDate() {
		Timestamp result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(theDayBefore()+" "+"00:00:00");
			result = new Timestamp(date.getTime());
		} catch (ParseException ex) {
			ex.printStackTrace();
		} finally {
			return result;
		}
	}	
	
	public static final Timestamp queryEndDate() {
		Timestamp result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(theDayBefore()+" "+"23:59:59");
			result = new Timestamp(date.getTime());
		} catch (ParseException ex) {
			ex.printStackTrace();
		} finally {
			return result;
		}
	}	
	
	public static final Timestamp toDay() {
		Date toDay = new Date();
		Timestamp result = new Timestamp(toDay.getTime());
		return result;
	}

	public static final Timestamp endDay() {
		Timestamp result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = sdf.parse("31/12/3333 23:59:59");
			result = new Timestamp(date.getTime());
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static final String theDayBefore() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Date dateBefore = new Date(d.getTime() - 1 * 24 * 3600 * 1000l); // Subtract
																			// n=1
																			// days
		String result = sdf.format(dateBefore);
		return result;
	}
	public static final String sysdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Date dateToDay = new Date(d.getTime() ); // Subtract
																			// n=1
																			// days
		String result = sdf.format(dateToDay);
		return result;
	}

	public static Timestamp convertStringToTimestamp(String str_date) {
		try {
			DateFormat formatter;
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			// you can change format of date
			Date date = formatter.parse(str_date);
			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

			return timeStampDate;
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;
		}
	}
	
	public static boolean isWednesdayOrFriday(Timestamp currentDate) {
		boolean result = false;
		Calendar calendar = Calendar.getInstance(); // GregorianCalendar
		Date date = currentDate;
		calendar.setTime(date);
		int dayOfWeek =calendar.get(Calendar.DAY_OF_WEEK);
		if ((dayOfWeek == Constant.WEDNESDAY)||(dayOfWeek == Constant.FRIDAY)) {
			result = true;
		}
		return result;
	}	

}
