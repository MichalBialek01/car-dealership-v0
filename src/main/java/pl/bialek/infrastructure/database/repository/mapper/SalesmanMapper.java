package pl.bialek.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.bialek.domain.Salesman;
import pl.bialek.infrastructure.database.entity.SalesmanEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SalesmanMapper {
    Salesman mapFromEntity(SalesmanEntity salesmanEntity);
}
