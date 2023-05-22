package peaksoft.repository;

import peaksoft.entity.House;

import java.util.List;

public interface HouseRepository {
    void saveHouse(House house);
    List<House> getAllHouse();
    House getHouseById(Long id);
    void updateHouseById(Long id,House house);
    void deleteHouseById(Long id);
}
