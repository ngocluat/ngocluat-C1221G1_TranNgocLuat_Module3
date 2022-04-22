package service.cusumer_type_reponsitory;

import model.CustomerType;
import reponsitory.CustomerReponsitory.CustomerReponsitoryImpl;
import reponsitory.CustomerType.CusumerTypeReponsitoryIpml;
import reponsitory.CustomerType.ICusumerTypeReponsitory;

import java.util.List;

public class CustomertypeService {
  ICusumerTypeReponsitory iCusumerTypeReponsitory= new CusumerTypeReponsitoryIpml();
    public List<CustomerType> selectCustomerType() {
        return iCusumerTypeReponsitory.selectCustomerType();
    }
}
