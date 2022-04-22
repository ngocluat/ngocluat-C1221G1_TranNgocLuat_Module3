package service.service;

import model.Service;

import java.util.List;
import java.util.Map;

public interface ICRUDServiceServeice {
    List<Service> selectAllService();

    Map<String, String> insertService(Service service);
}
