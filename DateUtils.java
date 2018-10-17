package com.channellogistics.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 
 * @author bbaker
 *
 */
public class DateUtils {
	private static final Logger log = Logger.getLogger(DateUtils.class);
	
    //private static final DateFormat SDF_YMD_NO_LENIENT;
	
	private static final String STR_YYYYMM = "yyyyMM";
    
    private static final String STR_YMD_NO_LENIENT = "yyyy-MM-dd";
    
    private static final String STR_DMMMY_NO_LENIENT = "dd-MMM-yy";
    
    private static final String STR_DMY_NO_LENIENT = "dd/MM/yyyy";
    
    private static final String STR_MDY_NO_LENIENT = "MM/dd/yyyy";
    
    private static final String STR_ISO_DATETIME_FORMAT_NO_LENIENT = "yyyy-MM-dd'T'HH:mm:ss";
    
    private static final String STR_MMMDDYYYY_HHMMSS_AMPM = "MMM dd yyyy hh:mm:ss.SSS aa";
    
    private static final String STR_MMMDDYYYY_HHMM = "MMM dd yyyy hh:mm:ss.SSS aa";
    
    private static final String STR_MDY_HHMMSS_AMPM = "MM/dd/yyyy hh:mm:ss aa";
    
    private static final String STR_HHMMSS = "k:mm:ss";
    
    private static final String STR_MMYYYY = "MMM-yyyy";
    
    private static final String STR_YYYYMMDD = "yyyyMMdd";
    
    private static final String STR_YYYY = "yyyy";
    
    private static final String STR_YYYY_M_DD = "yyyy,M,dd"; 
    
    private static final String STR_DD_MM_HH_MM = "dd-MM HH:mm";
    
    private static final String STR_DD_MM_YYYY_HH_MMAA = "dd/MM/yyyy hh:mmaa";
    
    private static final String STR_MM_DD_YYYY_HH_MM = "dd/MM/yyyy HH:mm";
    
    private static final String STR_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    
    private static final String STR_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    
    private static String STR_DEFAULT_DATE = "MM/dd/yyyy";
    
    private static String STR_DEFAULT_TIME = "HH:mm";
    
    private static String STR_DEFAULT_DATE_TIME = "MM/dd/yyyy HH:mm";
    
    private static Calendar calCompareBefore = Calendar.getInstance();
	private static Calendar calCompareAfter = Calendar.getInstance();
	
	// static initializer block
	{
		DateUtils.clearValues(calCompareBefore);
		DateUtils.clearValues(calCompareAfter);
	}
	
    public static void setDateFormat(String dateFormat) {
    	STR_DEFAULT_DATE = dateFormat;
    }
    
    public static void setTimeFormat(String timeFormat) {
    	STR_DEFAULT_TIME = timeFormat;
    	
    }
    
    public static void setDateTimeFormat(String dateTimeFormat) {
    	STR_DEFAULT_DATE_TIME = dateTimeFormat;
    	
    }
    	
	public static SimpleDateFormat getSDF_DEFAULT_DATE() {
		SimpleDateFormat SDF_DEFAULT_DATE = new SimpleDateFormat(STR_DEFAULT_DATE);
		SDF_DEFAULT_DATE.setLenient(false);

		return SDF_DEFAULT_DATE;
	}
	
	public static DateFormat getSDF_DEFAULT_TIME() {
		DateFormat SDF_DEFAULT_TIME = new SimpleDateFormat(STR_DEFAULT_TIME);
		SDF_DEFAULT_TIME.setLenient(false);
		return SDF_DEFAULT_TIME;
	}
	
	public static DateFormat getSDF_DEFAULT_DATE_TIME() {
		DateFormat SDF_DEFAULT_DATE_TIME = new SimpleDateFormat(STR_DEFAULT_DATE_TIME);
		SDF_DEFAULT_DATE_TIME.setLenient(false);
		return SDF_DEFAULT_DATE_TIME;
	}
	
	
	/**
	 * This helper method returns an instance of DateFormat 
	 * 	with syntax: yyyy-MM-dd
	 * Example: 2001-06-23 (June 23, 2001)
	 */
	public static DateFormat getDateFormatYMDNoLenient() {
		DateFormat SDF_YMD_NO_LENIENT = new SimpleDateFormat(STR_YMD_NO_LENIENT);
		SDF_YMD_NO_LENIENT.setLenient(false);
		return SDF_YMD_NO_LENIENT;
	}

