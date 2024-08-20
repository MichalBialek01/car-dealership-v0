package pl.bialek.business.menagement;

import org.springframework.stereotype.Service;
import pl.bialek.domain.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DataPreparationService {


    public List<CarPurchaseRequestInputData> prepareFirstTimePurchaseData() {
        return InputDataCache.getInputData(Keys.InputDataGroup.BUY_FIRST_TIME, this::prepareMap).stream()
                .map(this::prepareFirstTimePurchaseData)
                .toList();
    }

    private CarPurchaseRequestInputData prepareFirstTimePurchaseData(Map<String, List<String>> inputData) {
        List<String> customerData = inputData.get(Keys.Domain.CUSTOMER.toString());
        return CarPurchaseRequestInputData.builder()
                .customerName(customerData.get(0))
                .customerSurname(customerData.get(1))
                .customerPhone(customerData.get(2))
                .customerEmail(customerData.get(3))
                .customerAddressCountry(customerData.get(4))
                .customerAddressCity(customerData.get(5))
                .customerAddressPostalCode(customerData.get(6))
                .customerAddressStreet(customerData.get(7))
                .carVin(inputData.get(Keys.Domain.CAR.toString()).get(0))
                .salesmanPesel(inputData.get(Keys.Domain.SALESMAN.toString()).get(0))
                .build();
    }


    public List<CarPurchaseRequestInputData> prepareNextTimePurchaseData() {
        return InputDataCache.getInputData(Keys.InputDataGroup.BUY_AGAIN, this::prepareMap).stream()
                .map(this::prepareNextTimePurchaseData)
                .toList();
    }

    private CarPurchaseRequestInputData prepareNextTimePurchaseData(Map<String, List<String>> inputData) {
        return CarPurchaseRequestInputData.builder()
                .customerEmail(inputData.get(Keys.Domain.CUSTOMER.toString()).get(0))
                .carVin(inputData.get(Keys.Domain.CAR.toString()).get(0))
                .salesmanPesel(inputData.get(Keys.Domain.SALESMAN.toString()).get(0))
                .build();
    }


    private Map<String, List<String>> prepareMap(String line) {
        //Spliting for "->" slices
        List<String> groupedValues = Arrays.stream(line.split("->")).map(element -> element.trim()).toList();
        return IntStream.iterate(0, previous -> previous + 2) // getting even numbers
                .boxed()
                .limit(3) //limited to 3
                .collect(Collectors.toMap(groupedValues::get,//Map's key's are on previous even provided numbers
                        iterator -> List.of(groupedValues.get(iterator + 1).split(";"))));
        //Get list of even numbers+1 and split them by  ";" sign
        //The result is map that include 3 maps

    }

    public List<CarServiceRequest> createServiceRequests() {
        return InputDataCache.getInputData(Keys.InputDataGroup.SERVICE_REQUEST, this::prepareMap)
                .stream()
                .map(this::createServiceRequest)
                .toList();

    }

    private CarServiceRequest createServiceRequest(Map<String, List<String>> inputData) {
        return CarServiceRequest
                .builder()
                .customer(createCustomer(inputData.get(Keys.Domain.CUSTOMER.toString())))
                .car(createCar(inputData.get(Keys.Domain.CAR.toString())))
                .customerComment(inputData.get(Keys.Constant.WHAT.toString()).get(0))
                .build();
    }

    private CarToService createCar(List<String> inputData) {
        if (inputData.size() == 1) {
            return CarToService
                    .builder()
                    .vin(inputData.get(0))
                    .build();
        }
        return CarToService.builder()
                .vin(inputData.get(0))
                .brand(inputData.get(1))
                .model(inputData.get(2))
                .year(Integer.valueOf(inputData.get(3)))
                .build();
    }

    public Customer createCustomer(CarPurchaseRequestInputData inputData, Invoice invoice) {
        return Customer.builder()
                .name(inputData.getCustomerName())
                .surname(inputData.getCustomerSurname())
                .phone(inputData.getCustomerPhone())
                .email(inputData.getCustomerEmail())
                .address(Address.builder()
                        .country(inputData.getCustomerAddressCountry())
                        .city(inputData.getCustomerAddressCity())
                        .postalCode(inputData.getCustomerAddressPostalCode())
                        .address(inputData.getCustomerAddressStreet())
                        .build())
                .invoices(Set.of(invoice))
                .build();
    }


    private Customer createCustomer(List<String> inputData) {
        if (inputData.size() == 1) {
            return Customer.builder()
                    .email(inputData.get(0))
                    .build();
        }
        return Customer.builder()
                .name(inputData.get(0))
                .surname(inputData.get(1))
                .phone(inputData.get(2))
                .email(inputData.get(3))
                .address(Address.builder()
                        .country(inputData.get(4))
                        .city(inputData.get(5))
                        .postalCode(inputData.get(6))
                        .address(inputData.get(7))
                        .build())
                .build();
    }

    public List<CarServiceProcessingInputData> prepareServiceRequestToProcess() {
        return InputDataCache.getInputData(Keys.InputDataGroup.DO_THE_SERVICE, this::prepareMap)
                .stream()
                .map(this::createCarServiceRequestToProcess)
                .toList();
    }

    private CarServiceProcessingInputData createCarServiceRequestToProcess(Map<String, List<String>> inputData) {
        List<String> what = inputData.get(Keys.Constant.WHAT.toString());
        return CarServiceProcessingInputData
                .builder()
                .mechnicPesel(inputData.get(Keys.Domain.MECHANIC.toString()).get(0))
                .carVin(inputData.get(Keys.Domain.CAR.toString()).get(0))
                .partSerialNumber(Optional.of(what.get(0)).filter(part -> !part.isBlank()).orElse(null))
                .partQuantity(Optional.ofNullable(what.get(1)).filter(value -> !value.isBlank()).map(Integer::parseInt).orElse(null))
                .serviceCode(what.get(2))
                .hours(Integer.parseInt(what.get(3)))
                .comment(what.get(4))
                .done(what.get(5))
                .build();
    }
}
