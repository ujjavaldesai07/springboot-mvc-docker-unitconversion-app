package com.springboot.mvc.conversionapp.unit_converter;

/*
 * This interface will be used to invoke
 * which type of unit conversion operation
 * to perform.
 */
public interface IConversionType {
	public void conversionOperation(Conversion theConversion);
}
