package fiap.contract.viewrequest;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import fiap.owner.viewrequest.OwnerViewRequest;
import fiap.receiver.viewrequest.ReceiverViewRequest;

public class ContractViewRequest {

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dataContract;

	private OwnerViewRequest owner;
	private ReceiverViewRequest receiver;

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

	public LocalDateTime getDataContract() {
		return dataContract;
	}

	public void setDataContract(LocalDateTime dataContract) {
        this.dataContract = dataContract;
    
	}	
}
