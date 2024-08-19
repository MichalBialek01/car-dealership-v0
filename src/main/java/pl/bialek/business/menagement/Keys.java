package pl.bialek.business.menagement;

public interface Keys {
    enum InputDataGroup {
        BUY_FIRST_TIME,
        SERVICE_REQUEST,
        BUY_AGAIN,
        DO_THE_SERVICE;
    }

    enum Domain {
        SALESMAN,
        CUSTOMER,
        MECHANIC,
        CAR
    }

    enum Constant {
        WHAT,
        FINISHED
    }
}
