package com.recode.project.parking.service;

import com.recode.project.parking.Model.ParkingReservationModel;
import com.recode.project.parking.repository.ParkingRepositoryReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingReservationService{

    @Autowired
    private ParkingRepositoryReservation parkingRepositoryReservation;

    //Create Operation for Create the ParkingLot details using Rest API
    public Optional<ParkingReservationModel> createReservationModel(ParkingReservationModel parkingReservationModel){
        if (parkingRepositoryReservation.existsById(parkingReservationModel.getReservation_id())){
    return Optional.empty();
        }
        else{
            return Optional.of(parkingRepositoryReservation.save(parkingReservationModel));
        }
    }

    //Read Operation for Get All Reservation Details Using Rest API
    public List<ParkingReservationModel> retrieve(){
        return parkingRepositoryReservation.findAll();
    }

    //Read Operation for Get Particular Reservation Details Using Rest API
    public Optional<ParkingReservationModel> retrieveOne(int reservation_id){
        return parkingRepositoryReservation.findById(Long.valueOf(reservation_id));
    }

    //Update Operation for Update the Reservation details Using Rest API
    public Optional<ParkingReservationModel>updateReservationDetails(ParkingReservationModel parkingReservationModel){
        if (parkingRepositoryReservation.existsById(parkingReservationModel.getReservation_id())){
            return Optional.of(parkingRepositoryReservation.save(parkingReservationModel));
        }
        else{
            return Optional.empty();
        }
    }

    //Delete Operation for Delete the Reservation Details Using Rest API
    public String delete(int reservation_id){
        if (parkingRepositoryReservation.existsById((long) reservation_id)){
            parkingRepositoryReservation.deleteById((long) reservation_id);
            return reservation_id + " Deleted successfully";
        }
        else{
            return "The Reservation does exists in records";
        }
    }






}
