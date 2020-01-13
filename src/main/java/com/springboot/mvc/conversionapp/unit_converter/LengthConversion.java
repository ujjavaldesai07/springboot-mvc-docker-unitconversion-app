package com.springboot.mvc.conversionapp.unit_converter;

public class LengthConversion implements IConversionType {

	// supported units
	private final String LITER = "1";
	private final String MILLILITER = "2";
	private final String GALLON = "3";

	public LengthConversion(Conversion theConversion) {
		
		// add the units in the map dynamically so that we can extend the
		// support of more units in future 
		theConversion.addTimeUnit(Integer.valueOf(LITER), "Liter");
		theConversion.addTimeUnit(Integer.valueOf(MILLILITER), "Milliliter");
		theConversion.addTimeUnit(Integer.valueOf(GALLON), "Gallon");
		
		// set the background color here as we are using generic thymeleaf template
		theConversion.setBgColor("bg-secondary");
	}

	/*
	 * This function handles the unit conversion logic for the
	 * units supported by the length.
	 */
	public void conversionOperation(Conversion theConversion) {

		switch(theConversion.getFromSelectUnit()) {
		case LITER:
			switch(theConversion.getToSelectUnit()) {
			case LITER:			
				theConversion.setToVal(theConversion.getFromVal());
				break;
			case MILLILITER:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1000));
				break;
			case GALLON:				
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 0.264172));
				break;
			}
			break;
		case MILLILITER:
			switch(theConversion.getToSelectUnit()) {
			case LITER:				
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 1/1000));
				break;
			case MILLILITER:				
				theConversion.setToVal(theConversion.getFromVal());
				break;
			case GALLON: 
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 0.0002641722));
				break;
			}
			break;
		case GALLON:
			switch(theConversion.getToSelectUnit()) {
			case LITER:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 3.785));
				break;
			case MILLILITER:
				theConversion.setToVal(Double.toString(Double.valueOf(theConversion.getFromVal()) * 3785.41));
				break;
			case GALLON:
				theConversion.setToVal(theConversion.getFromVal());
				break;
			}
			break;
		}
	}


}
