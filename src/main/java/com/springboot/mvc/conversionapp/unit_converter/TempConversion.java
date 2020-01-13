package com.springboot.mvc.conversionapp.unit_converter;

public class TempConversion implements IConversionType {

	// supported units
	private final String CELSIUS = "1";
	private final String KELVIN = "2";
	private final String FAHRENHEIT = "3";

	public TempConversion(Conversion theConversion) {
		
		// add the units in the map dynamically so that we can extend the
		// support of more units in future 
		theConversion.addTimeUnit(Integer.valueOf(CELSIUS), "Celsius");
		theConversion.addTimeUnit(Integer.valueOf(KELVIN), "Kelvin");
		theConversion.addTimeUnit(Integer.valueOf(FAHRENHEIT), "Fahrenheit");
		
		// set the background color here as we are using generic thymeleaf template
		theConversion.setBgColor("bg-primary");
	}

	/*
	 * This function handles the unit conversion logic for the
	 * units supported by the temperature.
	 */
	public void conversionOperation(Conversion theConversion) {
		
		switch(theConversion.getFromSelectUnit()) {
		case CELSIUS:
			switch(theConversion.getToSelectUnit()) {
			case CELSIUS:			
				theConversion.setToVal(theConversion.getFromVal());
				break;
			case KELVIN:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) + 273.15));
				break;
			case FAHRENHEIT:				
				theConversion.setToVal(Double.toString((Double.valueOf(theConversion.getFromVal()) * 9/5) + 32));
				break;
			}
			break;
		case KELVIN:
			switch(theConversion.getToSelectUnit()) {
			case CELSIUS:				
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) - 273.15));
				break;
			case KELVIN:				
				theConversion.setToVal(theConversion.getFromVal());
				break;
			case FAHRENHEIT: 
				theConversion.setToVal(Double.toString((Double.valueOf(theConversion.getFromVal()) - 273.15) * 9/5 + 32));
				break;
			}
			break;
		case FAHRENHEIT:
			switch(theConversion.getToSelectUnit()) {
			case CELSIUS:
				theConversion.setToVal(Double.toString((Double.valueOf(theConversion.getFromVal()) - 32) * 5/9));
				break;
			case KELVIN:
				theConversion.setToVal(Double.toString((Double.valueOf(theConversion.getFromVal()) - 32) * 5/9 + 273.15));
				break;
			case FAHRENHEIT:
				theConversion.setToVal(theConversion.getFromVal());
				break;
			}
			break;
		}
	}


}
