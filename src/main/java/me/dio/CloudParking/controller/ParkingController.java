package me.dio.CloudParking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.dio.CloudParking.controller.dto.ParkingCreateDTO;
import me.dio.CloudParking.controller.dto.ParkingTDO;
import me.dio.CloudParking.controller.mapper.ParkingMapper;
import me.dio.CloudParking.model.Parking;
import me.dio.CloudParking.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

//Este modelo é mais usado para fazer exerção de dependência
    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingTDO>> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingTDO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parking> findById(@PathVariable String id){
        Parking parking = parkingService.findById(id);
        Parking result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Parking> create(@RequestBody ParkingCreateDTO dto){
        var ParkingCreate = parkingMapper.toParkingCreate(dto);
        var Parking = parkingService.create(ParkingCreate);
        var result = parkingMapper.toParkingDTO(Parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("{/id}")
    public ResponseEntity<ParkingTDO> update(@PathVariable String id, @RequestBody ParkingCreateDTO parkingCreateDTO){
        Parking parkingUpdate = parkingMapper.toParkingCreate(parkingCreateDTO);
        Parking parking = parkingService.update(id, parkingUpdate);
        return ResponseEntity.ok(parkingMapper.toParkingTDO(parking));
    }
    @PostMapping("{/id}/exit")
    public ResponseEntity<ParkingTDO> checkOut(@PathVariable String id){
        //Todo verificar se já não está fechado e lançar exceção
        Parking parking = parkingService.checkOut(id);
        return ResponseEntity.ok(parkingMapper.toParkingTDO(parking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

}