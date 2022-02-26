package fiap.contract.viewresponse.mapper.copy;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fiap.contract.dto.ContractDTO;
import fiap.contract.viewresponse.ContractViewResponse;
import fiap.owner.viewresponse.mapper.OwnerViewResponseMapper;
import fiap.receiver.viewresponse.mapper.ReceiverViewResponseMapper;

@Component
public class ContractViewResponseMapper {

	@Autowired
	private OwnerViewResponseMapper ownerViewResponseMapper;

	@Autowired
	private ReceiverViewResponseMapper receiverViewResponseMapper;

	public ContractViewResponse mapToContractViewResponse(ContractDTO contractDTO) {
		ContractViewResponse c = new ContractViewResponse();
		c.setCodigo(contractDTO.getCodigo());
		c.setDataContract(contractDTO.getData_contract());
		c.setOwner(ownerViewResponseMapper.mapToOwnerViewResponse(contractDTO.getOwner()));
		c.setReceiver(receiverViewResponseMapper.mapToReceiverViewResponse(contractDTO.getReceiver()));

		return c;
	}

	public List<ContractViewResponse> mapToContractViewResponse(List<ContractDTO> lista) {
		return lista.stream().map(this::mapToContractViewResponse).collect(Collectors.toList());
	}

}