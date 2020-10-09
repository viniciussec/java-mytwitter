package exceptions;

public class MFPException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public MFPException(String message) {
		super("Mensagem fora do padrão");
		this.message = message;
	}

	public String getUser() {
		return message;
	}
}
