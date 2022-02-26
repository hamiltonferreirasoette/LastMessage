package fiap.contract.dto;

import java.time.LocalDateTime;

import fiap.owner.dto.OwnerDTO;
import fiap.receiver.dto.ReceiverDTO;

public class ContractDTO {

	private Integer codigo;
	private LocalDateTime data_contract;
	private ReceiverDTO receiver;
	private OwnerDTO owner;

	public ReceiverDTO getReceiver() {
		return receiver;
	}

	public OwnerDTO getOwner() {
		return owner;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getData_contract() {
		return data_contract;
	}

	public void setData_contract(LocalDateTime data_contract) {
		this.data_contract = data_contract;
	}

	public void setReceiver(ReceiverDTO receiver) {
		this.receiver = receiver;
	}

	public void setOwner(OwnerDTO owner) {
		this.owner = owner;
	}
}