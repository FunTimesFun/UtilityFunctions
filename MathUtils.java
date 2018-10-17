package com.channellogistics.utils;

import java.util.Calendar;

/**
 * Various mathematical functions dealing with geospatial calculations
 * @author sposerina
 *
 */
public class MathUtils 
{
	//Equatorial radius in kilometers
	public static final double EQUATORIAL_RADIUS = 6378137.0;
	
	/**
	 * 
	 * @param latA
	 * @param lonA
	 * @param latB
	 * @param lonB
	 * @return
	 */
	public static double sphericalDistanceRadians(double latA, double lonA, double latB, double lonB)
	{
		double radLatA = Math.toRadians(latA);
		double radLatB = Math.toRadians(latB);
		double radLonA = Math.toRadians(lonA);
		double radLonB = Math.toRadians(lonB);
		
		return Math.acos(Math.cos(radLatA) * Math.cos(radLatB) * Math.cos(radLonA-radLonB) + Math.sin(radLatA)*
				Math.sin(radLatB));
	}
	
	/**
	 * 
	 * @param time the time to be compared against the bounds
	 * @param startHr beginning hour bounds
	 * @param endHr end hour bounds
	 * @param startMin start minute bounds
	 * @param endMin end minute bounds
	 * @return true if the given time lies within the bounds
	 */
	public static boolean withinTimeInterval(long time, int startHr, int endHr, int startMin, int endMin)
	{
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time);
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int amPm = c.get(Calendar.AM_PM);
		
		if(amPm == Calendar.PM)
		{
			hour += 12;
		}
		
		if(((startHr == hour && minute > startMin) || hour > startHr)  
		   && ((endHr == hour && endMin < minute) || hour < endHr))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static String convertRadiansToString(float latitude) {
		String retValue = "";
		
		retValue = (latitude > 0 ? "N":"S");
		int hours = (int)Math.floor(latitude);
		latitude = latitude - (float)Math.floor(latitude);
		int minutes = (int)Math.floor(latitude/(1/60f));
		latitude = latitude - (minutes* (1/60f));
		int seconds = Math.round(latitude/(1/3600f));

		// This code is for rounding errors. If the seconds rounds
		// up to 60, then add a minute and remove the seconds. If this in turn
		// adds up to 60 minutes set minutes to 0 and add an hour.
		if (seconds==60) {
			seconds = 0;
			minutes++;
			if (minutes==60) {
				minutes = 0;
				hours++;
			}
		}
		retValue += hours;
		retValue += minutes;
		retValue += seconds;
		return retValue;

	}
	
	public static double approxDistance(Double lat1, Double lon1, Double lat2, Double lon2 )
	{
		// The equatorial radius of the earth in meters * the angular distance 
		// between the two points.
		double distance = 6378137 * approxAngularDistance(lat1,lon1,lat2,lon2);
		return distance;
	}
	private static double approxAngularDistance(Double lat1, Double lon1, Double lat2, Double lon2 )
	{
		// angular distance = 2 * ASin(Sqrt(Sin((lat2 - lat1)/2)^2 + Cos(lat1) * Cos(lat2) + Cos((lon2 - lon1)/2)^2))
		// Convert values from degrees to radians
		double dlon = Math.toRadians(lon2) - Math.toRadians(lon1);
		double dlat = Math.toRadians(lat2) - Math.toRadians(lat1);
		double k = Math.sin(dlat*0.5);
		double l = Math.sin(dlon*0.5);
		double a = k*k + Math.cos(Math.toRadians(lat1)) * 
					Math.cos(Math.toRadians(lat2)) * l*l;
		double c = 2 * Math.asin(Math.min(1,Math.sqrt(a)));
		return c;
	}
	
	public static boolean validateLatitude(float latitude) {
		if (latitude >= -90 && latitude <= 90) {
			return true;
		}
		return false;
	}
	public static boolean validateLongitude(float longitude) {
		if (longitude >= -180 && longitude <= 180) {
			return true;
		}
		return false;
	}
}
