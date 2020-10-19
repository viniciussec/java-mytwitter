package services;

import java.util.ArrayList;

import entities.MyTwitter;
import entities.Perfil;
import entities.RepositorioUsuario;
import entities.Tweet;
import exceptions.MFPException;
import exceptions.PDException;
import exceptions.PEException;
import exceptions.PIException;
import exceptions.SIException;

public class MyTwitterService {
	private RepositorioUsuario repositorio;
	private MyTwitter tt;
	
	public MyTwitterService() {
		this.repositorio = new RepositorioUsuario();
		this.tt = new MyTwitter(repositorio);
	}
	
	public void criarPerfil(Perfil perfil) throws PEException {
		tt.criarPerfil(perfil);
	}
	
	public void cancelarPerfil(String perfil) throws PIException, PDException {
		tt.cancelarPerfil(perfil);
	}
	
	public void tweetar(String usuario, String mensagem) throws MFPException, PIException {
		tt.tweetar(usuario, mensagem);
	}
	
	public ArrayList<Tweet> timeline(String usuario) throws PIException, PDException {
		return tt.timeline(usuario);
	}
	
	public ArrayList<Tweet> tweets(String usuario) throws PIException, PDException {
		return tt.tweets(usuario);
	}
	
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException {
		tt.seguir(seguidor, seguido);
	}
	
	public int numeroSeguidores(String usuario) throws PIException, PDException {
		return tt.numeroSeguidores(usuario);
	}
	
	public ArrayList<Perfil> seguidores(String usuario) throws PIException, PDException {
		return tt.seguidores(usuario);
	}
	
	public ArrayList<Perfil> seguidos(String usuario) throws PIException, PDException {
		return tt.seguidos(usuario);
	}
	
	public Perfil buscar(String text) {
		return repositorio.buscar(text);
	}
}
