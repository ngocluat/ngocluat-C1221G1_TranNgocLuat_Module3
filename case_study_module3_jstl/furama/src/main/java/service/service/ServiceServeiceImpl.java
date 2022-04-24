package service.service;

import model.Service;
import reponsitory.service_reponsitory.IServiceReponsitory;
import reponsitory.service_reponsitory.ServiceReponsitoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceServeiceImpl implements ICRUDServiceServeice {
    IServiceReponsitory iServiceReponsitory = new ServiceReponsitoryImpl();

    @Override
    public List<Service> selectAllService() {
        return iServiceReponsitory.selectAllService();
    }

    @Override
    public Map<String, String> insertService(Service service) {

        Map<String, String> map = new HashMap<>();
        if (service.getSoTang() < 0) {
            map.put("sotang", "số tầng không được nhỏ hơn không ");
        }
        if (map.isEmpty()) {
            iServiceReponsitory.insertService(service);
        }
        return map;
    }

}

