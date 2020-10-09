package exceptions;

public class UNCException extends Exception{
	private static final long serialVersionUID = 1L;
	private String user;

	public UNCException (String user){
		super("Usuário não cadastrado!");
		this.user = user;
	}

	public String getUser() {
		return user;
	}
}
