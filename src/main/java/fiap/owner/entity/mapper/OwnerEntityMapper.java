package fiap.owner.entity.mapper;

import org.springframework.stereotype.Component;

import fiap.owner.dto.OwnerCreateDTO;
import fiap.owner.dto.OwnerCreatedDTO;
import fiap.owner.dto.OwnerDTO;
import fiap.owner.entity.OwnerEntity;

@Component
public class OwnerEntityMapper {


    public OwnerDTO mapToOwnerDTO(OwnerEntity ownerEntity){

        OwnerDTO o = new OwnerDTO();

        o.setId_owner(ownerEntity.getId_owner());
        o.setName(ownerEntity.getName());
        o.setCpf(ownerEntity.getCpf());
        o.setCellphone(ownerEntity.getCellphone());
        o.setEmail(ownerEntity.getEmail());

        return o;
    }

    public OwnerEntity mapToOwnerEntity(OwnerCreateDTO ownerCreateDTO){

    	OwnerEntity o = new OwnerEntity();

        o.setId_owner(ownerCreateDTO.getId_owner());
        o.setName(ownerCreateDTO.getName());
        o.setCpf(ownerCreateDTO.getCpf());
        o.setCellphone(ownerCreateDTO.getCellphone());
        o.setEmail(ownerCreateDTO.getEmail());

        return o;
    }

    public OwnerCreatedDTO mapToOwnerCreatedDTO(OwnerEntity ownerEntity){

    	OwnerCreatedDTO o = new OwnerCreatedDTO();

        o.setId(ownerEntity.getId_owner());
        o.setName(ownerEntity.getName());
        o.setCpf(ownerEntity.getCpf()); 
        return o;


    }


}
