package exceptions;

public class SIException extends Exception{
	private static final long serialVersionUID = 1L;
	private String seguidor;
	private String seguido;
	
	public SIException(String seguidor, String seguido) {
		super("Usuário seguido também é o seguidor!");
		this.seguidor = seguidor;
		this.seguido = seguido;
	}
	
	public String getSeguidor() {
		return seguidor;
	}
	
	public String getSeguido() {
		return seguido;
	}
}
