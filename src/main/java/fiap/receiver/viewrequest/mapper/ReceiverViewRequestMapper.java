package fiap.receiver.viewrequest.mapper;

import org.springframework.stereotype.Component;

import fiap.receiver.dto.ReceiverCreateDTO;
import fiap.receiver.viewrequest.ReceiverViewRequest;

@Component
public class ReceiverViewRequestMapper {

    public ReceiverCreateDTO map(ReceiverViewRequest receiverViewRequest) {
    	
        ReceiverCreateDTO r = new ReceiverCreateDTO();
        
        r.setName(receiverViewRequest.getName());
        r.setCellphone(receiverViewRequest.getCellphone());
        r.setEmail(receiverViewRequest.getEmail());
        return r;
        }

}
