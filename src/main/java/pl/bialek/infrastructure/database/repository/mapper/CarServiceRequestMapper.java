package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.CarServiceRequest;
import pl.bialek.infrastructure.database.entity.CarServiceRequestEntity;

public interface CarServiceRequestMapper {
    CarServiceRequestEntity mapFromEntity(CarServiceRequest carServiceRequest);
}
