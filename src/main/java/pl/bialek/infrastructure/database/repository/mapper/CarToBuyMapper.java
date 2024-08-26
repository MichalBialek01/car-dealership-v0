package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.CarToBuy;
import pl.bialek.infrastructure.database.entity.CarToBuyEntity;

public interface CarToBuyMapper {
    CarToBuy mapFromEntity(CarToBuyEntity carToBuyEntity);
}
