package myMathExceptions;

public class PotenciaNegativeExponentException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PotenciaNegativeExponentException(String mensagemErro) {
        super(mensagemErro);
    }

	public PotenciaNegativeExponentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PotenciaNegativeExponentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PotenciaNegativeExponentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PotenciaNegativeExponentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
