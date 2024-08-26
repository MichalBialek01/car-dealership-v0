package pl.bialek.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.bialek.domain.Mechanic;
import pl.bialek.infrastructure.database.entity.MechanicEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MechanicMapper {
    Mechanic mapFromEntity(MechanicEntity mechanicEntity);
}
