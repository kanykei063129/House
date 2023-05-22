package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.House;
import peaksoft.repository.HouseRepository;
import peaksoft.service.HouseService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;
    @Override
    public void saveHouse(House house) {
  houseRepository.saveHouse(house);
    }

    @Override
    public List<House> getAllHouse() {
        return houseRepository.getAllHouse();
    }

    @Override
    public House getHouseById(Long id) {
        return houseRepository.getHouseById(id);
    }

    @Override
    public void updateHouseById(Long id, House house) {
  houseRepository.updateHouseById(id,house);
    }

    @Override
    public void deleteHouseById(Long id) {
   houseRepository.deleteHouseById(id);
    }
}
