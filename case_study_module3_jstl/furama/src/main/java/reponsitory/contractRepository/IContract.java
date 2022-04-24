package reponsitory.contractRepository;

import model.HopDong;

import java.util.List;

public interface IContract {
    List<HopDong> listHopDong();

    void insertCustomer(HopDong hopDong);
}
