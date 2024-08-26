package pl.bialek.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarToService;
import pl.bialek.infrastructure.database.entity.CarToServiceEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarToServiceMapper {
    @Mapping(target = "carServiceRequests", ignore = true)
    CarToService mapFromEntity(CarToServiceEntity entity);

    CarHistory mapFromEntity(String vin, CarToServiceEntity entity);

    CarToServiceEntity mapToEntity(CarToService car);

};


