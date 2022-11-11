package me.dio.CloudParking.controller.mapper;

import me.dio.CloudParking.controller.ParkingTDO;
import me.dio.CloudParking.model.Parking;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingTDO parkingTDO(Parking parking) {
        return MODEL_MAPPER.map(parking, parkingTDO(.class);
    }

    public List<ParkingTDO> toParkingDTOList(List<Parking> parkingList) {
        return parkingList.stream().map(this::parkingTDO).collect(Collectors.toList());
    }
}
