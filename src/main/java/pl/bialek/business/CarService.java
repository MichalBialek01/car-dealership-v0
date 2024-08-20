package pl.bialek.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.bialek.business.dao.CarDAO;
import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarServiceRequest;
import pl.bialek.domain.CarToBuy;
import pl.bialek.domain.CarToService;
import pl.bialek.infrastructure.database..CarHistory;
import pl.bialek.infrastructure.database..CarToBuy;
import pl.bialek.infrastructure.database..CarToService;

import java.util.Optional;
@AllArgsConstructor
@Slf4j
public class CarService {

    private final CarDAO carDAO;
    public CarToBuy findCarToBuy(String vin) {
        Optional<CarToBuy> carToBuyByVin = carDAO.findCarToBuyByVin(vin);
        if(carToBuyByVin.isEmpty()){
            throw new RuntimeException("Provided car with vin: [%s] doesn't exist".formatted(vin));
        }
        return carToBuyByVin.get();
    }

    public Optional<CarToService> findCarToService(String vin) {
        return carDAO.findCarToServiceByVin(vin);
    }

    public CarToService saveCarToService(CarToBuy carToBuy) {
        CarToService  = CarToService.builder()
                .vin(carToBuy.getVin())
                .brand(carToBuy.getBrand())
                .model(carToBuy.getModel())
                .year(carToBuy.getYear())
                .build();
        return carDAO.saveCarToService();
    }

    public CarToService saveCarToService(CarToService car) {
        CarToService  = CarToService.builder()
                .vin(car.getVin())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .build();
        return carDAO.saveCarToService();
    }


    public void printCarHistory(String vinNumber) {
        CarHistory carHistory = carDAO.findCarHistoryByVin(vinNumber);
    }




}
