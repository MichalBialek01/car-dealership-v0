package pl.bialek.business.dao.menagement;

import pl.bialek.infrastructure.database.entity.SalesmanEntity;

import java.util.Optional;

public interface SalesmanDAO {
    Optional<SalesmanEntity> findByPesel(String pesel);
}
