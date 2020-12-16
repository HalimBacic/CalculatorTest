package calculatoradvanced;

import calculator.Calculator;
import exceptions.DivisionByZero;
import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;

/**
 * 
 * <h2>CalculatorAdvanced</h2>
 * 
 * @author Halim
 * 
 *         Class which extends Calculator class and add new functions for calculating factorial and gradation
 *         With this class user can find out is currentValue perfect or Armstrong number
 *         
 */
public class CalculatorAdvanced extends Calculator {

	public CalculatorAdvanced() {
		super();
	}

	public CalculatorAdvanced(Double cv) {
		super(cv);
	}

	public CalculatorAdvanced(Integer cv) {
		super(cv);
	}

	/**
	 * Method which is used for gradation or factorial in CalculatorAdvanced objects
	 * 
	 * @param action  is number between [0-9] for gradation or "!" for factorial.
	 * @throws NumberNotInAreaException        thrown when action is not in interval [0-9]
	 * @see DivisionByZero
	 * @see NotSupportedOperationException
	 */
	public void calculateAdvanced(char action) throws NumberNotInAreaException {
		if (action == "!".charAt(0))
			try {
				factorial();
			} catch (NotSupportedOperationException | DivisionByZero e1) {
				e1.printStackTrace();
			}

		else {

			Integer stepen = Integer.parseInt(String.valueOf(action));
			try {
				stepenovanje(stepen);
			} catch (NotSupportedOperationException | DivisionByZero e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method will be used when user input ! for parameter in
	 * calculateAdvanced(char action) method Usage for calculate factorial of
	 * currentValue attribute
	 * 
	 * @see NotSupportedOperationException
	 * @see DivisionByZero
	 * @throws NotSupportedOperationException  Created exception
	 * @throws DivisionByZero                  Created Exception
	 */
	public void factorial() throws NotSupportedOperationException, DivisionByZero {
		Integer f = getCurrentValue().intValue() - 1;

		if (getCurrentValue() == 0.0)
			calculate(Double.parseDouble("1.0"), "+".charAt(0));

		while (f > 0) {
			calculate(f.doubleValue(), "*".charAt(0));
			f--;
		}
	}

	/**
	 * Auxiliary function for graduation
	 * 
	 * @param broj - param which represent graduation operation
	 * 
	 * @see calculateAdvanced(char action)
	 * @see NotSupportedOperationException
	 * @see DivisionByZero
	 * @throws NotSupportedOperationException Created exception
	 * @throws DivisionByZero                 Created exception
	 */
	public void stepenovanje(Integer broj) throws NotSupportedOperationException, DivisionByZero {

		Double number = getCurrentValue();

		do {
			calculate(number, "*".charAt(0));
			broj--;
		} while (broj > 1);
	}

	/**
	 * Method for checking is number Armstrong or perfect
	 * 
	 * @param value  can be A for check is currentValue Armstrong number or P for
	 *              check is currentValue is perfect number
	 * @return  true or false if currentValue has choosen characteristic
	 * @see NumberNotInAreaException exception  Created exception
	 * @throws NumberNotInAreaException  Created exception
	 */
	public Boolean hasCharacteristic(char value) throws NumberNotInAreaException {
		if (getCurrentValue() <= 0)
			throw new NumberNotInAreaException("Trenutna vrijednost <1");
		else if (value == "P".charAt(0))
			return isSavrsen();
		else if (value == "A".charAt(0))
			return isArmstrong();
		else {
			return false;
		}
	}

	/**
	 * Method check is number perfect
	 * 
	 * @return true is number is perfect or false if is not
	 */
	public boolean isSavrsen() {
		Integer perf = 0;
		Integer div = getCurrentValue().intValue() - 1;
		while (div > -1) {
			if (getCurrentValue() % div == 0)
				perf += div;
			div--;
		}

		if (perf == getCurrentValue().intValue())
			return true;
		else {
			return false;
		}
	}

	/**
	 * Method check is number perfect
	 * 
	 * @return true if number is Armstrong or false if number is not
	 */
	public boolean isArmstrong() {
		Integer arm = 0;
		Integer brojCifara = 0;
		Integer num = getCurrentValue().intValue();

		while (num >= 1) {
			brojCifara++;
			num /= 10;
		}

		num = getCurrentValue().intValue();
		while (num >= 1) {
			Integer cifra = num % 10;
			arm = (int) (arm + Math.pow(cifra, brojCifara));
			num /= 10;
		}

		if (arm == getCurrentValue().intValue())
			return true;
		else {
			return false;
		}
	}
}
