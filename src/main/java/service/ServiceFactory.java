package service;

import service.custom.impl.*;
import util.ServiceType;

public class ServiceFactory {
    private static ServiceFactory instance;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance==null ? instance = new ServiceFactory() : instance;
    }

    public <T extends Superservice> T getServiceType(ServiceType serviceType) {
        switch (serviceType) {
            case CUSTOMER:return (T) new CustomerImpl();
            case PRODUCT:return (T) new ProductImpl();
            case SUPPLIER:return (T) new SuplierImpl();
            case ORDER:return (T) new OrderImpl();
            case ADMIN:return (T) new AdminImpl();
            case EMPLOYEE:return (T) new EmployeeImpl();
        }
        return null;
    }
}
