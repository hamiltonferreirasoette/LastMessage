//package fiap.microservice.RabbitService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import fiap.microservice.RabbitProducer.AmqpProducer;
//import fiap.microservice.paciente.viewresponse.PacienteViewResponse;
//
//@Service
//public class RabbitMQServiceImpl implements AmqpService {
//
//	@Autowired
//	private AmqpProducer<PacienteViewResponse> amqp;
//	
//	
//
//	@Override
//	public void sendToConsumer(PacienteViewResponse pacienteViewResponse) {
//		amqp.producer(pacienteViewResponse);
//
//	}
//
//}
