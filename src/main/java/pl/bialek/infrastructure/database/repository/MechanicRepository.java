package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.MechanicDAO;
import pl.bialek.domain.Mechanic;

import java.util.Optional;
@Repository
@AllArgsConstructor
public class MechanicRepository implements MechanicDAO {

    @Override
    public Optional<Mechanic> findByPesel(String pesel) {

    }
}
