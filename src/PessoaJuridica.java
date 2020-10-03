
public class PessoaJuridica extends Perfil{
	private long cpf;
	
	public PessoaJuridica(String usuario) {
		super(usuario);
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
}
