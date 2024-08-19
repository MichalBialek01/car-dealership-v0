package pl.bialek.infrastructure.configuration;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@With
@Builder
public class CarPurchaseInputData {

    String customerName;
    String customerSurname;
    String customerPhone;
    String customerEmail;
    String customerAddressCountry;
    String customerAddressCity;
    String customerAddressPostalCode;
    String customerAddressStreet;
    String carVin;
    String salesmanPesel;
}
