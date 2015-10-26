package each.usp.ach2006.adaptedfromcsc326.eler.exceptions;

public class InsufficientAmountOfMoneyException extends Exception {
	private static final long serialVersionUID = 1L;
	public InsufficientAmountOfMoneyException(String msg){
		super(msg);
	}
}