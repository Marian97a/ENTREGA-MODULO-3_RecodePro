package modelos;

public class Clientes {
	//Attributes
	
	private int id;
	private String nome;
	private String CPF;
	private String email;
	private String telefone;
	

	// Constructor
	public Clientes() {
	}


	public Clientes(int id, String nome, String cPF, String email, String telefone) {
		this.id = id;
		this.nome = nome;
		CPF = cPF;
		this.email = email;
		this.telefone = telefone;
	}


	public Clientes(String nome, String cPF, String email, String telefone) {
		this.nome = nome;
		CPF = cPF;
		this.email = email;
		this.telefone = telefone;
	}

	// getters e setters

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nome=" + nome + ", CPF=" + CPF + ", email=" + email + ", telefone=" + telefone
				+ "]";
	}

	

	//toString
	
	
}
