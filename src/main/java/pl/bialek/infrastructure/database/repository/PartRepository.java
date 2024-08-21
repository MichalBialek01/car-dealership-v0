package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.PartDAO;
import pl.bialek.domain.Part;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PartRepository implements PartDAO {
    @Override
    public Optional<Part> findBySerialNumber(String serialNumber) {


    }
}
