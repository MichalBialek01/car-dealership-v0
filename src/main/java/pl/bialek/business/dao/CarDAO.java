package pl.bialek.business.dao;

import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarToBuy;
import pl.bialek.domain.CarToService;

import java.util.Optional;

public interface CarDAO {
    Optional<CarToBuy> findCarToBuyByVin(String vin);

    Optional<CarToService> findCarToServiceByVin(String vin);

    CarToService saveCarToService(CarToService carToService);

    CarHistory findCarHistoryByVin(String vinNumber);
}
