package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.CarServiceRequest;
import pl.bialek.infrastructure.database.entity.CarServiceRequestEntity;

public interface CarServiceRequestMapper {
    CarServiceRequest mapFromEntity(CarServiceRequestEntity carServiceRequestEntity);

    CarServiceRequestEntity mapToEntity(CarServiceRequest carServiceRequest);
}
