package pl.codeforfun.model;

import java.io.InputStreamReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.stereotype.Component;

import pl.codeforfun.dao.ShortParameters;
import pl.codeforfun.dao.ShortParametersDao;

@Component
public class Query16 {
	
//	@Autowired
//	private ShortParametersDao shortParametersDao;
	ShortParametersDao shortParametersDao;
	
	
	String urlLink = "";
	
	/**
	 * TODO constuctor is useless - delete content
	 */
	public Query16() {
// 		Lodz
//		urlLink = "http://api.openweathermap.org/data/2.5/forecast?id=3093133&APPID=e5ba0379f304cf74954037c2d9268da5";

//		Lubochnia		
		urlLink = "http://api.openweathermap.org/data/2.5/forecast?id=765863&APPID=e5ba0379f304cf74954037c2d9268da5";
	}
	

	
	public WeatherForecast getConnection(InputStreamReader isr){
		try {
			shortParametersDao = new ShortParametersDao();
			
		
			JsonReader jsonReader = Json.createReader(isr);
			JsonObject jsonObject = jsonReader.readObject();
			JsonObject cityObject = jsonObject.getJsonObject("city");
			JsonArray listObject =  jsonObject.getJsonArray("list");
			
			String cityName = cityObject.getString("name");
			String countryCode = cityObject.getString("country");
			
			
		
			
			for(int i=0; i< listObject.size(); i++) {
				long timeStamp = (long) listObject.getJsonObject(i).getInt("dt");
				JsonObject mainObject = listObject.getJsonObject(i).getJsonObject("temp");
				
				JsonNumber dayAvgTempJson = mainObject.getJsonNumber("day");
				double dayAvgTemp = dayAvgTempJson.doubleValue() - 273;
				
				JsonNumber nightAvgTempJson = mainObject.getJsonNumber("night");
				double nightAvgTemp = nightAvgTempJson.doubleValue() - 273;
				
				JsonArray weatherJson = listObject.getJsonObject(i).getJsonArray("weather");			
				String description = weatherJson.getJsonObject(0).getString("description");				
				String icon =  weatherJson.getJsonObject(0).getString("icon");
				
				
				
//				JsonNumber windObject = listObject.getJsonObject(i).getJsonNumber("speed");	//  getJsonObject("wind");
				
				JsonNumber windSpeedJson = listObject.getJsonObject(i).getJsonNumber("speed");
				double windSpeed = windSpeedJson.doubleValue();
				
				JsonNumber windDegJson = listObject.getJsonObject(i).getJsonNumber("deg");;
				double windDeg = windDegJson.doubleValue();
				
				JsonNumber rainJson = null;	//= listObject.getJsonObject(i).getJsonNumber("snow");
				double rain = 0;
				try{
					rainJson = listObject.getJsonObject(i).getJsonNumber("snow");
					rain = rainJson.doubleValue();
				} catch(NullPointerException npe) {
					rain = 0;
				}
				
				shortParametersDao.putElement(new ShortParameters(timeStamp, dayAvgTemp, nightAvgTemp, description, icon, windSpeed, windDeg, rain));
			}
			
			return new WeatherForecast(cityName, countryCode, shortParametersDao);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
