package fiap.receiver.entity.mapper;

import org.springframework.stereotype.Component;

import fiap.receiver.dto.ReceiverCreateDTO;
import fiap.receiver.dto.ReceiverCreatedDTO;
import fiap.receiver.dto.ReceiverDTO;
import fiap.receiver.entity.ReceiverEntity;

@Component
public class ReceiverEntityMapper {

	public ReceiverDTO mapToReceiverDTO(ReceiverEntity receiverEntity) {

		ReceiverDTO r = new ReceiverDTO();

		r.setId_receiver(receiverEntity.getId_receiver());
		r.setName(receiverEntity.getName());
		r.setCellphone(receiverEntity.getCellphone());
		r.setEmail(receiverEntity.getEmail());

		return r;
	}

	public ReceiverEntity mapToReceiverEntity(ReceiverCreateDTO receiverCreateDTO) {

		ReceiverEntity r = new ReceiverEntity();

		r.setId_receiver(receiverCreateDTO.getId_receiver());
		r.setName(receiverCreateDTO.getName());
		r.setCellphone(receiverCreateDTO.getCellphone());
		r.setEmail(receiverCreateDTO.getEmail());
		return r;
	}

	public ReceiverCreatedDTO mapToReceiverCreatedDTO(ReceiverEntity receiverEntity) {

		ReceiverCreatedDTO r = new ReceiverCreatedDTO();

		r.setId_receiver(receiverEntity.getId_receiver());
		r.setName(receiverEntity.getName());
		return r;

	}

}
