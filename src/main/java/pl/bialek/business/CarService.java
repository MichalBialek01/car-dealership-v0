package pl.bialek.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.bialek.business.dao.CarDAO;
import pl.bialek.domain.CarHistory;
import pl.bialek.domain.CarToBuy;
import pl.bialek.domain.CarToService;

import java.util.Optional;

@AllArgsConstructor
@Slf4j
public class CarService {

    private final CarDAO carDAO;

    public CarToBuy findCarToBuy(String vin) {
        Optional<CarToBuy> carToBuyByVin = carDAO.findCarToBuyByVin(vin);
        if (carToBuyByVin.isEmpty()) {
            throw new RuntimeException("Provided car with vin: [%s] doesn't exist".formatted(vin));
        }
        return carToBuyByVin.get();
    }

    public Optional<CarToService> findCarToService(String vin) {
        return carDAO.findCarToServiceByVin(vin);
    }

    public CarToService saveCarToService(CarToBuy carToBuy) {
        CarToService carToService = CarToService.builder()
                .vin(carToBuy.getVin())
                .brand(carToBuy.getBrand())
                .model(carToBuy.getModel())
                .year(carToBuy.getYear())
                .build();
        return carDAO.saveCarToService(carToService);
    }

    public CarToService saveCarToService(CarToService car) {
        CarToService carToService = CarToService.builder()
                .vin(car.getVin())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .build();
        return carDAO.saveCarToService(carToService);
    }


    public void printCarHistory(String vinNumber) {
        CarHistory carHistoryByVin = carDAO.findCarHistoryByVin(vinNumber);
        log.info("Car History for car with VIN: [{}]", vinNumber);
        carHistoryByVin.getCarServiceRequests().forEach(this::printServiceRequest);
    }

    private void printServiceRequest(CarHistory.CarServiceRequest carServiceRequest) {
        log.info("Service request [{}]", carServiceRequest);
        carServiceRequest.getServices().forEach(service -> log.info("Service: [{}]", service));
        carServiceRequest.getParts().forEach(part -> log.info("Part: [{}]", part));
    }

}
