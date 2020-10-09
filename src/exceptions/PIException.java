package exceptions;

public class PIException extends Exception{
	private static final long serialVersionUID = 1L;
	private String user;
	
	public PIException(String user) {
		super("Perfil inexistente!");
		this.user = user;
	}

	public String getUser() {
		return user;
	}
}
