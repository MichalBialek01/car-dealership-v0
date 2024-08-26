package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.ServiceMechanic;
import pl.bialek.infrastructure.database.entity.ServiceMechanicEntity;

public interface ServiceMechanicMapper {
    ServiceMechanicEntity mapToEntity(ServiceMechanic serviceMechanic);
}
