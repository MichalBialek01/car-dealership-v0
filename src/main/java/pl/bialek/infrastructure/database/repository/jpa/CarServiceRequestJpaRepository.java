package pl.bialek.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.bialek.domain.CarServiceRequest;
import pl.bialek.infrastructure.database.entity.CarServiceRequestEntity;

import java.util.Set;

@Repository
public interface CarServiceRequestJpaRepository extends JpaRepository<CarServiceRequestEntity,Integer> {
    @Query("""
        SELECT carServiceRequest FROM CarServiceRequestEntity carServiceRequest
        WHERE carServiceRequest.completedDateTime IS NULL
        AND
        carServiceRequest.car.vin = :vin
""")
    Set<CarServiceRequest> findActiveServiceRequestsByCarVin(final @Param("vin") String carVin);
}
