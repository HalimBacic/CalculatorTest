package calculator;

import java.text.DecimalFormat;

import exceptions.DivisionByZero;
import exceptions.NotSupportedOperationException;

/**
 * 
 * @author Halim Bacic
 * @version 1.0
 * <h1>Calculator class <h1>
 * Class Calculator for calculate four main math operations + ,* ,/ ,-
 * User can initialize current value and then make math operations
 */

//TODO Osnovne provjere za get i set
public class Calculator {

	/**
	 * currentValue - class member which will be used in calculations.
	 */
	private Double currentValue;
	
	/**
	 *  Calculator() for construct object with currentValue equal to 0
	 */
	public Calculator()
	{}
	
	/**
	 * This constructor will be called in situation when user set currentValue to decimal number
	 * @param cv  currentValue will be equal to cv parameter
	 */
	public Calculator(Double cv)
	{
		this.currentValue=cv;
	}
	
	/**
	 * This constructor will be called when user input for cv is natural number
	 * @see Calculator(Double cv)
	 * @param cv  number which will be currentValue
	 */
	public Calculator(Integer cv)
	{
		this(cv.doubleValue());
	}

	/**
	 * Getter method which return currentValue
	 * @return currentValue
	 */
	public Double getCurrentValue() {
		return currentValue;
	}

	/**
	 * Set method where user initialize current value
	 * @see getCurrentValue()
	 * @param currentValue for store in object
	 */
	public void setCurrentValue(Double currentValue) {
		DecimalFormat df = new DecimalFormat("#.##");
		this.currentValue = Double.valueOf(df.format(currentValue));
	}
	
	/**
	 * @see getCurrentValue()
	 * @see setCurrentValue(Double currentValue)
	 * @param currentValue for store in object
	 */
	public void setCurrentValue(Integer currentValue) {
		this.setCurrentValue(currentValue.doubleValue());
	}
	
	/**
	 * Method for calculating value of currentValue after implement math operation specified in operator
	 * @param value  second operand of math operation
	 * @param operator  char value for math operation
	 * @throws NotSupportedOperationException  exception will be thrown when user set operator for unknown or unimplemented math operation.
	 * @throws DivisionByZero  exception will be thrown 
	 */
	public void calculate(Double value,char operator) throws DivisionByZero, NotSupportedOperationException
	{
		
		if("+".charAt(0)==operator)
			setCurrentValue((getCurrentValue()+value));
		else if("-".charAt(0)==operator)
			setCurrentValue(getCurrentValue()-value);
		else if("*".charAt(0)==operator)
			setCurrentValue(getCurrentValue()*value);
		else if("/".charAt(0)==operator) {
			if(value==0)
				throw new DivisionByZero("Dijeljenje sa 0 nije moguce.");
			else
			setCurrentValue(getCurrentValue()/value);
		}
		else {
			throw new NotSupportedOperationException("Nije podrzan operator "+operator);
		}
	}
}