	/**
	 * This helper method returns an instance of DateFormat 
	 * 	with syntax: dd-MMM-yy
	 * Example: 31-MAR-03 (March 31, 2003)
	 */
	public static DateFormat getDateFormatDMMMYNoLenient() {
		
		DateFormat SDF_DMMMY_NO_LENIENT = new SimpleDateFormat(STR_DMMMY_NO_LENIENT);
		SDF_DMMMY_NO_LENIENT.setLenient(false);
		return SDF_DMMMY_NO_LENIENT;
	}
	
	/**
	 * This helper method returns an instance of DateFormat 
	 * 	with syntax: dd-MMM-yy
	 * Example: 26/06/2004 (June 26, 2004)
	 */
	public static DateFormat getDateFormatDMYNoLenient() {
		
		DateFormat SDF_DMY_NO_LENIENT = new SimpleDateFormat(STR_DMY_NO_LENIENT);
		SDF_DMY_NO_LENIENT.setLenient(false);
		return SDF_DMY_NO_LENIENT;
	}
	
	/**
	 * This helper method returns an instance of DateFormat 
	 * 	with syntax: MM/dd/yyyy
	 * Example: 05/12/2002 (May 12, 2002)
	 */
	public static DateFormat getDateFormatMDYNoLenient() {

		DateFormat SDF_MDY_NO_LENIENT = new SimpleDateFormat(STR_MDY_NO_LENIENT);
		SDF_MDY_NO_LENIENT.setLenient(false);
		return SDF_MDY_NO_LENIENT;
	}

	public static DateFormat getIsoDatetimeFormatNoLenient() {
		DateFormat SDF_ISO_DATETIME_FORMAT_NO_LENIENT = new SimpleDateFormat(STR_ISO_DATETIME_FORMAT_NO_LENIENT);
		SDF_ISO_DATETIME_FORMAT_NO_LENIENT.setLenient(false);
		return SDF_ISO_DATETIME_FORMAT_NO_LENIENT;
	}
	
	public static DateFormat getSDF_MMMDDYYYY_HHMMSS_AMPM() {
		DateFormat SDF_MMMDDYYYY_HHMMSS_AMPM = new SimpleDateFormat(STR_MMMDDYYYY_HHMMSS_AMPM);
		SDF_MMMDDYYYY_HHMMSS_AMPM.setLenient(false);
		return SDF_MMMDDYYYY_HHMMSS_AMPM;
	}
	
	public static DateFormat getSDF_MDY_HHMMSS_AMPM() {
		DateFormat SDF_MDY_HHMMSS_AMPM = new SimpleDateFormat(STR_MDY_HHMMSS_AMPM);
		SDF_MDY_HHMMSS_AMPM.setLenient(false);
		return SDF_MDY_HHMMSS_AMPM;
	}
	
	public static DateFormat getSDF_HHMMSS() {
		DateFormat SDF_HHMMSS = new SimpleDateFormat(STR_HHMMSS);
		SDF_HHMMSS.setLenient(false);
		return SDF_HHMMSS;
	}
	
	public static DateFormat getSDF_MMYYYY() {
		DateFormat SDF_MMYYYY = new SimpleDateFormat(STR_MMYYYY);
		SDF_MMYYYY.setLenient(false);
		return SDF_MMYYYY;
	}
	
	public static DateFormat getSDF_YYYYMMDD() {
		DateFormat SDF_YYYYMMDD = new SimpleDateFormat(STR_YYYYMMDD);
		SDF_YYYYMMDD.setLenient(false);
		return SDF_YYYYMMDD;
	}
	
	public static DateFormat getSDF_YYYY() {
		DateFormat SDF_YYYY = new SimpleDateFormat(STR_YYYY);
		SDF_YYYY.setLenient(false);
		return SDF_YYYY;
	}
	
	public static DateFormat getSDF_MMMDDYYYY_HHMM() {
		DateFormat SDF_MMMDDYYYY_HHMM = new SimpleDateFormat(STR_MMMDDYYYY_HHMM);
		SDF_MMMDDYYYY_HHMM.setLenient(false);
		return SDF_MMMDDYYYY_HHMM;
	}
	
	public static DateFormat getSDF_YYYY_M_DD() {
		DateFormat SDF_YYYY_M_DD = new SimpleDateFormat(STR_YYYY_M_DD);
		SDF_YYYY_M_DD.setLenient(false);
		return SDF_YYYY_M_DD;
	}
	
