package me.dio.CloudParking.controller;

import me.dio.CloudParking.controller.mapper.ParkingMapper;
import me.dio.CloudParking.model.Parking;
import me.dio.CloudParking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
//Este modelo é mais usado para fazer exerção de dependência
    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<ParkingTDO> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingTDO> result = parkingMapper.toParkingDTOList(parkingList);
        return result;

    }
}
