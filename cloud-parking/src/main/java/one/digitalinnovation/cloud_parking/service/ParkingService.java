package one.digitalinnovation.cloud_parking.service;

import jakarta.transaction.Transactional;
import one.digitalinnovation.cloud_parking.exception.ParkingNotFoundException;
import one.digitalinnovation.cloud_parking.model.Parking;
import one.digitalinnovation.cloud_parking.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

   private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }


    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Transactional
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    @Transactional
    public Parking findByID(String id) {
        return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
    }

    @Transactional
    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    @Transactional
    public void deleteById(String id) {
        findByID(id);
        parkingRepository.deleteById(id);

    }

    @Transactional
    public Parking update(String id, Parking parkingCreate) {
        Parking byId = findByID(id);
        byId.setColor(parkingCreate.getColor());
        byId.setLicense(parkingCreate.getLicense());
        byId.setModel(parkingCreate.getModel());
        byId.setState(parkingCreate.getState());
        parkingRepository.save(byId);
        return byId;
    }

    @Transactional
    public Parking exit(String id) {
        Parking parking = findByID(id);
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(ParkingCheckOut.getBill(parking));
        return parkingRepository.save(parking);
    }

}