	public static DateFormat getSDF_DD_MM_YYYY_HH_MMAA() {
		DateFormat SDF_DD_MM_YYYY_HH_MMAA = new SimpleDateFormat(STR_DD_MM_YYYY_HH_MMAA);
		SDF_DD_MM_YYYY_HH_MMAA.setLenient(false);
		return SDF_DD_MM_YYYY_HH_MMAA;
	}
	
	public static DateFormat getSDF_YYYY_MM_DD_HH_MM_SS() {
		DateFormat SDF_YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat(STR_YYYY_MM_DD_HH_MM_SS);
		SDF_YYYY_MM_DD_HH_MM_SS.setLenient(false);
		return SDF_YYYY_MM_DD_HH_MM_SS;
	}
	
	public static DateFormat getSDF_DDMMYYYY_HHMM() {
		DateFormat SDF_DDMMYYYY_HHMM = new SimpleDateFormat(STR_MM_DD_YYYY_HH_MM);
		SDF_DDMMYYYY_HHMM.setLenient(false);
		return SDF_DDMMYYYY_HHMM;
	}
	
	public static DateFormat getSDF_YYYY_MM_DD_HH_MM_SS_SSS() {
		DateFormat SDF_YYYY_MM_DD_HH_MM_SS_SSS = new SimpleDateFormat(STR_YYYY_MM_DD_HH_MM_SS_SSS);
		SDF_YYYY_MM_DD_HH_MM_SS_SSS.setLenient(false);
		return SDF_YYYY_MM_DD_HH_MM_SS_SSS;
	}
	
	public static DateFormat getSDF_STR_YYYYMM() {
		DateFormat SDF_STR_YYYYMM = new SimpleDateFormat(STR_YYYYMM);
		SDF_STR_YYYYMM.setLenient(false);
		return SDF_STR_YYYYMM;
	}
	
	public static DateFormat getSTR_DD_MM_HH_MM() {
		DateFormat SDF_STR_DD_MM_HH_MM = new SimpleDateFormat(STR_DD_MM_HH_MM);
		SDF_STR_DD_MM_HH_MM.setLenient(false);
		return SDF_STR_DD_MM_HH_MM;
	}
	
	public static String formatDateByDefaultValue(Date date) {
		String retThis = "";
		if (date != null) {
			retThis = getSDF_DEFAULT_DATE().format(date);	
		}
		return retThis;
		
	}
	
	public static String formatDateByDefaultValue(Calendar cal) {
		String retThis = "";
		if (cal != null) {
			retThis = getSDF_DEFAULT_DATE().format(cal.getTime());	
		}
		return retThis;
		
	}
	
	public static String formatDateTimeByDefaultValue(Calendar cal) {
		String retThis = "";
		if (cal != null) {
			retThis = getDateFormatYMDNoLenient().format(cal.getTime());	
		}
		return retThis;
		
	}
	
	public static String formatDateTimeByDefaultValue(Date date) {
		String retThis = "";
		if (date != null) {
			retThis = getDateFormatYMDNoLenient().format(date);
		}
		return retThis;
	}
	
	public static String formatTimeByDefaultValue(Calendar cal) {
		String retThis = "";
		if (cal != null) {
			retThis = getSDF_DEFAULT_TIME().format(cal.getTime());	
		}
		return retThis;		
	}
	
	public static String formatTimeByDefaultValue(Date date)  {
		String retThis = "";
		if (date != null) {
			retThis = getSDF_DEFAULT_TIME().format(date);
		}
		return retThis;	
	}
	
	// TAIS Extended Data with Year Calculation Logic
	// 00-00 00:00
	// 01-02 03:00
	// 01-02 03:00
	// 18-08 20:00
	public static Calendar getCalendarFromStringDDMMHHMM(String ddmmhhmm) throws ParseException {
		Calendar calEta = Calendar.getInstance();
		Calendar calNow = Calendar.getInstance();
		int yr = calNow.get(Calendar.YEAR);
		clearValuesHHMMSS(calNow);
		calEta.setTime(getSTR_DD_MM_HH_MM().parse(ddmmhhmm));
		calEta.set(Calendar.YEAR, yr);
		calNow.add(Calendar.DATE,  -28);
		if (calNow.after(calEta)) {
			calEta.add(Calendar.YEAR, 1);
		}
		return calEta;
	}
	
	
	
