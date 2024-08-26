package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.Mechanic;
import pl.bialek.infrastructure.database.entity.MechanicEntity;

public interface MechanicMapper {
    Mechanic mapFromEntity(MechanicEntity mechanicEntity);
}
