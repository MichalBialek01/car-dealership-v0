package pl.bialek.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bialek.business.dao.ServiceRequestProcessingDAO;
import pl.bialek.domain.CarServiceRequest;
import pl.bialek.domain.ServiceMechanic;
import pl.bialek.domain.ServicePart;

@Repository
@AllArgsConstructor
public class ServiceRequestProcessingRepository implements ServiceRequestProcessingDAO {
    @Override
    public void process(
            CarServiceRequest carServiceRequest,
            ServiceMechanic mechanic,
            ServicePart servicePart) {

    }


    @Override
    public void process(
            CarServiceRequest carServiceRequest,
            ServiceMechanic mechanic) {

    }
}
