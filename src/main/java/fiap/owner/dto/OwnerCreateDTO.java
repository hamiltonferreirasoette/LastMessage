package fiap.owner.dto;

public class OwnerCreateDTO {

	private Integer id_owner;
	private String name;
	private String cpf;
	private String cellphone;
	private String email;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String login) {
		this.username = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId_owner() {
		return id_owner;
	}

	public void setId_owner(Integer id_owner) {
		this.id_owner = id_owner;
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

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
