package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.Salesman;
import pl.bialek.infrastructure.database.entity.SalesmanEntity;

public interface SalesmanMapper {
    Salesman mapFromEntity(SalesmanEntity salesmanEntity);
}
