package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.Part;
import pl.bialek.infrastructure.database.entity.PartEntity;

public interface PartMapper {
    Part mapFromEntity(PartEntity partEntity);
}
