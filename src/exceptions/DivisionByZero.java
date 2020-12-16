package exceptions;

@SuppressWarnings("serial")
/**
 * 
 * @author Halim
 * Class created for inform user that division by 0 is incompatible
 *
 */
public class DivisionByZero extends Exception{
	
	/**
	 * Inherited constructor from parent class Exception
	 */
	public DivisionByZero()
	{
		super();
	}
	
	/**
	 * @see Exception
	 * @param poruka - special created message for user
	 */
	public DivisionByZero(String poruka)
	{
		super(poruka);
	}
}
