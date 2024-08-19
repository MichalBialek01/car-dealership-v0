package pl.bialek.business;

import lombok.AllArgsConstructor;
import pl.bialek.business.dao.CarDAO;
import pl.bialek.infrastructure.database.entity.CarHistoryEntity;
import pl.bialek.infrastructure.database.entity.CarToBuyEntity;
import pl.bialek.infrastructure.database.entity.CarToServiceEntity;

import java.util.Optional;
@AllArgsConstructor
public class CarService {

    private final CarDAO carDAO;
    public CarToBuyEntity findCarToBuy(String vin) {
        Optional<CarToBuyEntity> carToBuyByVin = carDAO.findCarToBuyByVin(vin);
        if(carToBuyByVin.isEmpty()){
            throw new RuntimeException("Provided car with vin: [%s] doesn't exist".formatted(vin));
        }
        return carToBuyByVin.get();
    }

    public Optional<CarToServiceEntity> findCarToService(String vin) {
        return carDAO.findCarToServiceByVin(vin);
    }

    public CarToServiceEntity saveCarToService(CarToBuyEntity carToBuy) {
        CarToServiceEntity entity = CarToServiceEntity.builder()
                .vin(carToBuy.getVin())
                .brand(carToBuy.getBrand())
                .model(carToBuy.getModel())
                .year(carToBuy.getYear())
                .build();
        return carDAO.saveCarToService(entity);
    }

    public CarToServiceEntity saveCarToService(CarServiceRequest.Car car) {
        CarToServiceEntity entity = CarToServiceEntity.builder()
                .vin(car.getVin())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .build();
        return carDAO.saveCarToService(entity);
    }


    public void printCarHistory(String vinNumber) {
        CarHistoryEntity carHistoryEntity = carDAO.findCarHistoryByVin(vinNumber);
    }
}
