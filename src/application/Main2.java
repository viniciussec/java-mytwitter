package application;

import entities.MyTwitter;
import entities.Perfil;
import entities.PessoaFisica;
import entities.RepositorioUsuario;
import exceptions.PEException;

public class Main2 {
	public static void main(String[] args) throws PEException {
		Perfil perfil = new PessoaFisica("viniciussec");
		RepositorioUsuario repo = new RepositorioUsuario();
		MyTwitter tt = new MyTwitter(repo);
		
		tt.criarPerfil(perfil);
		tt.criarPerfil(perfil);
	}
}
