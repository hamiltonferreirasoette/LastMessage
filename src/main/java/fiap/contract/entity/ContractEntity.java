package fiap.contract.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fiap.owner.entity.OwnerEntity;
import fiap.receiver.entity.ReceiverEntity;

@Entity
@Table(name = "TB_CONTRACT_OWNER_RECEIVER")
public class ContractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	private LocalDateTime data_contract;

	@ManyToOne()
	@JoinColumn(referencedColumnName = "id_receiver")
	private ReceiverEntity receiver;

	@ManyToOne()
	@JoinColumn(referencedColumnName = "id_owner")
	private OwnerEntity owner;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getData_contract() {
		return data_contract;
	}

	public void setData_contract(LocalDateTime data_contract) {
		this.data_contract = data_contract;
	}

	public ReceiverEntity getReceiver() {
		return receiver;
	}

	public void setReceiver(ReceiverEntity receiver) {
		this.receiver = receiver;
	}

	public OwnerEntity getOwner() {
		return owner;
	}

	public void setOwner(OwnerEntity owner) {
		this.owner = owner;
	}
}