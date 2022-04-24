package service.hop_dong_service;

import model.HopDong;
import reponsitory.contractRepository.ContracReponsitoryImpl;
import reponsitory.contractRepository.IContract;

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
