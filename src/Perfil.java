import java.util.ArrayList;
import java.util.List;

public abstract class Perfil {
	private String usuario;
	private List<Perfil> seguidos;
	private List<Perfil> seguidores;
	private List<Tweet> timeline;
	private boolean ativo;
	
	public Perfil(String usuario) {
		this.usuario = usuario;
		seguidos = new ArrayList<Perfil>();
		seguidores = new ArrayList<Perfil>();
		timeline = new ArrayList<Tweet>();
		ativo = true;
	}
	
	public void addSeguido(Perfil usuario) {
		seguidos.add(usuario);
	}
	
	public void addSeguidor(Perfil usuario) {
		seguidores.add(usuario);
	}
	
	public void addTweet(Tweet tweet) {
		timeline.add(tweet);
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public List<Perfil> getSeguidos() {
		return seguidos;
	}

	public List<Perfil> getSeguidores() {
		return seguidores;
	}

	public List<Tweet> getTimeline() {
		return timeline;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	
}
