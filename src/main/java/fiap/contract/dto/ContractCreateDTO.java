package fiap.contract.dto;

import java.time.LocalDateTime;

import fiap.owner.viewrequest.OwnerViewRequest;
import fiap.receiver.viewrequest.ReceiverViewRequest;

public class ContractCreateDTO {

	private LocalDateTime dataContract;

	private OwnerViewRequest owner;
	private ReceiverViewRequest receiver;

	public LocalDateTime getDataContract() {
		return dataContract;
	}

	public void setDataContract(LocalDateTime dataContract) {
		this.dataContract = dataContract;
	}

	public OwnerViewRequest getOwner() {
		return owner;
	}

	public void setOwner(OwnerViewRequest owner) {
		this.owner = owner;
	}

	public ReceiverViewRequest getReceiver() {
		return receiver;
	}

	public void setReceiver(ReceiverViewRequest receiver) {
		this.receiver = receiver;
	}
	
}
