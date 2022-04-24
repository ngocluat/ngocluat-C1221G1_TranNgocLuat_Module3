package service.hop_dong_service;

import model.HopDong;
import reponsitory.contract_repository.ContracReponsitoryImpl;
import reponsitory.contract_repository.IContract;

import java.util.List;

public class HopDongSeviceIpml implements IHopDongService {
    IContract iContract= new ContracReponsitoryImpl();
    @Override
    public List<HopDong> listHopDong() {
        return iContract.listHopDong();
    }

    @Override
    public void insertCustomer(HopDong hopDong) {

    }
}
