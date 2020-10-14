package entities;

import java.util.ArrayList;

import exceptions.MFPException;
import exceptions.PDException;
import exceptions.PEException;
import exceptions.PIException;
import exceptions.SIException;
import exceptions.UJCException;

public class MyTwitter implements ITwitter {
	private IRepositorioUsuario repositorio;

	public MyTwitter(IRepositorioUsuario repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void criarPerfil(Perfil usuario) throws PEException {
		try {
			repositorio.cadastrar(usuario);
		} catch (UJCException e) {
			throw new PEException(usuario.getUsuario());
		}
	}

	@Override
	public void cancelarPerfil(String usuario) throws PIException, PDException {
		if (repositorio.buscar(usuario) == null) {
			throw new PIException(usuario);
		}
		if (repositorio.buscar(usuario).isAtivo() == false) {
			throw new PDException(usuario);
		}
		repositorio.buscar(usuario).setAtivo(false);
	}

	@Override
	public void tweetar(String usuario, String mensagem) throws MFPException, PIException {
		if (repositorio.buscar(usuario) == null) {
			throw new PIException(usuario);
		}
		if (mensagem.length() > 140) {
			throw new MFPException(mensagem);
		}
		Tweet tweet = new Tweet();
		tweet.setMensagem(mensagem);
		tweet.setUsuario(usuario);
		repositorio.buscar(usuario).addTweet(tweet);
		ArrayList<Perfil> seguidores = repositorio.buscar(usuario).getSeguidores();
		for(Perfil p : seguidores) {
			p.addTweet(tweet);
		}
	}

	@Override
	public ArrayList<Tweet> timeline(String usuario) throws PIException, PDException {
		if (repositorio.buscar(usuario) == null) {
			throw new PIException(usuario);
		}
		if (repositorio.buscar(usuario).isAtivo() == false) {
			throw new PDException(usuario);
		}
		return repositorio.buscar(usuario).getTimeline();
	}

	@Override
	public ArrayList<Tweet> tweets(String usuario) throws PIException, PDException {
		if (repositorio.buscar(usuario) == null) {
			throw new PIException(usuario);
		}
		if (repositorio.buscar(usuario).isAtivo() == false) {
			throw new PDException(usuario);
		}

		ArrayList<Tweet> tweets = new ArrayList<>();
		ArrayList<Tweet> timeline = repositorio.buscar(usuario).getTimeline();
		for (Tweet t : timeline) {
			if (t.getUsuario().equals(usuario)) {
				tweets.add(t);
			}
		}
		return tweets;
	}

	@Override
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException {
		if (repositorio.buscar(seguidor) == null) {
			throw new PIException(seguidor);
		}
		if (repositorio.buscar(seguidor).isAtivo() == false) {
			throw new PDException(seguidor);
		}
		if (repositorio.buscar(seguido) == null) {
			throw new PIException(seguido);
		}
		if (repositorio.buscar(seguido).isAtivo() == false) {
			throw new PDException(seguido);
		}
		if (seguidor == seguido) {
			throw new SIException(seguidor, seguido);
		}
		repositorio.buscar(seguidor).addSeguido(repositorio.buscar(seguido));
		repositorio.buscar(seguido).addSeguidor(repositorio.buscar(seguidor));
	}

	@Override
	public int numeroSeguidores(String usuario) throws PIException, PDException {
		if (repositorio.buscar(usuario) == null) {
			throw new PIException(usuario);
		}
		if (repositorio.buscar(usuario).isAtivo() == false) {
			throw new PDException(usuario);
		}
		return repositorio.buscar(usuario).getSeguidores().size();
	}

	@Override
	public ArrayList<Perfil> seguidores(String usuario) throws PIException, PDException {
		if (repositorio.buscar(usuario) == null) {
			throw new PIException(usuario);
		}
		if (repositorio.buscar(usuario).isAtivo() == false) {
			throw new PDException(usuario);
		}
		return repositorio.buscar(usuario).getSeguidores();
	}

	@Override
	public ArrayList<Perfil> seguidos(String usuario) throws PIException, PDException {
		if (repositorio.buscar(usuario) == null) {
			throw new PIException(usuario);
		}
		if (repositorio.buscar(usuario).isAtivo() == false) {
			throw new PDException(usuario);
		}
		return repositorio.buscar(usuario).getSeguidos();
	}

	@Override
	public String toString() {
		return "MyTwitter [repositorio=" + repositorio + "]";
	}
}
