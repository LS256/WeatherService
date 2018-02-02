package pl.codeforfun.model;

import org.springframework.stereotype.Component;

@Component
public class UrlGenerator {
	private String urlAddress;
	private String uniqueAPPID = "e5ba0379f304cf74954037c2d9268da5";
	
	public UrlGenerator() {
		
	}
	
	public void setUrlAddress(String urlAddress, String weatherType) {
		if(weatherType.equals("longTerm")){
			this.urlAddress = "http://api.openweathermap.org/data/2.5/forecast/daily?q=" + urlAddress + "&cnt=17&APPID="+uniqueAPPID;
		} else {
			this.urlAddress = "http://api.openweathermap.org/data/2.5/forecast?q=" + urlAddress + "&APPID="+uniqueAPPID;
		}
	}
	
	public String getUrlAddress() {
		return this.urlAddress;
	}
	
	@Override
	public String toString() {
		return this.urlAddress;
	}
	
}
