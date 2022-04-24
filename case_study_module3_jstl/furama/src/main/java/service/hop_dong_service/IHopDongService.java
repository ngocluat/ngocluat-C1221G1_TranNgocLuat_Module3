package service.hop_dong_service;

import model.HopDong;

import java.util.List;

public interface IHopDongService {
    List<HopDong> listHopDong();

    void insertCustomer(HopDong hopDong);
}
