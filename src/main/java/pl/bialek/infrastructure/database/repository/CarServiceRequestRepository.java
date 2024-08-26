package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.CarServiceRequestDAO;
import pl.bialek.infrastructure.database.entity.CarServiceRequestEntity;
import pl.bialek.infrastructure.database.repository.jpa.CarServiceRequestJpaRepository;
import pl.bialek.infrastructure.database.repository.mapper.CarServiceRequestMapper;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class CarServiceRequestRepository implements CarServiceRequestDAO {
    private final CarServiceRequestJpaRepository carServiceRequestJpaRepository;
    private final CarServiceRequestMapper carServiceRequestEntityMapper;

    @Override
    public Set<CarServiceRequestEntity> findActiveServiceRequestsByCarVin(String carVin) {
        return carServiceRequestJpaRepository.findActiveServiceRequestsByCarVin(carVin)
                .stream()
                .map(carServiceRequestEntityMapper::mapFromEntity)
                .collect(Collectors.toSet());
    }
}
