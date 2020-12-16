package exceptions;

@SuppressWarnings("serial")
public class NumberNotInAreaException extends Exception {

	
	//TODO Kreirati NumberNotInArea testove u CalculatorAdvanced
	public NumberNotInAreaException()
	{
		super();
	}
	
	public NumberNotInAreaException(String msg)
	{
		super(msg);
	}
}
