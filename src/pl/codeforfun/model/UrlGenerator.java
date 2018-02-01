package pl.codeforfun.model;

import org.springframework.stereotype.Component;

@Component
public class UrlGenerator {
	private String urlAddress;
	private String uniqueAPPID = "e5ba0379f304cf74954037c2d9268da5";
	
	public UrlGenerator() {
		
	}
	
	public UrlGenerator(String urlAddress) {
		this.urlAddress = urlAddress;
	}
	
	public String getUrlAddress() {
		return "http://api.openweathermap.org/data/2.5/forecast?q=" + urlAddress + "&APPID="+uniqueAPPID;
	}
	
}
