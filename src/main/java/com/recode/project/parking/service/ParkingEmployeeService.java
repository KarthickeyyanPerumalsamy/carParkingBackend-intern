package com.recode.project.parking.service;

import com.recode.project.parking.Model.ParkingEmployeeModel;
import com.recode.project.parking.repository.ParkingRepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingEmployeeService {

    @Autowired
    ParkingRepositoryEmployee parkingRepositoryEmployee;

    //Create Operation to create the Employee Details using Rest API
    public Optional<ParkingEmployeeModel>create(ParkingEmployeeModel parkingEmployeeModel){
        if(parkingRepositoryEmployee.existsById(parkingEmployeeModel.getEmployeeId())){
            return Optional.empty();
        }
        else{
            return Optional.of(parkingRepositoryEmployee.save(parkingEmployeeModel));
        }
    }


    //Read Operation to get All Employee Details using Rest API
    public List<ParkingEmployeeModel> retrieve(){
        return parkingRepositoryEmployee.findAll();
    }

    //Read Operation to get particular Employee Details Using Rest API
    public Optional<ParkingEmployeeModel> retrieveOne(int employee_id){
        return parkingRepositoryEmployee.findById(Long.valueOf(employee_id));
    }

    //Update Operation to update the Employee details using Rest API
    public Optional<ParkingEmployeeModel> update(ParkingEmployeeModel parkingEmployeeModel){
        if (parkingRepositoryEmployee.existsById(parkingEmployeeModel.getEmployeeId())){
            return Optional.of(parkingRepositoryEmployee.save(parkingEmployeeModel));
        }
        else{
            return Optional.empty();
        }
    }
    //Delete Operation to delete the employee details using Rest API
    public String delete(int employee_id){
        if (parkingRepositoryEmployee.existsById((long) employee_id)){
            parkingRepositoryEmployee.deleteById((long) employee_id);
            return employee_id + " Deleted Successfully";

        }
        else{
            return "The Employee data does exists in records";
        }

    }
}
