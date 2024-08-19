package pl.bialek.business;

import lombok.AllArgsConstructor;
import pl.bialek.business.dao.ServiceDAO;
import pl.bialek.infrastructure.database.entity.ServiceEntity;

import java.util.Optional;

@AllArgsConstructor
public class ServiceCatalogService {
    private final ServiceDAO serviceDAO;

    public ServiceEntity findService(String serviceCode) {
        Optional<ServiceEntity> serviceEntity = serviceDAO.findByServiceCode(serviceCode);
        if (serviceEntity.isEmpty()) {
            throw new RuntimeException("Provided Service with serviceCode: [%s] doesn't exist".formatted(serviceCode));
        }
        return serviceEntity.get();
    }
}

