import java.util.ArrayList;

public class MyTwitter implements ITwitter {
	private IRepositorioUsuario repositorio;
	
	public MyTwitter(IRepositorioUsuario repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public void criarPerfil(Perfil usuario) {
		repositorio.cadastrar(usuario);
	}

	@Override
	public void cancelarPerfil(String usuario) {
		repositorio.buscar(usuario).setAtivo(false);
	}

	@Override
	public void tweetar(String usuario, String mensagem) {
		if(mensagem.length()<=140) {
			Tweet tweet = new Tweet();
			tweet.setMensagem(mensagem);
			tweet.setUsuario(usuario);
			
			repositorio.buscar(usuario).addTweet(tweet);
		}
		else {
			System.out.println("Mensagem muito grande!");
		}
	}

	@Override
	public ArrayList<Tweet> timeline(String usuario) {
		return repositorio.buscar(usuario).getTimeline();
	}

	@Override
	public ArrayList<Tweet> tweets(String usuario) {
		ArrayList<Tweet> tweets = new ArrayList<>();
		
		ArrayList<Tweet> timeline = repositorio.buscar(usuario).getTimeline();
		
		for(Tweet t : timeline) {
			if(t.getUsuario() == usuario) {
				tweets.add(t);
			}
		}
		
		return tweets;
	}

	@Override
	public void seguir(String seguidor, String seguido) {
		repositorio.buscar(seguidor).addSeguido(repositorio.buscar(seguido));
		repositorio.buscar(seguido).addSeguidor(repositorio.buscar(seguidor));
	}

	@Override
	public int numeroSeguidores(String usuario) {
		return repositorio.buscar(usuario).getSeguidores().size();
	}

	@Override
	public ArrayList<Perfil> seguidores(String usuario) {
		return repositorio.buscar(usuario).getSeguidores();
	}

	@Override
	public ArrayList<Perfil> seguidos(String usuario) {
		return repositorio.buscar(usuario).getSeguidos();
	}

}
