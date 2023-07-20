package com.recode.project.parking.controller;

import com.recode.project.parking.Model.ParkingParkingLotModel;
import com.recode.project.parking.service.ParkingParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ParkingLot")
public class ParkingParkingLotController {

    @Autowired
    private ParkingParkingLotService parkingLotService;

    //Calling in Service class using Create Employee details in the Rest API
    @PostMapping("/save")
    public String saveParkingLot(@RequestBody ParkingParkingLotModel parkingParkingLotModel) {
        Optional<ParkingParkingLotModel> _parkingParkingLotModel = parkingLotService.createParkingLotModel(parkingParkingLotModel);
        if (_parkingParkingLotModel.isPresent()) {
            return "The Parking Lot Data has Successfully Created";
        } else {
            return "The Parking Lot Data has already exists";
        }
    }

    //Calling in Service class using get All Employee id in the Rest API
    @GetMapping
    public List<ParkingParkingLotModel> getAllEmployee() {
        return parkingLotService.retrieve();
    }

    //Calling in Service class using get Particular Employee id in the Rest API
    @GetMapping("/{parking_lot_id}")
    public ResponseEntity<ParkingParkingLotModel> getEmployeeId(@PathVariable("parking_lot_id") int parking_lot_id) {
        Optional<ParkingParkingLotModel> parkingParkingLotModel = parkingLotService.retrieveOne(parking_lot_id);
        if (parkingParkingLotModel.isPresent()) {
            return new ResponseEntity<>(parkingParkingLotModel.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(parkingParkingLotModel.get(), HttpStatus.NOT_FOUND);

        }
    }

    //Calling in Service class using update Employee details in the Rest API
    @PutMapping
    public String updateParkingLotId(@RequestBody ParkingParkingLotModel parkingParkingLotModel) {
        Optional<ParkingParkingLotModel> _parkingParkingLotModel = parkingLotService.updateParkingLotDetails(parkingParkingLotModel);
        if (_parkingParkingLotModel.isEmpty()) {
            return "The Parking Lot data does not updated";
        } else {
            return "The Parking Lot data Successfully Updated";
        }
    }

    //Calling in the Service class using delete Parking Lot details in the Rest API
    @DeleteMapping("/{parking_lot_id}")
    public String deleteParkingLotId(@PathVariable("parking_lot_id") int parking_lot_id) {
        return parkingLotService.delete(parking_lot_id);

    }
}











