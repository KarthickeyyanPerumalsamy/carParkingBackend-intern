package com.recode.project.parking.service;

import com.recode.project.parking.Model.ParkingParkingLotModel;
import com.recode.project.parking.repository.ParkingRepositoryParkinglot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ParkingParkingLotService {

    @Autowired
    private ParkingRepositoryParkinglot parkingRepositoryParkinglot;

    //Create Operation for Create the ParkingLot Details using Rest API
    public Optional<ParkingParkingLotModel> createParkingLotModel(ParkingParkingLotModel parkingLotModel){
        if(parkingRepositoryParkinglot.existsById(parkingLotModel.getParking_lot_id())){
            return Optional.empty();
        }
        else{
            return Optional.of(parkingRepositoryParkinglot.save(parkingLotModel));
        }
    }

    //Read Operation for Get All ParkingLot Details Using Rest API
    public List<ParkingParkingLotModel> retrieve(){
        return parkingRepositoryParkinglot.findAll();
    }

    //Read Operation for Get Particular ParkingLot Details Using Rest API
    public Optional<ParkingParkingLotModel> retrieveOne(int Parking_lot_id){
        return parkingRepositoryParkinglot.findById(Long.valueOf(Parking_lot_id));
    }

    //Update Operation for Update the ParkingLot Details Using Rest API
    public Optional<ParkingParkingLotModel> updateParkingLotDetails(ParkingParkingLotModel parkingLotModel){
        if (parkingRepositoryParkinglot.existsById(parkingLotModel.getParking_lot_id())){
            return Optional.of(parkingRepositoryParkinglot.save(parkingLotModel));
        }
        else{
            return Optional.empty();

        }
    }

    //Delete Operation for Delete the ParkingLot Details Using Rest API
    public String delete(int parking_lot_id){
        if (parkingRepositoryParkinglot.existsById((long) parking_lot_id)){
            parkingRepositoryParkinglot.deleteById((long) parking_lot_id);
            return parking_lot_id + " Deleted Successfully";
        }
        else {
            return "The parking Lot Data does exists in records";
        }
    }

}
