package service.cusumer_type_reponsitory;

import model.CustomerType;
import reponsitory.customer_type.CusumerTypeReponsitoryIpml;
import reponsitory.customer_type.ICusumerTypeReponsitory;

import java.util.List;

public class CustomertypeService {
  ICusumerTypeReponsitory iCusumerTypeReponsitory= new CusumerTypeReponsitoryIpml();
    public List<CustomerType> selectCustomerType() {
        return iCusumerTypeReponsitory.selectCustomerType();
    }
}
