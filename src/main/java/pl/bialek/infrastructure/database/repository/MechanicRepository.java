package pl.bialek.infrastructure.database.repository;

import pl.bialek.business.dao.menagement.MechanicDAO;
import pl.bialek.infrastructure.database.entity.MechanicEntity;
import org.hibernate.Session;

import java.util.Objects;
import java.util.Optional;

public class MechanicRepository implements MechanicDAO {

    @Override
    public Optional<MechanicEntity> findByPesel(String pesel) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String hqlQuery = "SELECT mechanic FROM MechanicEntity mechanic WHERE mechanic.pesel = :pesel";
            Optional<MechanicEntity> queryResult = session.createQuery(hqlQuery, MechanicEntity.class)
                    .setParameter("pesel", pesel)
                    .uniqueResultOptional();
            session.getTransaction().commit();
            return queryResult;

        }
    }
}
