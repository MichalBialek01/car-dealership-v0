package pl.bialek.business.dao.menagement;

import pl.bialek.infrastructure.database.entity.CarServiceRequestEntity;

import java.util.Set;

public interface CarServiceRequestDAO {
    Set<CarServiceRequestEntity> findActiveServiceRequestsByCarVin(String carVin);
}
