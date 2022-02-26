package fiap.contract.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fiap.contract.entity.ContractEntity;
import fiap.owner.entity.OwnerEntity;
import fiap.receiver.entity.ReceiverEntity;

@Repository
public interface IContractRepository extends JpaRepository<ContractEntity, Integer> {
	

    List<ContractEntity> findByReceiver (ReceiverEntity id);

    List<ContractEntity> findByOwner (OwnerEntity id);
}

