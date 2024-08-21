package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.CarToServiceDAO;
import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarToService;

import java.util.Optional;
@Repository
@AllArgsConstructor
public class CarToServiceRepository implements CarToServiceDAO {
    @Override
    public Optional<CarToService> findCarToServiceByVin(String vin) {
        return Optional.empty();
    }

    @Override
    public CarToService saveCarToService(CarToService carToService) {
        return null;
    }

    @Override
    public CarHistory findCarHistoryByVin(String vinNumber) {
        return null;
    }
}
