package fiap.receiver.viewresponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ReceiverViewResponse {

	private Integer id_receiver;
	private String name;
	private String cellphone;
	private String email;
	
	
	public Integer getId_receiver() {
		return id_receiver;
	}
	public void setId_receiver(Integer id_receiver) {
		this.id_receiver = id_receiver;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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