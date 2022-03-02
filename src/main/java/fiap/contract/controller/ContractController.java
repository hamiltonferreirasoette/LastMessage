package fiap.contract.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fiap.contract.dto.ContractCreateDTO;
import fiap.contract.dto.ContractCreatedDTO;
import fiap.contract.dto.ContractDTO;
import fiap.contract.service.ContractService;
import fiap.contract.viewrequest.ContractViewRequest;
import fiap.contract.viewrequest.mapper.ContractViewRequestMapper;
import fiap.contract.viewresponse.ContractViewResponse;
import fiap.contract.viewresponse.mapper.copy.ContractViewResponseMapper;

@RestController
public class ContractController {

	@Autowired
	private ContractViewRequestMapper contractViewRequestMapper;

	@Autowired
	private ContractService contractService;

	@Autowired
	private ContractViewResponseMapper contractViewResponseMapper;
	
	
	//hs
//	@Autowired
//	private AmqpService amqpService;
		
	
	@PostMapping(path = "/api/contract/add")
	public ResponseEntity<ContractViewResponse> save(@RequestBody ContractViewRequest contractViewRequest) throws Exception {
		ContractCreateDTO contractCreateDTO = contractViewRequestMapper.map(contractViewRequest);
		ContractCreatedDTO contractCreatedDTO = contractService.saveContract(contractCreateDTO);
		ContractDTO contractDTO = contractService.findContract(contractCreatedDTO.getContractId());		
		ContractViewResponse contractViewResponse = contractViewResponseMapper.mapToContractViewResponse(contractDTO);
//		amqpService.sendToConsumer(pacienteViewResponse);
		return ResponseEntity.status(HttpStatus.CREATED).body(contractViewResponse);	
	}
	
	@GetMapping(path = "/api/contract/{id}")
	public ResponseEntity<ContractViewResponse> consultar(@PathVariable("id") Integer id) {
		ContractDTO contractDTO = contractService.findContract(id.longValue());
		ContractViewResponse contractViewResponse = contractViewResponseMapper.mapToContractViewResponse(contractDTO);
//		amqpService.sendToConsumer(pacienteViewResponse);
		return ResponseEntity.ok(contractViewResponse);
	}

    @PutMapping(path = "/api/contract/{id}")
    public ResponseEntity<ContractViewResponse> alterar(@RequestBody ContractViewRequest contract,
                                                        @PathVariable("id") Integer id) {
    	
        ContractCreateDTO contractCreateDTO = contractViewRequestMapper.map(contract);
        ContractCreatedDTO contractCreatedDTO = contractService.updateContract(contractCreateDTO, id);
        ContractDTO contractDTO = contractService.findContract(contractCreatedDTO.getContractId());
        ContractViewResponse contractViewResponse = contractViewResponseMapper.mapToContractViewResponse(contractDTO);
        return ResponseEntity.ok(contractViewResponse);
    }
    
	@DeleteMapping(path = "/api/contract/delete/{id}")
	public ResponseEntity<ContractViewResponse> deletar(@PathVariable("id") Integer id) {
		ContractDTO contractDTO = contractService.deleteContract(id);
		ContractViewResponse contractViewResponse = contractViewResponseMapper.mapToContractViewResponse(contractDTO);
		return ResponseEntity.ok(contractViewResponse);
	}
	
	@GetMapping(path = "/api/contract/all")
	public ResponseEntity<List<ContractViewResponse>> all() {
		List<ContractDTO> list = contractService.findAllContracts();
		List<ContractViewResponse> responseList = list.stream().map(contractViewResponseMapper::mapToContractViewResponse)
				.collect(Collectors.toList());
		return ResponseEntity.ok(responseList);
	}
}