package fiap.contract.viewresponse;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import fiap.owner.viewresponse.OwnerViewResponse;
import fiap.receiver.viewresponse.ReceiverViewResponse;

@JsonInclude(Include.NON_NULL)
public class ContractViewResponse {

	private Integer codigo;
	private LocalDateTime dataContract;
	private ReceiverViewResponse receiver;
	private OwnerViewResponse owner;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getDataContract() {
		return dataContract;
	}

	public void setDataContract(LocalDateTime dataContract) {
		this.dataContract = dataContract;
	}

	public ReceiverViewResponse getReceiver() {
		return receiver;
	}

	public void setReceiver(ReceiverViewResponse receiver) {
		this.receiver = receiver;
	}

	public OwnerViewResponse getOwner() {
		return owner;
	}

	public void setOwner(OwnerViewResponse owner) {
		this.owner = owner;
	}
}