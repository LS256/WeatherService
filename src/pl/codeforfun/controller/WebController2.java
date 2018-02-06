package pl.codeforfun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController2 {

@RequestMapping(value="/newController", method=RequestMethod.GET)
public String getNewPage(Model model){
	return "startPage";
}


}
