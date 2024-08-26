package pl.bialek.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.bialek.domain.Salesman;
import pl.bialek.infrastructure.database.entity.SalesmanEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SalesmanMapper {
    @Mapping(target = "invoices")
    Salesman mapFromEntity(SalesmanEntity salesmanEntity);
}
