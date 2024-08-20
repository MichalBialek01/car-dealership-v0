package pl.bialek.infrastructure.database.repository;

import pl.bialek.business.dao.ServiceRequestProcessingDAO;
import pl.bialek.domain.CarServiceRequest;
import pl.bialek.domain.ServiceMechanic;
import pl.bialek.domain.ServicePart;

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
