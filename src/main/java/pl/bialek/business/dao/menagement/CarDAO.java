package pl.bialek.business.dao.menagement;

import pl.bialek.infrastructure.database.entity.CarHistoryEntity;
import pl.bialek.infrastructure.database.entity.CarToBuyEntity;
import pl.bialek.infrastructure.database.entity.CarToServiceEntity;

import java.util.Optional;

public interface CarDAO {
    Optional<CarToBuyEntity> findCarToBuyByVin(String vin);

    Optional<CarToServiceEntity> findCarToServiceByVin(String vin);

    CarToServiceEntity saveCarToService(CarToServiceEntity entity);

    CarHistoryEntity findCarHistoryByVin(String vinNumber);
}
