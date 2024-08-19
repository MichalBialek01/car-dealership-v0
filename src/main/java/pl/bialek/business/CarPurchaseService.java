package pl.bialek.business;

import lombok.AllArgsConstructor;
import pl.bialek.business.menagement.DataPreparationService;
import pl.bialek.business.menagement.Keys;
import pl.bialek.infrastructure.database.entity.CarToBuyEntity;
import pl.bialek.infrastructure.database.entity.CustomerEntity;
import pl.bialek.infrastructure.database.entity.InvoiceEntity;
import pl.bialek.infrastructure.database.entity.SalesmanEntity;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class CarPurchaseService {
//That class provides functionality to buy a car by costumers, it means that seller issues invoice for certain car.

    private final DataPreparationService dataPreparationService;
    private final CustomerService customerService;
    private final CarService carService;
    private final SalesmanService salesmanSercice;

    public void purchase() {
        var firstTimeData = dataPreparationService.prepareFirstTimePurchaseData();
        var nextTimeData = dataPreparationService.prepareNextTimePurchaseData();

        List<CustomerEntity> firstTimeCustomers = firstTimeData.stream()
                .map(this::createFirtTimeToBuyCustomer)
                .toList();
        firstTimeCustomers.forEach(customerService::issueInvoice);

        List<CustomerEntity> nextTimeCustomers = nextTimeData.stream()
                .map(this::createNextTimeToBuyCustomer)
                .toList();
        nextTimeCustomers.forEach(customerService::issueInvoice);
    }

    private CustomerEntity createFirtTimeToBuyCustomer(Map<String, List<String>> inputData) {
        //Catching car - having single value (VIN)
        CarToBuyEntity car = carService.findCarToBuy(inputData.get(Keys.Entity.CAR.toString()).get(0));
        //Caching Salesman - having single value (PESEL)
        SalesmanEntity salesman = salesmanSercice.findSalesman(inputData.get(Keys.Entity.SALESMAN.toString()).get(0));
        //Building Invoice basing on buingCar and salesman
        InvoiceEntity invoice = buildInvoice(car, salesman);

        return dataPreparationService.buildCustomerEntity(inputData.get(Keys.Entity.CUSTOMER.toString()), invoice);


    }

    private CustomerEntity createNextTimeToBuyCustomer(Map<String, List<String>> inputData) {
        CustomerEntity exisitngCustomer = customerService.findCustomer(inputData.get(Keys.Entity.CUSTOMER.toString()).get(0));
        //Catching car - having single value (VIN)
        CarToBuyEntity car = carService.findCarToBuy(inputData.get(Keys.Entity.CAR.toString()).get(0));
        //Caching Salesman - having single value (PESEL)
        SalesmanEntity salesman = salesmanSercice.findSalesman(inputData.get(Keys.Entity.SALESMAN.toString()).get(0));
        //Building Invoice basing on buingCar and salesman
        InvoiceEntity invoice = buildInvoice(car, salesman);
        exisitngCustomer.getInvoices().add(invoice);
        return exisitngCustomer;
    }


    private InvoiceEntity buildInvoice(CarToBuyEntity car, SalesmanEntity salesman) {
        return InvoiceEntity
                .builder()
                .invoiceNumber(UUID.randomUUID().toString())
                .dateTime(OffsetDateTime.now())
                .car(car)
                .salesman(salesman)
                .build();
    }
}
