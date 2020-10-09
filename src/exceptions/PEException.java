package exceptions;

public class PEException extends Exception {
	private static final long serialVersionUID = 1L;
	private String user;

	public PEException(String user) {
		super("Perfil já existente!");
		this.user = user;
	}

	public String getUser() {
		return user;
	}
}
