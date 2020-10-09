package exceptions;

public class UJCException extends Exception{
	private static final long serialVersionUID = 1L;
	private String user;

	public UJCException (String user){
		super("Usuário já cadastrado!");
		this.user = user;
	}

	public String getUser() {
		return user;
	}
}
