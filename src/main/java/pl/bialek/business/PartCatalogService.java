package pl.bialek.business;

import lombok.AllArgsConstructor;
import pl.bialek.business.dao.menagement.PartDAO;
import pl.bialek.infrastructure.database.entity.PartEntity;

import java.util.Optional;

@AllArgsConstructor
public class PartCatalogService {
    private final PartDAO partDAO;

    public PartEntity findPart(String partSerialNumber) {
            Optional<PartEntity> partEntity = partDAO.findBySerialNumber(partSerialNumber);
            if (partEntity.isEmpty()) {
                throw new RuntimeException("Provided part with part serial number: [%s] doesn't exist".formatted(partSerialNumber));
            }
            return partEntity.get();
    }
}
