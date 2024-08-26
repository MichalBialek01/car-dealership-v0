package pl.bialek;

import lombok.extern.slf4j.Slf4j;
import org.example.business.*;
import org.example.business.dao.menagement.*;
import pl.bialek.business.*;
import pl.bialek.business.dao.*;
import pl.bialek.business.menagement.CarDealershipManagementService;
import pl.bialek.business.menagement.DataPreparationService;
import org.example.infrastructure.database.repository.*;
import org.junit.jupiter.api.*;
import pl.bialek.infrastructure.database.repository.*;

/*
    Test class to enforce defined program path.
    Typically test classes shouldn't be used in this way, but for this particular example it does.

 */
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CarDealershipTest {

    private CarDealershipManagementService carDealershipManagementService;
    private CarPurchaseService carPurchaseService;
    private CarServiceRequestService carServiceRequestService;
    private CarServiceProcessingService carServiceProcessingService;
    private CarService carService;


    @Test
    @Order(1)
    void purge() {
        log.info("### Running order 1");
        carDealershipManagementService.purge();
    }

    @Test
    @Order(2)
    void init() {
        log.info("### Running order 2");
        carDealershipManagementService.init();
    }
    @Test
    @Order(3)
    void purchase() {
        log.info("### Running order 3");
        carPurchaseService.purchase();
    }

    @Order(4)
    @Test
    void makeServiceRequest() {
        log.info("### Running order 4");
        carServiceRequestService.requestService();
    }

    @Order(5)
    @Test
    void processServiceRequests() {
        log.info("### Running order 5");
        carServiceProcessingService.process();
    }

    @Test
    void printCarHistory() {
        log.info("### Running order 6");
        carService.printCarHistory("2C3CDYAG2DH731952");
    }


}
