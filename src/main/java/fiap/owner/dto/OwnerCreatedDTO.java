package fiap.owner.dto;

import java.time.LocalDateTime;

public class OwnerCreatedDTO {


	private Integer id;
	private String name;
	private String cpf;
    private LocalDateTime data_nascimento;
    
    
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
