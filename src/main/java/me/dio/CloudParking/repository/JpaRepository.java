package me.dio.CloudParking.repository;

import me.dio.CloudParking.model.Parking;

public interface JpaRepository<T, T1> {
    Parking findById(String id);

    Parking save(Parking parkingCreate);

    void deleteById(String id);
}
