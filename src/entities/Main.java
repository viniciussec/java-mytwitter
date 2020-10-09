package entities;

import exceptions.PDException;
import exceptions.PIException;
import exceptions.SIException;
import exceptions.UJCException;

public class Main {

	public static void main(String[] args) throws UJCException, PIException, PDException, SIException {
		RepositorioUsuario repositorio = new RepositorioUsuario();
		MyTwitter tt = new MyTwitter(repositorio);
		
		PessoaFisica perfil = new PessoaFisica("viniciussec");
		PessoaFisica perfil2 = new PessoaFisica("piruleta");
		repositorio.cadastrar(perfil);
		repositorio.cadastrar(perfil2);
		
		tt.seguir("viniciussec", "piruleta");
		
		System.out.println(tt.numeroSeguidores("viniciussec"));
		System.out.println(tt.numeroSeguidores("piruleta"));
	}

}
