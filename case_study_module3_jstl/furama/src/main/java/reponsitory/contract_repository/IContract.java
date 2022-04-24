package reponsitory.contract_repository;

import model.HopDong;

import java.util.List;

public interface IContract {
    List<HopDong> listHopDong();

    void insertCustomer(HopDong hopDong);
}