	// 2014-01-20 00:00:00
	public static java.sql.Date getSQLDateFromStringDDMMYYYY_HHMM(String ddmmyyyy_hhmm) throws ParseException {
		java.sql.Date sqlDate = null;
		if (StringUtils.trimWithNull(ddmmyyyy_hhmm).length() > 0) {
			Date dt = getDateFromStringDDMMYYYY_HHMM(ddmmyyyy_hhmm);
			
			if (dt != null) {
				sqlDate = new java.sql.Date(dt.getTime());
			}	
		}
		return sqlDate;
	}
	
	// 2014-01-20 00:00:00
		public static java.sql.Date getSQLDateFromStringYYYYMMDD_HHMMSS(String yyyymmdd_hhmmss) throws ParseException {
			java.sql.Date sqlDate = null;
			if (StringUtils.trimWithNull(yyyymmdd_hhmmss).length() > 0) {
				Date dt = getDateFromStringYYYYMMDD_HHMMSS(yyyymmdd_hhmmss);
				
				if (dt != null) {
					sqlDate = new java.sql.Date(dt.getTime());
				}	
			}
			return sqlDate;
		}
		
	// 2014-01-20 00:00:00
	public static Date getDateFromStringYYYYMMDD_HHMMSS(String yyyymmdd_hhmmss) throws ParseException {
		Date dt = getSDF_YYYY_MM_DD_HH_MM_SS().parse(yyyymmdd_hhmmss);
		return dt;
	}
	
	// 2014-01-20 00:00:00
	public static Date getDateFromStringDDMMYYYY_HHMM(String ddmmyyyy_hhmm) throws ParseException {
		Date dt = getSDF_DDMMYYYY_HHMM().parse(ddmmyyyy_hhmm);
		return dt;
	}
	
	// 2014-01-20 00:00:00
	public static Calendar getCalendarFromStringYYYYMMDD_HHMMSS(String yyyymmdd_hhmmss) throws ParseException {
		Calendar calDate = null;
		
		Date dt = getDateFromStringYYYYMMDD_HHMMSS(yyyymmdd_hhmmss);
		if (dt != null) {
			calDate = Calendar.getInstance();
			calDate.setTime(dt);
		}
		if (validSQLDate(calDate) == false) {
			calDate = null;
		}
		return calDate;
	}
	
	// 2016
	public static java.sql.Date getSQLDateFromStringYYYY(String yyyy) {
		java.sql.Date sqlDate = null;
		Date date = getDateFromStringYYYY(yyyy);
		if (date != null) {
			sqlDate = new java.sql.Date(date.getTime());
		}		
		return sqlDate;
	}
		

	// 042016
	// 04132016
	public static java.sql.Date getSQLDateFromStringMMYYYY_MMDDYYYY(String mmyyyy) {
		java.sql.Date sqlDate = null;
		Date date = getDateFromStringMMYYYY_MMDDYYYY(mmyyyy);
		if (date != null) {
			sqlDate = new java.sql.Date(date.getTime());
		}
			
		return sqlDate;
	}
	
	// 052004
	// 28052004
	public static java.sql.Date getSQLDateFromStringMMYYYY_DDMMYYYY(String mmyyyy) {
		java.sql.Date sqlDate = null;
		Date date = getDateFromStringMMYYYY_DDMMYYYY(mmyyyy);
		if (date != null) {
			sqlDate = new java.sql.Date(date.getTime());
		}				
		return sqlDate;
	}
	
	// 2018
	public static Date getDateFromStringYYYY(String yyyy) {
		Date date = null;
		Calendar calDate = getCalendarFromStringYYYY(yyyy);
		if (calDate != null) {
			date = calDate.getTime();
		}
		
		return date;
	}
	
	// 042016
	// 04132016
	public static Date getDateFromStringMMYYYY_MMDDYYYY(String mmyyyy) {
		Date date = null;
		Calendar calDate = getCalendarFromStringMMYYYY_MMDDYYYY(mmyyyy);
		if (calDate != null) {
			date = calDate.getTime();
		}
		
		return date;
	}
	
	// 042016
	// 13042016
	public static Date getDateFromStringMMYYYY_DDMMYYYY(String mmyyyy) {
		Date date = null;
		Calendar calDate = getCalendarFromStringMMYYYY_DDMMYYYY(mmyyyy);
		if (calDate != null) {
			date = calDate.getTime();
		}
		return date;
	}
	
