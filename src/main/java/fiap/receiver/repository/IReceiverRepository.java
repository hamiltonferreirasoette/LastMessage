package fiap.receiver.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fiap.receiver.entity.ReceiverEntity;

@Repository
public interface IReceiverRepository extends JpaRepository<ReceiverEntity, Integer> {
}