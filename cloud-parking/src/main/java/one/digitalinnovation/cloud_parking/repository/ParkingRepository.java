package one.digitalinnovation.cloud_parking.repository;

import one.digitalinnovation.cloud_parking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String> {
}
