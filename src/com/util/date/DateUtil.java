package com.util.date;

import java.text.Format.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static String[] weeks = new String[] {"日","一","二","三","四","五","六"};
	
	public static void getLastXMouth(int i){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -i);
		Date m = c.getTime();
		String mon = format.format(m);
		System.out.println("过去一个月："+mon);
	}
	
	public static Date getLastAndFirstDay(String time){
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(time != null) {
			time = "2019-02-20";
		}
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}
	
	public static String getXMinBefore(int x) {
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -1*x);
        Date zero = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(zero);
	}
	
	public static double formatDouble(double d) {
        return (double)Math.round(d*100)/100;
    }
	
	public static void getFromTo(String beginDate,String endDate) throws ParseException {
 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(beginDate));
 
		for (long d = cal.getTimeInMillis(); d <= sdf.parse(endDate).getTime(); d = get_D_Plaus_1(cal)) {
			System.out.println(sdf.format(d) + "    " + getDayOfWeek(d));
		}
 
	}

	private static String getDayOfWeek(long d) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(d);
		int index = c.get(Calendar.DAY_OF_WEEK) - 1;
		if(index < 0)
			index = 0;
		return weeks[index];
	}
 
	public static long get_D_Plaus_1(Calendar c) {
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
		return c.getTimeInMillis();
	}
	
	/**
	 * 现在时间是否在指定的日期内
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 * @throws ParseException 
	 */
	public static boolean nowIsInclude(String dateFrom, String dateTo) throws ParseException {
		Date now = new Date();
		Date from = getDateByStr(dateFrom,null);
		Date to = getDateByStr(dateTo, null);
		return now.compareTo(from)>=0 && now.compareTo(to)<=0;
	}
	
	public static Date getDateByStr(String date,String fmPattern) throws ParseException {
		if(isEmpty(fmPattern)) {
			fmPattern = "yyyy-MM-dd";
		}
		SimpleDateFormat format = new SimpleDateFormat(fmPattern);
		return format.parse(date);
	}
	
	public static String strByDate(Date date,String fmPattern) throws ParseException {
		if(isEmpty(fmPattern)) {
			fmPattern = "yyyy-MM-dd";
		}
		SimpleDateFormat format = new SimpleDateFormat(fmPattern);
		return format.format(date);
	}
	
	private static boolean isEmpty(String s) {
		return s == null || "".equals(s);
	}
	
	public static Date roll(String time,int i) throws ParseException {
		Calendar c = Calendar.getInstance();
		Date date = getDateByStr(time, "yyyy-MM-dd HH:mm");
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY)+i);
		return c.getTime();
	}
	
	public static Date getDayBeforeDate(String yestoday) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(getDateByStr(yestoday, "yyyy-MM-dd"));
		c.roll(Calendar.DATE, -1);
		return c.getTime();
	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println(roll("2019-05-06 09:00:00", -1));
		System.out.println(roll("2019-05-06 17:59:00", 6));
	}
}
