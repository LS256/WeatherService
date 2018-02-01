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
import pl.codeforfun.model.UrlGenerator;
import pl.codeforfun.model.WeatherForecast;



@Controller
public class WebController {
	
	@Autowired
	Query query;
	
	@Autowired
	WeatherForecast weatherForecast;

	@RequestMapping(value="/weatherForecast", method=RequestMethod.GET)
	public String startSearching(Model model) {
		return "startPage";
	}
	
	@RequestMapping(value="/weatherForecast", method=RequestMethod.POST)
	public String postCode(Model model, @RequestParam("cityNameInput") String cityNameInput) {
//		UrlGenerator urlGenerator = new UrlGenerator(cityNameInput); 
		System.out.println("Inside the controller: " + cityNameInput);
		
		
		Connection connection = new Connection(cityNameInput);
		InputStreamReader isr = connection.getConnection();
		
		if(isr == null) {
			System.out.println("Nic z tego koleszko..");
			return "startPage";
		} else {
			weatherForecast = query.getConnection(isr);	
			
			model.addAttribute("cityName",  weatherForecast.getCityName());
			model.addAttribute("countryCode",  weatherForecast.getCountryCode());
			model.addAttribute("tempList", weatherForecast.getShortParametersDao().getShortParametersList());
		}
		return "weatherForecast";
	}
	
}
