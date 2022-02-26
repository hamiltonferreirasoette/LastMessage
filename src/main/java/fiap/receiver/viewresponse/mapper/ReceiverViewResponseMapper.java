package fiap.receiver.viewresponse.mapper;

import org.springframework.stereotype.Component;

import fiap.receiver.dto.ReceiverDTO;
import fiap.receiver.viewresponse.ReceiverViewResponse;

@Component
public class ReceiverViewResponseMapper {

    public ReceiverViewResponse mapToReceiverViewResponse(ReceiverDTO receiverDTO) {
    	ReceiverViewResponse r = new ReceiverViewResponse();
        r.setId_receiver(receiverDTO.getId_receiver());
        r.setName(receiverDTO.getName());
        r.setCellphone(receiverDTO.getCellphone());
        r.setEmail(receiverDTO.getEmail());
        return r;
    }
    
}
