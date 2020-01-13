package com.springboot.mvc.conversionapp.unit_converter;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Conversion {
	
	// set the web-page attributes
	private String fromVal;
	private String toVal;
	private String fromSelectUnit;
	private String toSelectUnit;
	private String errorMsg;
	private String bgColor;
	private String conversionPage;
	private Map<Integer, String> timeUnits;
	private IConversionType conversionTypeInst;
	private final static Logger logger = Logger.getLogger("Conversion.Logger"); 

	public Conversion() {
		
		// set the default values.
		logger.log(Level.INFO, "Default Conversion constructor invoked");
		timeUnits = new HashMap<>();
		this.toSelectUnit = "1";
		this.fromSelectUnit = "1";
		this.errorMsg = "";
	}

	public Conversion(WebPage requestedPage) {
		this();
		setRequestedPage(requestedPage);
		logger.log(Level.INFO, "Parametrized Conversion constructor invoked");
	}

	public String getFromVal() {
		return fromVal;
	}
	public void setFromVal(String fromVal) {
		this.fromVal = fromVal;
	}
	public String getToVal() {
		return toVal;
	}
	public void setToVal(String toVal) {
		this.toVal = toVal;
	}
	public String getFromSelectUnit() {
		return fromSelectUnit;
	}
	public void setFromSelectUnit(String fromSelectUnit) {
		this.fromSelectUnit = fromSelectUnit;
	}
	public String getToSelectUnit() {
		return toSelectUnit;
	}
	public void setToSelectUnit(String toSelectUnit) {
		this.toSelectUnit = toSelectUnit;
	}
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	public String getBgColor() {
		return bgColor;
	}
	public Map<Integer, String> getTimeUnits() {
		return timeUnits;
	}
	public void addTimeUnit(Integer key, String value) {
		timeUnits.put(key, value);
	}
	public String getErrorMsg() {
		return errorMsg;
	}

	public String getConversionPage() {
		return conversionPage;
	}

	public void setRequestedPage(WebPage requestedPage) {
		
		// set the page request type instance.
		switch(requestedPage) {
		case TEMP:
			this.conversionTypeInst = new TempConversion(this);		
			conversionPage = "Temp Conversion";
			break;
		case LENGTH:
			this.conversionTypeInst = new LengthConversion(this);
			conversionPage = "Length Conversion";
			break;
		case TIME:
			this.conversionTypeInst = new TimeConversion(this);
			conversionPage = "Time Conversion";
			break;
		case AREA:
			this.conversionTypeInst = new AreaConversion(this);
			conversionPage = "Area Conversion";
			break;
		}
		logger.log(Level.INFO, "requestedPage = " + requestedPage + " is set.");
		logger.log(Level.INFO, "conversionTypeInst = " + conversionTypeInst + " is created.");
	}

	private boolean isInputDouble() {
		
		// input validation. 
		try 
		{ 
			Double.valueOf(fromVal); 
			errorMsg = "";
			logger.log(Level.INFO, "Input Double validation successful.");
			return true;
		}  
		catch (Exception e)  
		{ 
			errorMsg = "Input must be valid integer/decimal number!!";
		} 
		logger.log(Level.INFO, "Input Double validation failed.");
		return false;
	}

	public void conversionOperation() {
		
		// whether input is empty or not.
		if(fromVal.isEmpty()) {
			errorMsg="Input is empty. Enter a valid integer/decimal number!";
			logger.log(Level.INFO, "Input validation failed.");
			return;
		}

		if(!isInputDouble())
		{
			return;
		}

		// process the operation based on the conversion type instance.
		logger.log(Level.INFO, "Performing Conversion operation from conversionTypeInst " + conversionTypeInst);
		conversionTypeInst.conversionOperation(this);

		// if the resultant value is not required as double then
		// slice the values after decimal as we need to display
		// value as an integer.
		String[] nums = toVal.split("\\.");
		if(nums.length > 1 && nums[1].length() < 2 && nums[1].compareTo("0") == 0) {
			toVal = nums[0];
		}
		logger.log(Level.INFO, "Resultant toVal = " + toVal);
	}

}
