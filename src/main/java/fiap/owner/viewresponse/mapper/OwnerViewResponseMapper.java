package fiap.owner.viewresponse.mapper;

import org.springframework.stereotype.Component;

import fiap.owner.dto.OwnerDTO;
import fiap.owner.viewresponse.OwnerViewResponse;

@Component
public class OwnerViewResponseMapper {

    public OwnerViewResponse mapToOwnerViewResponse(OwnerDTO ownerDTO) {
    	OwnerViewResponse o = new OwnerViewResponse();
        o.setId_owner(ownerDTO.getId_owner());
        o.setNome(ownerDTO.getName());
        o.setCpf(ownerDTO.getCpf());
        o.setCellphone(ownerDTO.getCellphone());
        o.setEmail(ownerDTO.getEmail());
        o.setUsername(ownerDTO.getUsername());
        return o;
    }
    
}
