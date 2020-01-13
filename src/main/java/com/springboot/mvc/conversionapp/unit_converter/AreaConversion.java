package com.springboot.mvc.conversionapp.unit_converter;

public class AreaConversion implements IConversionType {

	// supported units
	private final String METER = "1";
	private final String KILOMETER = "2";
	private final String CENTIMETER = "3";

	public AreaConversion(Conversion theConversion) {
		
		// add the units in the map dynamically so that we can extend the
		// support of more units in future 
		theConversion.addTimeUnit(Integer.valueOf(METER), "Meter");
		theConversion.addTimeUnit(Integer.valueOf(KILOMETER), "Kilometer");
		theConversion.addTimeUnit(Integer.valueOf(CENTIMETER), "Centimeter");
		
		// set the background color here as we are using generic thymeleaf template
		theConversion.setBgColor("bg-success");
	}

	/*
	 * This function handles the unit conversion logic for the
	 * units supported by the area.
	 */
	public void conversionOperation(Conversion theConversion) {

		switch(theConversion.getFromSelectUnit()) {
		case METER:
			switch(theConversion.getToSelectUnit()) {
			case METER:			
				theConversion.setToVal(theConversion.getFromVal());
				break;
			case KILOMETER:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1/1000));
				break;
			case CENTIMETER:				
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 100));
				break;
			}
			break;
		case KILOMETER:
			switch(theConversion.getToSelectUnit()) {
			case METER:				
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1000));
				break;
			case KILOMETER:				
				theConversion.setToVal(theConversion.getFromVal());
				break;
			case CENTIMETER: 
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 100000));
				break;
			}
			break;
		case CENTIMETER:
			switch(theConversion.getToSelectUnit()) {
			case METER:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1/100));
				break;
			case KILOMETER:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1/100000));
				break;
			case CENTIMETER:
				theConversion.setToVal(theConversion.getFromVal());
				break;
			}
			break;
		}
	}


}
