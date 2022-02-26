package fiap.owner.service;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fiap.owner.dto.OwnerCreateDTO;
import fiap.owner.dto.OwnerCreatedDTO;
import fiap.owner.dto.OwnerDTO;
import fiap.owner.entity.OwnerEntity;
import fiap.owner.entity.mapper.OwnerEntityMapper;
import fiap.owner.repository.IOwnerRepository;

@Service
public class OwnerService {


    @Autowired
    private IOwnerRepository ownerRepository;

    @Autowired
    private OwnerEntityMapper ownerEntityMapper;
    
    
    public OwnerCreatedDTO save(OwnerCreateDTO ownerCreateDTO) throws Exception {
        return save(ownerCreateDTO, OwnerEntity -> {
        });
    }

    private OwnerCreatedDTO save(OwnerCreateDTO ownerCreateDTO, Consumer<OwnerEntity> consumer){
    	OwnerEntity ownerEntity = ownerEntityMapper.mapToOwnerEntity(ownerCreateDTO);
        consumer.accept(ownerEntity);
        ownerEntity = ownerRepository.save(ownerEntity);
        return ownerEntityMapper.mapToOwnerCreatedDTO(ownerEntity);
    }

    public OwnerDTO findOwner(Integer id) {
    	OwnerEntity ownerEntity = ownerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador do owner inexistente"));
        return ownerEntityMapper.mapToOwnerDTO(ownerEntity);

    }

    public List<OwnerDTO> findAllOwner() {
        List<OwnerEntity> ownerEntity = ownerRepository.findAll();
        return ownerEntity.stream()
                .map(ownerEntityMapper::mapToOwnerDTO)
                .collect(Collectors.toList());
    }
    
    public OwnerDTO deleteOwner(Integer codigo) {
    	OwnerEntity o = ownerRepository.findById(codigo).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador do Medico Inexistente"));
    	ownerRepository.delete(o);
        return ownerEntityMapper.mapToOwnerDTO(o);
    }
    
    public OwnerCreatedDTO editOwner(OwnerCreateDTO ownerCreateDTO, Integer id){
        return save(ownerCreateDTO, ownerEntity -> ownerEntity.setId_owner(id));
    }
        
    
}