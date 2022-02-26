package fiap.owner.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fiap.owner.entity.OwnerEntity;

@Repository
public interface IOwnerRepository extends JpaRepository<OwnerEntity, Integer> {

}
