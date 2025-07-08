package classes;



public class Funcionario{
	
	private int id;
	private String nome;
    private String sobrenome;
    private String email;
    private String senha; 
    private String endereco;
    private String cpf; 
    private String cargo;
    
    public Funcionario() {
    	this.setId(0);
    	this.setNome("");
    	this.setSobrenome("");
    	this.setEmail("");
    	this.setSenha("");
    	this.setEndereco("");
    	this.setCpf("");
    	this.setCargo("");
    }
    
    public Funcionario(int id, String nome, String sobrenome, String email, String senha, String endereco, String cpf, String Cargo) {
    	this.setId(id);
    	this.setNome(nome);
    	this.setSobrenome(sobrenome);
    	this.setEmail(email);
    	this.setSenha(senha);
    	this.setEndereco(endereco);
    	this.setCpf(cpf);
    	this.setCargo(cargo);
    }
    
    // Get and Set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
    
	
    
}
