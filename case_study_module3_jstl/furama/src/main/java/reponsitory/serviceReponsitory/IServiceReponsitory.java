package reponsitory.serviceReponsitory;

import model.Service;

import java.util.List;

public interface IServiceReponsitory {
    List<Service> selectAllService();

    void insertService(Service service);
}
