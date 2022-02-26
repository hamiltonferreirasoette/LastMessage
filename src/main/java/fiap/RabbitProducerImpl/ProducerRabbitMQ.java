//package fiap.microservice.RabbitProducerImpl;
//
//import org.springframework.amqp.AmqpRejectAndDontRequeueException;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import fiap.microservice.RabbitProducer.AmqpProducer;
//import fiap.microservice.paciente.viewresponse.PacienteViewResponse;
//
//@Component
//public class ProducerRabbitMQ implements AmqpProducer<PacienteViewResponse> {
//
//	@Autowired
//	private RabbitTemplate rabbitTemplate;
//
//	@Value("${spring.rabbitmq.request.routing-key.producer}")
//	private String queue;
//
//	@Value("${spring.rabbitmq.request.exchange.producer}")
//	private String exchange;
//
//	@Override
//	public void producer(PacienteViewResponse p) {
//		try {
//			rabbitTemplate.convertAndSend(exchange, queue, p);
//		} catch (Exception ex) {
//
//			throw new AmqpRejectAndDontRequeueException(ex);
//		}
//
//	}
//
//}
