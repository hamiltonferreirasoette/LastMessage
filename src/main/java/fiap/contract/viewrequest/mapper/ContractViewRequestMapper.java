package fiap.contract.viewrequest.mapper;

import org.springframework.stereotype.Component;

import fiap.contract.dto.ContractCreateDTO;
import fiap.contract.viewrequest.ContractViewRequest;

@Component
public class ContractViewRequestMapper {

    public ContractCreateDTO map(ContractViewRequest contract) {
        ContractCreateDTO c = new ContractCreateDTO();
        c.setDataContract(contract.getDataContract());
        c.setOwner(contract.getOwner());
        c.setReceiver(contract.getReceiver());
        return c;
    }

}