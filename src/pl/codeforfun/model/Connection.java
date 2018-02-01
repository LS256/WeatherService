package pl.codeforfun.model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;

import pl.codeforfun.dao.ShortParametersDao;

public class Connection {
	public String urlAddress;
	private String uniqueAPPID = "e5ba0379f304cf74954037c2d9268da5";
//	return "http://api.openweathermap.org/data/2.5/forecast?q=" + urlAddress + "&APPID="+uniqueAPPID;
	
	@Autowired
	ShortParametersDao shortParametersDao;
	
	
	public Connection(String urlAddress) {
		System.out.println("url: " + urlAddress);
		this.urlAddress = "http://api.openweathermap.org/data/2.5/forecast?q=" + urlAddress + "&APPID="+uniqueAPPID;
//		this.urlAddress = "http://api.openweathermap.org/data/2.5/forecast?q=Łódź&APPID="+uniqueAPPID;
		System.out.println("this url: " + this.urlAddress);
	}
	
	
	public InputStreamReader getConnection() {
		URL url = null;
		HttpURLConnection httpUrlConnection = null;
		URLConnection urlConnection = null;
		
		try {
	
			shortParametersDao = new ShortParametersDao();
			
			url = new URL(urlAddress);
			urlConnection = url.openConnection();
			httpUrlConnection = (HttpURLConnection) urlConnection;
			
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.setRequestProperty("Accept", "application/json");
			
			if(httpUrlConnection.getResponseCode() != 200) {
				return null;
			} 
			return new InputStreamReader(httpUrlConnection.getInputStream());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
