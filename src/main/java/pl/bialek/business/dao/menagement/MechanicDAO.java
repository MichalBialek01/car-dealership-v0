package pl.bialek.business.dao.menagement;

import pl.bialek.infrastructure.database.entity.MechanicEntity;

import java.util.Optional;

public interface MechanicDAO {
    Optional<MechanicEntity> findByPesel(String pesel);
}
