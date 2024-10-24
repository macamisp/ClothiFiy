package service;

import service.custom.impl.CustomerImpl;
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
        }
        return null;
    }
}
