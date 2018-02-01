package pl.codeforfun.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShortParameters {

	private double temp;
	private long timeStamp;
	private String icon;
	private String description;
	private double windSpeed;
	private double windDeg;
	/*
	 * 	To present full name of day in simpe day format please add EEEE
	 *	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm");
	 */
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm");
	

	public ShortParameters() {
		
	}
	
	public ShortParameters(long timeStamp, double temp, String description, String icon, double windSpeed, double windDeg) {
		this.timeStamp = timeStamp;
		this.temp = temp;
		this.description = description;
		this.icon = icon;
		this.windSpeed = windSpeed;
		this.windDeg = windDeg;
	}
	
	@Override
	public String toString() {
		return "ShortParameters [temp=" + temp + ", timeStamp=" + timeStamp + ", icon=" + icon + ", description="
				+ description + ", windSpeed=" + windSpeed + ", windDeg=" + windDeg + ", sdf=" + sdf + "]";
	}

	/*
	 * Getters for defined variables
	 */


	public String getTimeStamp() {
		return sdf.format(new Date(timeStamp * 1000));
	}
	
	public String getTemp() {
		return String.format("%.1f",temp);
	}

	public String getDescription() {
		return description;
	}
	
	public String getIcon() {
		return "http://openweathermap.org/img/w/"+icon+".png";
	}
	
	public String getWindSpeed() {
		return String.format("%.2f", windSpeed);
	}
	
	public String getWindDeg() {
		return String.format("%.1f", windDeg);
	}
}