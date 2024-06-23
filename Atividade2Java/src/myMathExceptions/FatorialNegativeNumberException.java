package myMathExceptions;

public class FatorialNegativeNumberException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FatorialNegativeNumberException(String mensagemErro) {
        super(mensagemErro);
    }

	public FatorialNegativeNumberException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FatorialNegativeNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FatorialNegativeNumberException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FatorialNegativeNumberException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
