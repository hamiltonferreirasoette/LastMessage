package fiap.contract.entity.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fiap.contract.dto.ContractCreateDTO;
import fiap.contract.dto.ContractCreatedDTO;
import fiap.contract.dto.ContractDTO;
import fiap.contract.entity.ContractEntity;
import fiap.owner.entity.OwnerEntity;
import fiap.owner.entity.mapper.OwnerEntityMapper;
import fiap.receiver.entity.ReceiverEntity;
import fiap.receiver.entity.mapper.ReceiverEntityMapper;

@Component
public class ContractEntityMapper {

    @Autowired
    private OwnerEntityMapper ownerEntityMapper;

    @Autowired
    private ReceiverEntityMapper receiverEntityMapper;

    public ContractEntity mapToContractEntity(ContractCreateDTO contractCreateDTO,
                                              OwnerEntity ownerEntity,
                                              ReceiverEntity receiverEntity
                                              ) {

        ContractEntity c = new ContractEntity();
        c.setData_contract(contractCreateDTO.getDataContract());
        c.setOwner(ownerEntity);
        c.setReceiver(receiverEntity);
        return c;
    }


    public ContractCreatedDTO mapToContractCreatedDTO(ContractEntity contractEntity) {

        ContractCreatedDTO c = new ContractCreatedDTO();
        c.setContractId(contractEntity.getCodigo());
        c.setDataContract(contractEntity.getData_contract());
        return c;

    }

    public ContractDTO mapToContractDTO(ContractEntity contractEntity) {

        ContractDTO c = new ContractDTO();
        c.setCodigo(contractEntity.getCodigo());
        c.setData_contract(contractEntity.getData_contract());
        c.setOwner(ownerEntityMapper.mapToOwnerDTO(contractEntity.getOwner()));
        c.setReceiver(receiverEntityMapper.mapToReceiverDTO(contractEntity.getReceiver()));

        return c;
    }

}