package fiap.receiver.service;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fiap.receiver.dto.ReceiverCreateDTO;
import fiap.receiver.dto.ReceiverCreatedDTO;
import fiap.receiver.dto.ReceiverDTO;
import fiap.receiver.entity.ReceiverEntity;
import fiap.receiver.entity.mapper.ReceiverEntityMapper;
import fiap.receiver.repository.IReceiverRepository;

@Service
public class ReceiverService {


    @Autowired
    private IReceiverRepository receiverRepository;

    @Autowired
    private ReceiverEntityMapper receiverEntityMapper;
    
    
    public ReceiverCreatedDTO save(ReceiverCreateDTO receiverCreateDTO) throws Exception {
        return save(receiverCreateDTO, ReceiverEntity -> {
        });
    }

    private ReceiverCreatedDTO save(ReceiverCreateDTO receiverCreateDTO, Consumer<ReceiverEntity> consumer){
    	ReceiverEntity receiverEntity = receiverEntityMapper.mapToReceiverEntity(receiverCreateDTO);
        consumer.accept(receiverEntity);
        receiverEntity = receiverRepository.save(receiverEntity);
        return receiverEntityMapper.mapToReceiverCreatedDTO(receiverEntity);
    }

    public ReceiverDTO findReceiver(Integer id) {
    	ReceiverEntity receiverEntity = receiverRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador do receiver inexistente"));
        return receiverEntityMapper.mapToReceiverDTO(receiverEntity);

    }

    public List<ReceiverDTO> findAllReceiver() {
        List<ReceiverEntity> receiverEntity = receiverRepository.findAll();
        return receiverEntity.stream()
                .map(receiverEntityMapper::mapToReceiverDTO)
                .collect(Collectors.toList());
    }
    
    public ReceiverDTO deleteReceiver(Integer codigo) {
    	ReceiverEntity o = receiverRepository.findById(codigo).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador do Medico Inexistente"));
    	receiverRepository.delete(o);
        return receiverEntityMapper.mapToReceiverDTO(o);
    }
    
    public ReceiverCreatedDTO editReceiver(ReceiverCreateDTO receiverCreateDTO, Integer id){
        return save(receiverCreateDTO, receiverEntity -> receiverEntity.setId_receiver(id));
    }
        
    
}