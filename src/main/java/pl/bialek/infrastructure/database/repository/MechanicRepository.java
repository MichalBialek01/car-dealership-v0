package pl.bialek.infrastructure.database.repository;

import pl.bialek.business.dao.MechanicDAO;
import pl.bialek.domain.Mechanic;
import pl.bialek.infrastructure.database.entity.MechanicEntity;
import org.hibernate.Session;

import java.util.Objects;
import java.util.Optional;

public class MechanicRepository implements MechanicDAO {

    @Override
    public Optional<Mechanic> findByPesel(String pesel) {

    }
}
