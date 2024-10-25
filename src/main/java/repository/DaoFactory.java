package repository;

import repository.custom.impl.CustomerDaoImpl;
import repository.custom.impl.EmployeeDaoImpl;
import repository.custom.impl.ProductDaoImpl;
import repository.custom.impl.SupplierDaoImpl;
import service.custom.impl.OrderImpl;
import service.custom.impl.ProductImpl;
import util.DaoType;

public class DaoFactory {
    private static DaoFactory instance;

    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return instance==null?instance=new DaoFactory():instance;
    }

    public <T extends SuperDAO> T getDaoType(DaoType daoType){
        switch (daoType){
            case CUSTOMER:return (T) new CustomerDaoImpl();
            case SUPPLIER: return (T) new SupplierDaoImpl();
            case PRODUCT:return (T) new ProductDaoImpl();
            case ORDER: return (T) new OrderImpl();
            case EMPLOYEE: return (T) new EmployeeDaoImpl();
        }
        return null;
    }
}
