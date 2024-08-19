package pl.bialek.business.dao.menagement;

import pl.bialek.infrastructure.database.entity.PartEntity;

import java.util.Optional;

public interface PartDAO {
    Optional<PartEntity> findBySerialNumber(String serialNumber);
}
