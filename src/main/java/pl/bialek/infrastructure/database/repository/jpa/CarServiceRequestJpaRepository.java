package pl.bialek.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.domain.CarServiceRequest;
import pl.bialek.infrastructure.database.entity.CarServiceRequestEntity;

@Repository

public interface CarServiceRequestJpaRepository extends JpaRepository<CarServiceRequestEntity,Integer> {

}
