package pl.codeforfun.controller;


import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.codeforfun.model.Connection;
import pl.codeforfun.model.Query;
import pl.codeforfun.model.Query16;
import pl.codeforfun.model.UrlGenerator;
import pl.codeforfun.model.WeatherForecast;



@Controller
public class WebController {
	
	@Autowired
	Query query;
	@Autowired
	Query16 query16;	
	@Autowired
	WeatherForecast weatherForecast;
	@Autowired
	UrlGenerator urlGenerator;

	@RequestMapping(value="/weatherForecast", method=RequestMethod.GET)
	public String startSearching(Model model) {
		return "startPage";
	}
	
	@RequestMapping(value="/weatherForecast", method=RequestMethod.POST)
	public String postCode(Model model, @RequestParam("cityNameInput") String cityNameInput, @RequestParam("weatherType") String weatherType) {

		urlGenerator.setUrlAddress(cityNameInput,  weatherType);
		String urlAddress = urlGenerator.getUrlAddress();
		
		Connection connection = new Connection(urlAddress);
		InputStreamReader isr = connection.getConnection();
			
		if(isr == null) {
			return "startPage";
		} 
		
		if(weatherType.equals("longTerm")) {
			weatherForecast = query16.getConnection(isr);		
			model.addAttribute("cityName",  weatherForecast.getCityName());
			model.addAttribute("countryCode",  weatherForecast.getCountryCode());
			model.addAttribute("tempList", weatherForecast.getShortParametersDao().getShortParametersList());
			return "longTermForecast";
		}
		//	if short term weather forecast option was checked or short and long term were checked 
		else {
			weatherForecast = query.getConnection(isr);	
			model.addAttribute("cityName",  weatherForecast.getCityName());
			model.addAttribute("countryCode",  weatherForecast.getCountryCode());
			model.addAttribute("tempList", weatherForecast.getShortParametersDao().getShortParametersList());
			return "weatherForecast";
		}
	}
	
}
