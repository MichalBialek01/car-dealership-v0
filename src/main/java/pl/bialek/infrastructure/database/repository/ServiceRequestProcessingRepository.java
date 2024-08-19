package pl.bialek.infrastructure.database.repository;

import pl.bialek.business.dao.menagement.ServiceRequestProcessingDAO;
import pl.bialek.infrastructure.database.entity.CarServiceRequestEntity;
import pl.bialek.infrastructure.database.entity.PartEntity;
import pl.bialek.infrastructure.database.entity.ServiceMechanicEntity;
import pl.bialek.infrastructure.database.entity.ServicePartEntity;
import org.hibernate.Session;

import java.util.Objects;

public class ServiceRequestProcessingRepository implements ServiceRequestProcessingDAO {
    @Override
    public void process(
            CarServiceRequestEntity carServiceRequest,
            ServiceMechanicEntity mechanicEntity,
            ServicePartEntity servicePartEntity) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(mechanicEntity);

            Integer partId = servicePartEntity.getPart().getPartId();
            PartEntity partEntity = session.find(PartEntity.class, partId);
            servicePartEntity.setPart(partEntity);
            session.persist(servicePartEntity)   ;

            //Synchronization that serviceRequest was finished
            if (Objects.nonNull(carServiceRequest.getCompletedDateTime())) {
                session.merge(carServiceRequest);
            }

            session.getTransaction().commit();

        }
    }

    @Override
    public void process(
            CarServiceRequestEntity carServiceRequest,
            ServiceMechanicEntity mechanicEntity) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(mechanicEntity);
            if (Objects.nonNull(carServiceRequest.getCompletedDateTime())) {
                session.merge(carServiceRequest);
            }
            session.getTransaction().commit();
        }
    }
}
