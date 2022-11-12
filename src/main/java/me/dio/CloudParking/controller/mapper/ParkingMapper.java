package me.dio.CloudParking.controller.mapper;

import me.dio.CloudParking.controller.dto.ParkingTDO;
import me.dio.CloudParking.controller.dto.ParkingCreateDTO;
import me.dio.CloudParking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper<ParkingDTO> {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingTDO toParkingTDO(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingTDO.class);
    }

    public List<ParkingTDO> toParkingDTOList(List<Parking> parkingList) {
        return parkingList.stream().map(this::toParkingTDO).collect(Collectors.toList());
    }

    public Parking toParkingDTO(ParkingDTO dto) {
        return MODEL_MAPPER.map(dto, Parking.class);
    }

    public Parking toParkingCreate(ParkingCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Parking.class);
    }
}
