package pl.bialek.business.dao;

import pl.bialek.infrastructure.database.entity.CarServiceRequestEntity;
import pl.bialek.infrastructure.database.entity.ServiceMechanicEntity;
import pl.bialek.infrastructure.database.entity.ServicePartEntity;

public interface ServiceRequestProcessingDAO {
    void process(CarServiceRequestEntity carServiceRequest, ServiceMechanicEntity mechanicEntity, ServicePartEntity servicePartEntity);

    void process(CarServiceRequestEntity carServiceRequest, ServiceMechanicEntity mechanicEntity);
}
