package pl.bialek.infrastructure.database.repository;

import pl.bialek.business.dao.CarToBuyDAO;
import pl.bialek.domain.CarToBuy;

import java.util.Optional;

public class CarToBuyRepository implements CarToBuyDAO {
    @Override
    public Optional<CarToBuy> findCarToBuyByVin(String vin) {
        return Optional.empty();
    }
}
