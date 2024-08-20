package pl.bialek.business;

import lombok.AllArgsConstructor;
import pl.bialek.business.menagement.DataPreparationService;
import pl.bialek.business.menagement.Keys;
import pl.bialek.domain.*;
import pl.bialek.infrastructure.database..CarToBuy;
import pl.bialek.infrastructure.database..Customer;
import pl.bialek.infrastructure.database..Invoice;
import pl.bialek.infrastructure.database.
import pl.bialek.infrastructure.database..Invoice;.Salesman;

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

        List<Customer> firstTimeCustomers = firstTimeData.stream()
                .map(this::createFirtTimeToBuyCustomer)
                .toList();
        firstTimeCustomers.forEach(customerService::issueInvoice);

        List<Customer> nextTimeCustomers = nextTimeData.stream()
                .map(this::createNextTimeToBuyCustomer)
                .toList();
        nextTimeCustomers.forEach(customerService::issueInvoice);
    }

    private Customer createFirtTimeToBuyCustomer(CarPurchaseRequestInputData inputData) {
        //Catching car - having single value (VIN)
        CarToBuy car = carService.findCarToBuy(inputData.getCarVin());
        //Caching Salesman - having single value (PESEL)
        Salesman salesman = salesmanSercice.findSalesman(inputData.getSalesmanPesel());
        //Building Invoice basing on buingCar and salesman
        Invoice invoice = buildInvoice(car, salesman);

        return dataPreparationService.createCustomer(inputData, invoice);


    }

    private Customer createNextTimeToBuyCustomer(CarPurchaseRequestInputData inputData) {
        Customer exisitngCustomer = customerService.findCustomer(inputData.getCustomerEmail());
        //Catching car - having single value (VIN)
        CarToBuy car = carService.findCarToBuy(inputData.getCarVin());
        //Caching Salesman - having single value (PESEL)
        Salesman salesman = salesmanSercice.findSalesman(inputData.getSalesmanPesel());
        //Building Invoice basing on buingCar and salesman
        Invoice invoice = buildInvoice(car, salesman);
        exisitngCustomer.getInvoices().add(invoice);
        return exisitngCustomer;
    }


    private Invoice buildInvoice(CarToBuy car, Salesman salesman) {
        return Invoice
                .builder()
                .invoiceNumber(UUID.randomUUID().toString())
                .dateTime(OffsetDateTime.now())
                .car(car)
                .salesman(salesman)
                .build();
    }
}
