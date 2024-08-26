package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.Service;
import pl.bialek.infrastructure.database.entity.ServiceEntity;

public interface ServiceMapper {
    Service mapFromEntity(ServiceEntity serviceEntity);
}
