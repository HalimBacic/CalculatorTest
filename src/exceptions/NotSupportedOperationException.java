package exceptions;

/**
 * 
 * @author Halim
 * 
 * Class which inherit Exception class. Will inform user that can not use operator which is not supported
 *
 */
@SuppressWarnings("serial")
public class NotSupportedOperationException extends Exception{
	
	/**
	 * Inherited constructor from parent class Exception
	 */
	public NotSupportedOperationException()
	{
		super();
	}
	
	/**
	 * @see Exception
	 * @param poruka - message which inform user for incompatible operator
	 */
	public NotSupportedOperationException(String poruka)
	{
		super(poruka);
	}
}
