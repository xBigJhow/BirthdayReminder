package registraAniversario.model;
import java.sql.Date;


public class Pessoa {
	private int id;
	private String nome;
	private Date dataNascimento;
	private String obs;
	
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	public Pessoa(int id, String nome, Date dataNascimento, String obs) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.obs = obs;
	}
	
	public Pessoa(String nome, Date dataNascimento, String obs) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.obs = obs;
	}

}
