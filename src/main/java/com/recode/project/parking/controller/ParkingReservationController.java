package com.recode.project.parking.controller;

import com.recode.project.parking.Model.ParkingReservationModel;
import com.recode.project.parking.service.ParkingReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/reservation")
public class ParkingReservationController {

    @Autowired ParkingReservationService parkingReservationService;

    @PostMapping("/save")
    public String saveReservation(@RequestBody ParkingReservationModel parkingReservationModel){
        Optional<ParkingReservationModel>_parkingReservationModel = parkingReservationService.createReservationModel(parkingReservationModel);
        if(_parkingReservationModel.isPresent()){
            return "The Reservation Data has Successfully Created";
        }
        else{
            return "The Reservation data has already exists";
        }
    }

    @GetMapping
    public List<ParkingReservationModel> getAllReservation(){
        return parkingReservationService.retrieve();
    }

    @GetMapping("/{reservation_id}")
    public ResponseEntity<ParkingReservationModel> getReservationId(@PathVariable("reservation_id") int reservation_id){
        Optional<ParkingReservationModel>parkingReservationModel=parkingReservationService.retrieveOne(reservation_id);
        if (parkingReservationModel.isPresent()){
            return new ResponseEntity<>(parkingReservationModel.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(parkingReservationModel.get(),HttpStatus.NOT_FOUND);
        }
    }
    //Calling in Service Class Using Update Reservation details in the Rest API

    @PutMapping
    public String updateReservationDetails(@RequestBody ParkingReservationModel parkingReservationModel){
        Optional<ParkingReservationModel>_parkingReservationModel = parkingReservationService.updateReservationDetails(parkingReservationModel);
        if(_parkingReservationModel.isEmpty()){
            return "The Reservation Data does not Updated";
        }
        else{
            return "The Reservation data Successfully Updated";
        }
    }

    //Calling in the Service class Using delete Reservation details in the Rest API
    @DeleteMapping("/{reservation_id}")
    public String deleteReservationId(@PathVariable("reservation_id") int reservation_id){
        return parkingReservationService.delete(reservation_id);
    }
}
