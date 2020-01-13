package com.springboot.mvc.conversionapp.unit_converter;

public class TimeConversion implements IConversionType {

	// supported units
	private final String SECOND = "1";
	private final String MILLISECOND = "2";
	private final String MINUTE = "3";
	private final String HOUR = "4";

	public TimeConversion(Conversion theConversion) {
		
		// add the units in the map dynamically so that we can extend the
		// support of more units in future
		theConversion.addTimeUnit(Integer.valueOf(SECOND), "Second");
		theConversion.addTimeUnit(Integer.valueOf(MILLISECOND), "Millisecond");
		theConversion.addTimeUnit(Integer.valueOf(MINUTE), "Minute");
		theConversion.addTimeUnit(Integer.valueOf(HOUR), "Hour");
		
		// set the background color here as we are using generic thymeleaf template
		theConversion.setBgColor("bg-info");
	}

	/*
	 * This function handles the unit conversion logic for the
	 * units supported by the time.
	 */
	public void conversionOperation(Conversion theConversion) {
		
		switch(theConversion.getFromSelectUnit()) {
		case SECOND:
			switch(theConversion.getToSelectUnit()) {
			case SECOND:			
				theConversion.setToVal(theConversion.getFromVal());
				break;
			case MILLISECOND:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1000));
				break;
			case MINUTE:				
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1/60));
				break;
			case HOUR:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1/3600));
				break;
			}
			break;
		case MILLISECOND:
			switch(theConversion.getToSelectUnit()) {
			case SECOND:				
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1/1000));
				break;
			case MILLISECOND:				
				theConversion.setToVal(theConversion.getFromVal());
				break;
			case MINUTE: 
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1/60000));
				break;
			case HOUR:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 0.00000027778));
				break;
			}
			break;
		case MINUTE:
			switch(theConversion.getToSelectUnit()) {
			case SECOND:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 60));
				break;
			case MILLISECOND:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 60000));
				break;
			case MINUTE:
				theConversion.setToVal(theConversion.getFromVal());
				break;
			case HOUR:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1/60));
				break;
			}
			break;
		case HOUR:
			switch(theConversion.getToSelectUnit()) {
			case SECOND:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 3600));
				break;
			case MILLISECOND:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 3600000));
				break;
			case MINUTE:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 60));
				break;
			case HOUR:
				theConversion.setToVal(theConversion.getFromVal());
				break;
			}
			break;
		}
	}

}
