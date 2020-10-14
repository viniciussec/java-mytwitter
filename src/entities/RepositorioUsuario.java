package entities;
import java.util.ArrayList;

import exceptions.UJCException;
import exceptions.UNCException;

public class RepositorioUsuario implements IRepositorioUsuario{
	private ArrayList<Perfil> usuarios;
	
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
	public String toString() {
		return "RepositorioUsuario [usuarios=" + usuarios + "]";
	}

	@Override
	public Perfil buscar(String usuario) {
		for(Perfil p : usuarios) {
			if(p.getUsuario().equals(usuario)) {
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
		usuarios.remove(buscar(usuario.getUsuario()));
		usuarios.add(usuario);
	}
}
