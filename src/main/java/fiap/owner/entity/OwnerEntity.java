package fiap.owner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_OWNER")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_owner;
    @Column
    private String name;
    @Column
    private String cpf;
    @Column
    private String cellphone;
    @Column
    private String email;
    
    
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