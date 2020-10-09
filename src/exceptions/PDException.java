package exceptions;

public class PDException extends Exception{
	private static final long serialVersionUID = 1L;
	private String user;

	public PDException (String user){
		super("Perfil desativado!");
		this.user = user;
	}

	public String getUser() {
		return user;
	}
}
