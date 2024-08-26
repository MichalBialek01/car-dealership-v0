package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarToService;
import pl.bialek.infrastructure.database.entity.CarToServiceEntity;

public interface CarToServiceMapper {

    CarToService mapFromEntity(CarToServiceEntity entity);

    CarHistory mapFromEntity(String vin, CarToServiceEntity entity);

    CarToServiceEntity mapToEntity(CarToService car);

};


