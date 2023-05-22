package peaksoft.service;

import peaksoft.entity.House;

import java.util.List;

public interface HouseService {
    void saveHouse(House house);
    List<House> getAllHouse();
    House getHouseById(Long id);
    void updateHouseById(Long id,House house);
    void deleteHouseById(Long id);
}
