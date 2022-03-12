package fiap.owner.dto;

import java.time.LocalDateTime;

public class OwnerCreatedDTO {


	private Integer id;
	private String name;
	private String cpf;
    private LocalDateTime data_nascimento;
	private String username;
	private String password;
    
    
	public String getUSername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDateTime getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(LocalDateTime data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	
	

	


}
