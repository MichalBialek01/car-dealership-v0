package pl.bialek.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.bialek.domain.CarToBuy;
import pl.bialek.infrastructure.database.entity.CarToBuyEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarToBuyMapper {

    CarToBuy mapFromEntity(CarToBuyEntity carToBuyEntity);
}
