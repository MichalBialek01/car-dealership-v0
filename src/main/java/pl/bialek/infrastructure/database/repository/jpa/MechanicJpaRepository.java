package pl.bialek.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.infrastructure.database.entity.MechanicEntity;

@Repository
public interface MechanicJpaRepository extends JpaRepository<MechanicEntity, Integer> {


}