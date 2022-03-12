package fiap.receiver.controller;

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

import fiap.receiver.dto.ReceiverCreateDTO;
import fiap.receiver.dto.ReceiverCreatedDTO;
import fiap.receiver.dto.ReceiverDTO;
import fiap.receiver.service.ReceiverService;
import fiap.receiver.viewrequest.ReceiverViewRequest;
import fiap.receiver.viewrequest.mapper.ReceiverViewRequestMapper;
import fiap.receiver.viewresponse.ReceiverViewResponse;
import fiap.receiver.viewresponse.mapper.ReceiverViewResponseMapper;

@RestController
public class ReceiverController {

	@Autowired
	private ReceiverViewRequestMapper receiverViewRequestMapper;

	@Autowired
	private ReceiverService receiverService;

	@Autowired
	private ReceiverViewResponseMapper receiverViewResponseMapper;
	

	@PostMapping(path = "/api/receiver")
	public ResponseEntity<ReceiverViewResponse> save(@RequestBody ReceiverViewRequest receiverViewRequest) throws Exception {
		ReceiverCreateDTO receiverCreateDTO = receiverViewRequestMapper.map(receiverViewRequest);
		ReceiverCreatedDTO receiverCreatedDTO = receiverService.save(receiverCreateDTO);
		ReceiverDTO receiverDTO = receiverService.findReceiver(receiverCreatedDTO.getId_receiver());		
		ReceiverViewResponse receiverViewResponse = receiverViewResponseMapper.mapToReceiverViewResponse(receiverDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(receiverViewResponse);	
	}

	@GetMapping(path = "/api/receiver/{id}")
	public ResponseEntity<ReceiverViewResponse> consultar(@PathVariable("id") Integer id) {
		ReceiverDTO receiverDTO = receiverService.findReceiver(id);
		ReceiverViewResponse receiverViewResponse = receiverViewResponseMapper.mapToReceiverViewResponse(receiverDTO);
		return ResponseEntity.ok(receiverViewResponse);
	}

    @PutMapping(path = "/api/receiver/{id}")
    public ResponseEntity<ReceiverViewResponse> alterar(@RequestBody ReceiverViewRequest receiver,
                                                        @PathVariable("id") Integer id) {
    	
        ReceiverCreateDTO receiverCreateDTO = receiverViewRequestMapper.map(receiver);
        ReceiverCreatedDTO receiverCreatedDTO = receiverService.editReceiver(receiverCreateDTO, id);
        ReceiverDTO receiverDTO = receiverService.findReceiver(receiverCreatedDTO.getId_receiver());
        ReceiverViewResponse receiverViewResponse = receiverViewResponseMapper.mapToReceiverViewResponse(receiverDTO);
        return ResponseEntity.ok(receiverViewResponse);
    }
    
	@DeleteMapping(path = "/api/receiver/delete/{id}")
	public ResponseEntity<ReceiverViewResponse> deletar(@PathVariable("id") Integer id) {
		ReceiverDTO receiverDTO = receiverService.deleteReceiver(id);
		ReceiverViewResponse receiverViewResponse = receiverViewResponseMapper.mapToReceiverViewResponse(receiverDTO);
		return ResponseEntity.ok(receiverViewResponse);
	}
	
	@GetMapping(path = "/api/receiver/all")
	public ResponseEntity<List<ReceiverViewResponse>> all() {
		List<ReceiverDTO> list = receiverService.findAllReceiver();
		List<ReceiverViewResponse> responseList = list.stream().map(receiverViewResponseMapper::mapToReceiverViewResponse)
				.collect(Collectors.toList());
		return ResponseEntity.ok(responseList);
	}
}