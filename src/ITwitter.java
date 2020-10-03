import java.util.ArrayList;

public interface ITwitter {
	public void criarPerfil(Perfil usuario);
	public void cancelarPerfil(String usuario);
	public void tweetar(String usuario, String mensagem);
	public ArrayList<Tweet> timeline(String usuario);
	public ArrayList<Tweet> tweets(String usuario);
	public void seguir(String seguidor, String seguido);
	public int numeroSeguidores(String usuario);
	public ArrayList<Perfil> seguidores(String usuario);
	public ArrayList<Perfil> seguidos(String usuario);
}
