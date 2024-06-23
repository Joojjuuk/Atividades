package myMathExceptions;

public class MatrixNullException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MatrixNullException(String mensagemErro) {
        super(mensagemErro);
    }

	public MatrixNullException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatrixNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MatrixNullException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MatrixNullException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
