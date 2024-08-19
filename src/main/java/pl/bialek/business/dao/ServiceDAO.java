package pl.bialek.business.dao;

import pl.bialek.infrastructure.database.entity.ServiceEntity;

import java.util.Optional;

public interface ServiceDAO {
    Optional<ServiceEntity> findByServiceCode(String serviceCode);

}
