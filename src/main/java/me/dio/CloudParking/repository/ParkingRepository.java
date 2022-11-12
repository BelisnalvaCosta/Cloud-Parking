package me.dio.CloudParking.repository;

import me.dio.CloudParking.model.Parking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String> {
    List<Parking> findAll();
}
