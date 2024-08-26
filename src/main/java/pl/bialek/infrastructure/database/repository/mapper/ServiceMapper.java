package pl.bialek.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.bialek.domain.Service;
import pl.bialek.infrastructure.database.entity.ServiceEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceMapper {
    Service mapFromEntity(ServiceEntity serviceEntity);
}
