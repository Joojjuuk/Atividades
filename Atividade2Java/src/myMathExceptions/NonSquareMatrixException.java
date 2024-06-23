package myMathExceptions;

public class NonSquareMatrixException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NonSquareMatrixException(String mensagemErro) {
        super(mensagemErro);
    }

	public NonSquareMatrixException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NonSquareMatrixException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NonSquareMatrixException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NonSquareMatrixException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
