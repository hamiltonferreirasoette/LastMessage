package fiap.owner.controller;

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

import fiap.owner.dto.OwnerCreateDTO;
import fiap.owner.dto.OwnerCreatedDTO;
import fiap.owner.dto.OwnerDTO;
import fiap.owner.service.OwnerService;
import fiap.owner.viewrequest.OwnerViewRequest;
import fiap.owner.viewrequest.mapper.OwnerViewRequestMapper;
import fiap.owner.viewresponse.OwnerViewResponse;
import fiap.owner.viewresponse.mapper.OwnerViewResponseMapper;

@RestController
public class OwnerController {

	@Autowired
	private OwnerViewRequestMapper ownerViewRequestMapper;

	@Autowired
	private OwnerService ownerService;

	@Autowired
	private OwnerViewResponseMapper ownerViewResponseMapper;
	

//	@Autowired
//	private AWSS3Service awsS3Service;
	
	
	//hs
//	@Autowired
//	private AmqpService amqpService;

	@PostMapping(path = "/api/owner")
	public ResponseEntity<OwnerViewResponse> save(@RequestBody OwnerViewRequest ownerViewRequest) throws Exception {
		OwnerCreateDTO ownerCreateDTO = ownerViewRequestMapper.map(ownerViewRequest);
		OwnerCreatedDTO ownerCreatedDTO = ownerService.save(ownerCreateDTO);
		OwnerDTO ownerDTO = ownerService.findOwner(ownerCreatedDTO.getId());		
		OwnerViewResponse ownerViewResponse = ownerViewResponseMapper.mapToOwnerViewResponse(ownerDTO);
//		amqpService.sendToConsumer(pacienteViewResponse);
		return ResponseEntity.status(HttpStatus.CREATED).body(ownerViewResponse);	
	}

	@GetMapping(path = "/api/owner/{id}")
	public ResponseEntity<OwnerViewResponse> consultar(@PathVariable("id") Integer id) {
		OwnerDTO ownerDTO = ownerService.findOwner(id);
		OwnerViewResponse ownerViewResponse = ownerViewResponseMapper.mapToOwnerViewResponse(ownerDTO);
//		amqpService.sendToConsumer(pacienteViewResponse);
		return ResponseEntity.ok(ownerViewResponse);
	}

    @PutMapping(path = "/api/owner/{id}")
    public ResponseEntity<OwnerViewResponse> alterar(@RequestBody OwnerViewRequest owner,
                                                        @PathVariable("id") Integer id) {
    	
        OwnerCreateDTO ownerCreateDTO = ownerViewRequestMapper.map(owner);
        OwnerCreatedDTO ownerCreatedDTO = ownerService.editOwner(ownerCreateDTO, id);
        OwnerDTO ownerDTO = ownerService.findOwner(ownerCreatedDTO.getId());
        OwnerViewResponse ownerViewResponse = ownerViewResponseMapper.mapToOwnerViewResponse(ownerDTO);
        return ResponseEntity.ok(ownerViewResponse);
    }
    
	@DeleteMapping(path = "/api/owner/delete/{id}")
	public ResponseEntity<OwnerViewResponse> deletar(@PathVariable("id") Integer id) {
		OwnerDTO ownerDTO = ownerService.deleteOwner(id);
		OwnerViewResponse ownerViewResponse = ownerViewResponseMapper.mapToOwnerViewResponse(ownerDTO);
		return ResponseEntity.ok(ownerViewResponse);
	}
	
	@GetMapping(path = "/api/owner/all")
	public ResponseEntity<List<OwnerViewResponse>> all() {
		List<OwnerDTO> list = ownerService.findAllOwner();
		List<OwnerViewResponse> responseList = list.stream().map(ownerViewResponseMapper::mapToOwnerViewResponse)
				.collect(Collectors.toList());
		return ResponseEntity.ok(responseList);
	}
	
	//
	
	
//	@PostMapping(path = "/api/file")
//	public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
//		String publicURL = awsS3Service.uploadFile(file);
//		Map<String, String> response = new HashMap<>();
//		response.put("publicURL", publicURL);
//		return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
//	}
	
	
	
}