package pl.bialek.infrastructure.database.repository.mapper;

import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarToService;
import pl.bialek.infrastructure.database.entity.CarToServiceEntity;

public interface CarToServiceMapper {
    CarToService mapFromEntity(CarToServiceEntity carToService);

    CarToServiceEntity mapToEntity(CarToService carToService);

    CarHistory mapFromEntity(String vinNumber, CarToServiceEntity carHistoryByVin);
}
