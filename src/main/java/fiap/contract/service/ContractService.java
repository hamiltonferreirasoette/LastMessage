package fiap.contract.service;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fiap.contract.dto.ContractCreateDTO;
import fiap.contract.dto.ContractCreatedDTO;
import fiap.contract.dto.ContractDTO;
import fiap.contract.entity.ContractEntity;
import fiap.contract.entity.mapper.ContractEntityMapper;
import fiap.contract.repository.IContractRepository;
import fiap.owner.entity.OwnerEntity;
import fiap.owner.repository.IOwnerRepository;
import fiap.receiver.entity.ReceiverEntity;
import fiap.receiver.repository.IReceiverRepository;

@Service
public class ContractService {

    @Autowired
    private IReceiverRepository receiverRepository;

    @Autowired
    private IOwnerRepository ownerRepository;

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private ContractEntityMapper contractEntityMapper;


    public ContractCreatedDTO saveContract(ContractCreateDTO contractCreateDTO) {
        return save(contractCreateDTO, contractEntity -> {
        });
    }

    private ContractCreatedDTO save(ContractCreateDTO contractCreateDTO, Consumer<ContractEntity> consumer) {
        ReceiverEntity receiver = receiverRepository.findById(contractCreateDTO.getReceiver().getId_receiver().intValue())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receiver inexistente"));

        OwnerEntity owner = ownerRepository.findById(contractCreateDTO.getOwner().getId_owner().intValue())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner Inexistente"));

        ContractEntity contractEntity = contractEntityMapper.mapToContractEntity(contractCreateDTO, owner, receiver);
        consumer.accept(contractEntity);
        contractEntity = contractRepository.save(contractEntity);
        return contractEntityMapper.mapToContractCreatedDTO(contractEntity);
    }

    public ContractDTO findContract(Long contractId) {
        ContractEntity contract = contractRepository.findById(contractId.intValue()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador da Contract Inexistente"));
        return contractEntityMapper.mapToContractDTO(contract);
    }

    public ContractCreatedDTO updateContract(ContractCreateDTO contractCreateDTO, Integer codigo) {
        return save(contractCreateDTO, contractEntity -> contractEntity.setCodigo(codigo));
    }

    public List<ContractDTO> findAllContracts() {
        List<ContractEntity> contracts = contractRepository.findAll();
        return contracts.stream().map(contractEntityMapper::mapToContractDTO).collect(Collectors.toList());
    }

    public ContractDTO deleteContract(Integer codigo) {
        ContractEntity c = contractRepository.findById(codigo).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador da Contract Inexistente"));
        contractRepository.delete(c);
        return contractEntityMapper.mapToContractDTO(c);
    }

    public List<ContractDTO> findContractByReceiver (Integer receiverId){
        ReceiverEntity receiver = receiverRepository.findById(receiverId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receiver inexistente"));
         List<ContractEntity> contracts = contractRepository.findByReceiver(receiver);
        return contracts.stream().map(contractEntityMapper::mapToContractDTO).collect(Collectors.toList());
    }


    public List<ContractDTO> findContractByOwner (Integer ownerId){
        OwnerEntity owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "owner inexistente"));
        List<ContractEntity> contracts = contractRepository.findByOwner(owner);
        return contracts.stream().map(contractEntityMapper::mapToContractDTO).collect(Collectors.toList());
    }

}