package pl.codeforfun.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShortParameters {

	private double temp;
	private double tempAtNight;
	private long timeStamp;
	private String icon;
	private String description;
	private double windSpeed;
	private double windDeg;
	private double rain;
	
	/*
	 * 	To present full name of day in simpe day format please add EEEE
	 *	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm");
	 */
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm");
	

	public ShortParameters() {
		
	}
	
	public ShortParameters(long timeStamp, double temp, double tempAtNight, String description, String icon, double windSpeed, double windDeg, double rain) {
		this.timeStamp = timeStamp;
		this.temp = temp;
		this.tempAtNight = tempAtNight;
		this.description = description;
		this.icon = icon;
		this.windSpeed = windSpeed;
		this.windDeg = windDeg;
		this.rain = rain;
	}
	
	@Override
	public String toString() {
		return "ShortParameters [temp=" + temp + ",tempAtNight=" + tempAtNight+", timeStamp=" + timeStamp + ", icon=" + icon + ", description="
				+ description + ", windSpeed=" + windSpeed + ", windDeg=" + windDeg + ", rain=" + rain + "]";
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
	
	public String getRain(){
		return String.format("%.4f", rain);
	}
	
	public String getTempAtNight() {
		return String.format("%.2f",  tempAtNight);
	}
}