	// 2016
	public static Calendar getCalendarFromStringYYYY(String yyyy) {
		Calendar calDate = null;
		String parseThis = StringUtils.trimWithNull(yyyy);
		if (parseThis.length() == 4) {
			int buildDate = 1;
		    int buildMonth = 0;
			int buildYear = Integer.parseInt(parseThis);
				
			calDate = Calendar.getInstance();
			calDate.set(Calendar.MONTH, buildMonth);
			calDate.set(Calendar.DAY_OF_MONTH, buildDate);
			calDate.set(Calendar.YEAR, buildYear);
		}
			
		if (validSQLDate(calDate) == false) {
			calDate = null;
		}
		return calDate;
	}
		
	
	// 042016
	// 04132016
	public static Calendar getCalendarFromStringMMYYYY_MMDDYYYY(String mmyyyy) {
		Calendar calDate = null;
		String parseThis = StringUtils.trimWithNull(mmyyyy);
		if (parseThis.length() == 6) {
			int buildDate = 1;
		    int buildMonth = Integer.parseInt(parseThis.substring(0, 2));
			int buildYear = Integer.parseInt(parseThis.substring(2, 6));
			if (buildMonth > 12) {
			    buildMonth = 0;
			}
				
			if (buildMonth > 0) {
			    buildMonth--;
			}
				
			calDate = Calendar.getInstance();
			calDate.set(Calendar.MONTH, buildMonth);
			calDate.set(Calendar.DAY_OF_MONTH, buildDate);
			calDate.set(Calendar.YEAR, buildYear);
		}
		else if (parseThis.length() == 8) {
			int buildMonth = Integer.parseInt(parseThis.substring(0, 2));
		    int buildDate = Integer.parseInt(parseThis.substring(2, 4));
			int buildYear = Integer.parseInt(parseThis.substring(4, 8));
			if (buildMonth > 12) {
			    buildMonth = 0;
			}
				
			if (buildMonth > 0) {
			    buildMonth--;
			}
			if (buildDate == 0) {
				buildDate = 1;
			}
			calDate = Calendar.getInstance();
			calDate.set(Calendar.MONTH, buildMonth);
			calDate.set(Calendar.DAY_OF_MONTH, buildDate);
			calDate.set(Calendar.YEAR, buildYear);
		}
		
		if (validSQLDate(calDate) == false) {
			calDate = null;
		}
		return calDate;
	}
	
	// 042016
	// 13042016
	public static Calendar getCalendarFromStringMMYYYY_DDMMYYYY(String mmyyyy) {
		Calendar calDate = null;
		String parseThis = StringUtils.trimWithNull(mmyyyy);
		if (parseThis.length() == 6) {
			int buildDate = 1;
		    int buildMonth = Integer.parseInt(parseThis.substring(0, 2));
			int buildYear = Integer.parseInt(parseThis.substring(2, 6));
			if (buildMonth > 12) {
			    buildMonth = 0;
			}
				
			if (buildMonth > 0) {
			    buildMonth--;
			}
				
			calDate = Calendar.getInstance();
			calDate.set(Calendar.MONTH, buildMonth);
			calDate.set(Calendar.DAY_OF_MONTH, buildDate);
			calDate.set(Calendar.YEAR, buildYear);
		}
		else if (parseThis.length() == 8) {
			int buildDate = Integer.parseInt(parseThis.substring(0, 2));
		    int buildMonth = Integer.parseInt(parseThis.substring(2, 4));
			int buildYear = Integer.parseInt(parseThis.substring(4, 8));
			if (buildMonth > 12) {
			    buildMonth = 0;
			}
				
			if (buildMonth > 0) {
			    buildMonth--;
			}
			if (buildDate == 0) {
				buildDate = 1;
			}
			calDate = Calendar.getInstance();
			calDate.set(Calendar.MONTH, buildMonth);
			calDate.set(Calendar.DAY_OF_MONTH, buildDate);
			calDate.set(Calendar.YEAR, buildYear);
		}
		
		if (validSQLDate(calDate) == false) {
			calDate = null;
		}
		return calDate;
	}
	
	// 042016
	// 04132016
	public static Calendar getCalendarFromSQLDate(java.sql.Date date) {
		Calendar calDate = null;
		if (date != null) {
			calDate = Calendar.getInstance();
			calDate.setTime(date);
		}
		if (validSQLDate(calDate) == false) {
			calDate = null;
		}
		return calDate;
	}
	
	
	
