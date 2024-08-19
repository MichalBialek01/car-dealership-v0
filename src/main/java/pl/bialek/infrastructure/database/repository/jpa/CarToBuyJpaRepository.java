package pl.bialek.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.infrastructure.database.entity.CarToBuyEntity;

@Repository

public interface CarToBuyJpaRepository extends JpaRepository<CarToBuyEntity,Integer> {

}
