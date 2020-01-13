package com.springboot.mvc.conversionapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.springboot.mvc.conversionapp.unit_converter.Conversion;
import com.springboot.mvc.conversionapp.unit_converter.WebPage;

@Controller
public class ConversionController {
	
	// Enum to save the page request
	private WebPage requestedPage = null;

	/*
	 * display home page 
	 */
	@GetMapping("/")
	public String showHome(Model theModel) {
		return "home-page";
	}
	
	/*
	 * This function dynamically generates webpage based on 
	 * the get request. 
	 */
	@GetMapping(value={"/temp", "/length", "/area", "/time"})
	public String showTemp(Model theModel, HttpServletRequest request) {

		switch(request.getRequestURI()) {
		case "/temp":
			requestedPage = WebPage.TEMP;    		
			break;
		case "/area":
			requestedPage = WebPage.AREA;
			break;
		case "/time":
			requestedPage = WebPage.TIME;
			break;
		case "/length":
			requestedPage = WebPage.LENGTH;
			break;
		}

		// use parameterized constructor for setting request page
		theModel.addAttribute("conversion", new Conversion(requestedPage));
		return "conversion-page";
	}

	/*
	 * This function dynamically generates webpage based on 
	 * the post request. 
	 */
	@PostMapping("/conversion-operation")
	public String getTimeConversionResult(@ModelAttribute("conversion") Conversion theConversion) { 
		
		// we need to explicitly set the request page as by ModelAttribute 
		// construct the Conversion object using default constructor.
		theConversion.setRequestedPage(requestedPage);
		theConversion.conversionOperation();
		return "conversion-page";
	}
}
