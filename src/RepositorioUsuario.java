import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario implements IRepositorioUsuario{
	private List<Perfil> usuarios;
	
	public RepositorioUsuario() {
		usuarios = new ArrayList<Perfil>();
	}
	
	@Override
	public void cadastrar(Perfil usuario) {
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
	public void atualizar(Perfil usuario) {
		//não entendi o que é pra fazer ainda
	}
}
