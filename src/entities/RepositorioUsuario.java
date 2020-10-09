package entities;
import java.util.ArrayList;
import java.util.List;

import exceptions.UJCException;
import exceptions.UNCException;

public class RepositorioUsuario implements IRepositorioUsuario{
	private List<Perfil> usuarios;
	
	public RepositorioUsuario() {
		usuarios = new ArrayList<Perfil>();
	}
	
	@Override
	public void cadastrar(Perfil usuario) throws UJCException {
		if(buscar(usuario.getUsuario())!=null) {
			throw new UJCException(usuario.getUsuario());
		}
		usuarios.add(usuario);
	}

	@Override
	public Perfil buscar(String usuario) {
		for(Perfil p : usuarios) {
			if(p.getUsuario() == usuario) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void atualizar(Perfil usuario) throws UNCException{
		if(buscar(usuario.getUsuario())==null) {
			throw new UNCException(usuario.getUsuario());
		}
		//implementar resto aki (ainda não entendi)
	}
}
