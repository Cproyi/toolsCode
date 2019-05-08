package com.rmi.distance;

import java.util.ArrayList;
import java.util.List;

public class MapDistance {

	private static double EARTH_RADIUS = 6378.137;
	
	private static double rad(double d) { 
		return d * Math.PI / 180.0; 
	}
	
	public static void main(String[] args) {
		/*Double lat1 = 30.470476;
        Double lng1 = 114.321763;
        Double lat2 = 30.473861;
        Double lng2 = 119.325169;
          
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double difference = radLat1 - radLat2;
        double mdifference = rad(lng1) - rad(lng2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mdifference / 2), 2)));
        distance = distance * EARTH_RADIUS * 1000;
          
        System.out.println(distance<300*1.1);*/
		
		List<String> all = new ArrayList<>();
		
		all.addAll(null);
	}
	
}
