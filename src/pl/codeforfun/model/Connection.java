package pl.codeforfun.model;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;

import pl.codeforfun.dao.ShortParametersDao;

public class Connection {
	private String urlAddress;

	@Autowired
	ShortParametersDao shortParametersDao;
	
	/*
	 * Construcotr sets url address
	 * @param cityName - city name typed by user
	 * @param unique APPID - unique ID, it was geiven by data provider and allows ony 60 requests per minute. In case that limit will be exceeded access
	 * will be blocked/denied for some time
	 */
	public Connection(String urlAddress) {
		this.urlAddress = urlAddress;		
	}
	
	/*
	 * Metod responsible for obraining connection with given url addres
	 * TODO handle possible exception occurence : IOException, ProtocolException by some actions or logger
	 * @return InputStremReader object
	 */
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
			
		} catch (MalformedURLException e) {
//			e.printStackTrace();
		} catch(Exception e) {
//			e.printStackTrace();
		}
		return null;
	}
}
