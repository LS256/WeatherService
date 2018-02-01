package pl.codeforfun.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.codeforfun.dao.ShortParametersDao;

@Component
public class WeatherForecast {
	
	@Autowired 
	ShortParametersDao shortParametersDao;
	
	private String cityName;
	private String countryCode;
//	private ShortParametersDao shortParametersDao;
	
	public WeatherForecast() {
		
	}

	public WeatherForecast(String cityName, String countryCode, ShortParametersDao shortParametersDao) {
		this.cityName = cityName;
		this.countryCode = countryCode;
		this.shortParametersDao = shortParametersDao;
	}

	@Override
	public String toString() {
		return "weatherSummary [cityName=" + cityName + ", countryCode=" + countryCode + ", shortParametersDao="+ shortParametersDao + "]";
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public ShortParametersDao getShortParametersDao() {
		return shortParametersDao;
	}
	
	public void setShortParametersDao(ShortParametersDao shortParametersDao) {
		this.shortParametersDao = shortParametersDao;
	}
	
	

}
