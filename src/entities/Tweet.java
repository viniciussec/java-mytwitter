package entities;

public class Tweet {
	private String usuario;
	private String mensagem;
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "\nUsuário: " + usuario + ", Mensagem: " + mensagem;
	}
}