	// 24-DEC-15
	public static java.sql.Date getSQLDateFromString_DDDASHMONDASHYY(String dddashmondashyy) {
		Date date = getDateFromString_DDDASHMONDASHYY(dddashmondashyy);
		java.sql.Date sqlDate = null;
		
		if (date != null) {
			sqlDate = new java.sql.Date(date.getTime());
		}
		return sqlDate;
	}
	
	// 20160420
	// 201604
	public static java.sql.Date getSQLDateFromString_YYYYMMDD_YYYYMM(String yyyymmdd_yyyymm) {
		Date date = getDateFromString_YYYYMMDD_YYYYMM(yyyymmdd_yyyymm);
		java.sql.Date sqlDate = null;
		
		if (date != null) {
			sqlDate = new java.sql.Date(date.getTime());
		}
		return sqlDate;
	}
	
	
	
	// 27-MAY-18
	public static Date getDateFromString_DDDASHMONDASHYY(String dddashmondashyy) {
		Calendar calDate = getCalendarFromString_DDDASHMONDASHYY(dddashmondashyy);
		Date date = null;
		if (calDate != null) {
			date = calDate.getTime();
		}
		return date;
	}

	// 20160420
	// 201604
	public static Date getDateFromString_YYYYMMDD_YYYYMM(String yyyymmdd_yyyymm) {
		Calendar calDate = getCalendarFromString_YYYYMMDD_YYYYMM(yyyymmdd_yyyymm);
		Date date = null;
		if (calDate != null) {
			date = calDate.getTime();
		}
		return date;
	}
	
	// 27-MAY-18
	public static Calendar getCalendarFromString_DDDASHMONDASHYY(String dddashmondashyy) {
		Calendar calDate = null;
		try {
			java.util.Date date = DateUtils.getDateFormatDMMMYNoLenient().parse(dddashmondashyy);
			if (date != null) {
				calDate = Calendar.getInstance();
				calDate.setTime(date);
			}
		}
		catch (ParseException e) {
			log.error("ParseException: " + e.getMessage(), e);
		}
		
		return calDate;
	}
	
	// 20160420
	// 201604
	public static Calendar getCalendarFromString_YYYYMMDD_YYYYMM(String yyyymmdd_yyyymm) {
		Calendar calDate = null;
		String parseThis = StringUtils.trimWithNull(yyyymmdd_yyyymm);
		if (parseThis.length() == 8) {
			int buildYear = Integer.parseInt(parseThis.substring(0, 4));
			int buildMonth = Integer.parseInt(parseThis.substring(4, 6));
			int buildDate = Integer.parseInt(parseThis.substring(6, 8));
			
			if (buildMonth > 12) {
			    buildMonth = 0;
			}
				
			if (buildMonth > 0) {
			    buildMonth--;
			}
				
			calDate = Calendar.getInstance();
			calDate.set(Calendar.MONTH, buildMonth);
			calDate.set(Calendar.DAY_OF_MONTH, buildDate);
			calDate.set(Calendar.YEAR, buildYear);
		}
		else if (parseThis.length() == 6) {
			int buildYear = Integer.parseInt(parseThis.substring(0, 4));
		    int buildMonth = Integer.parseInt(parseThis.substring(4, 6));
			
			if (buildMonth > 12) {
			    buildMonth = 0;
			}
				
			if (buildMonth > 0) {
			    buildMonth--;
			}
			int buildDate = 1;
				
			calDate = Calendar.getInstance();
			calDate.set(Calendar.MONTH, buildMonth);
			calDate.set(Calendar.DAY_OF_MONTH, buildDate);
			calDate.set(Calendar.YEAR, buildYear);
		}
		if (validSQLDate(calDate) == false) {
			calDate = null;
		}
		return calDate;
	}
	
	public static boolean validSQLDate(Calendar cal) {
		
		
		calCompareBefore.set(Calendar.YEAR, 1753);
		calCompareBefore.set(Calendar.MONTH, 0);
		calCompareBefore.set(Calendar. DATE, 1); 
		
		calCompareAfter.set(Calendar.YEAR, 9999);
		calCompareAfter.set(Calendar.MONTH, 11);
		calCompareAfter.set(Calendar. DATE, 31); 
		
		if (cal == null) {
			return false;
		}
		if (cal.before(calCompareBefore) || cal.after(calCompareAfter)) {
			return false;
		}
		return true;
	}
	
	public static Calendar clearValues(Calendar cal) {
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.YEAR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}
	
	public static Calendar clearValuesHHMMSS(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}
	
	
}
