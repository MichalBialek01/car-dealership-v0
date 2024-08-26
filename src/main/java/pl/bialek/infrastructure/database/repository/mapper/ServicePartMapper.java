package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.ServicePart;
import pl.bialek.infrastructure.database.entity.ServicePartEntity;

public interface ServicePartMapper {
    ServicePartEntity mapToEntity(ServicePart servicePart);
}
