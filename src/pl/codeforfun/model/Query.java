package pl.codeforfun.model;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.codeforfun.dao.ShortParameters;
import pl.codeforfun.dao.ShortParametersDao;

@Component
public class Query {
	
//	@Autowired
//	private ShortParametersDao shortParametersDao;
	ShortParametersDao shortParametersDao;
	
	
	String urlLink = "";
	
	public Query() {
// 		Lodz
//		urlLink = "http://api.openweathermap.org/data/2.5/forecast?id=3093133&APPID=e5ba0379f304cf74954037c2d9268da5";

//		Lubochnia		
		urlLink = "http://api.openweathermap.org/data/2.5/forecast?id=765863&APPID=e5ba0379f304cf74954037c2d9268da5";
	}
	
//	public Query(String urlLink) {
//		this.urlLink = urlLink;
//	}
	
	public WeatherForecast getConnection(InputStreamReader isr){
		try {
			shortParametersDao = new ShortParametersDao();
			
//			URL url = new URL(urlAddress);
//			URLConnection urlConnection = url.openConnection();
//			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlConnection;
//			
//			httpUrlConnection.setRequestMethod("GET");
//			httpUrlConnection.setRequestProperty("Accept", "application/json");
//			
//			if(httpUrlConnection.getResponseCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : " + httpUrlConnection.getResponseCode());
//			} 
			
			
			
			JsonReader jsonReader = Json.createReader(isr);
			JsonObject jsonObject = jsonReader.readObject();
			JsonObject cityObject = jsonObject.getJsonObject("city");
			JsonArray listObject =  jsonObject.getJsonArray("list");
			
			String cityName = cityObject.getString("name");
			String countryCode = cityObject.getString("country");	// jsonObject.getJsonObject("country").toString();
			
			
		
			
			for(int i=0; i< listObject.size(); i++) {
				long timeStamp = (long) listObject.getJsonObject(i).getInt("dt");
				JsonObject mainObject = listObject.getJsonObject(i).getJsonObject("main");
				JsonNumber dayAvgTempJson = mainObject.getJsonNumber("temp");
				double dayAvgTemp = dayAvgTempJson.doubleValue() - 273;
				
				JsonArray weatherJson = listObject.getJsonObject(i).getJsonArray("weather");			
				String description = weatherJson.getJsonObject(0).getString("description");				
				String icon =  weatherJson.getJsonObject(0).getString("icon");
				
				JsonObject windObject = listObject.getJsonObject(i).getJsonObject("wind");
				JsonNumber windSpeedJson = windObject.getJsonNumber("speed");
				double windSpeed = windSpeedJson.doubleValue();
				JsonNumber windDegJson = windObject.getJsonNumber("deg");
				double windDeg = windDegJson.doubleValue();
				
				JsonObject rainObject = listObject.getJsonObject(i).getJsonObject("rain");
				JsonNumber rainJson = null;
				double rain = 0;
				try{
					rainJson = rainObject.getJsonNumber("3h");
					rain = rainJson.doubleValue();
				} catch(NullPointerException npe) {
					rain = 0;
				}
				
				shortParametersDao.putElement(new ShortParameters(timeStamp, dayAvgTemp, 0, description, icon, windSpeed, windDeg, rain));
			}
			
			return new WeatherForecast(cityName, countryCode, shortParametersDao);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	
	
}
