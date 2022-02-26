package fiap.owner.viewrequest.mapper;

import org.springframework.stereotype.Component;

import fiap.owner.dto.OwnerCreateDTO;
import fiap.owner.viewrequest.OwnerViewRequest;

@Component
public class OwnerViewRequestMapper {

    public OwnerCreateDTO map(OwnerViewRequest ownerViewRequest) {
        OwnerCreateDTO o = new OwnerCreateDTO();
        o.setName(ownerViewRequest.getName());
        o.setCpf(ownerViewRequest.getCpf());
        o.setCellphone(ownerViewRequest.getCellphone());
        o.setEmail(ownerViewRequest.getEmail());
        return o;
        }
}
