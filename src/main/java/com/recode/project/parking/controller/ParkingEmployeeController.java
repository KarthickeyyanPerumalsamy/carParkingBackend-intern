package com.recode.project.parking.controller;

import com.recode.project.parking.Model.ParkingEmployeeModel;
import com.recode.project.parking.service.ParkingEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")

public class ParkingEmployeeController {

    @Autowired
    private ParkingEmployeeService parkingEmployeeService;

    @PostMapping
    @RequestMapping("/save")
    public String saveEmployee(@RequestBody ParkingEmployeeModel parkingEmployeeModel){
        Optional<ParkingEmployeeModel> _parkingEmployeeModel =parkingEmployeeService.create(parkingEmployeeModel);
        if(_parkingEmployeeModel.isPresent()){
            return "The Employee Data has Successfully Created";
        }
        else{
            return "The Employee Data has already exists";
        }
    }

    //Calling in Service class using get All Employee id in the Rest API
    @GetMapping
    public List<ParkingEmployeeModel> getAllEmployee(){
        return parkingEmployeeService.retrieve();
    }

    //Calling in Service class using get Particular Employee id in the Rest API
    @GetMapping("/{employee_id}")
    public ResponseEntity<ParkingEmployeeModel>getEmployeeId(@PathVariable ("employee_id") int employee_id) {
        Optional<ParkingEmployeeModel>parkingEmployeeModel=parkingEmployeeService.retrieveOne(employee_id);
        if (parkingEmployeeModel.isPresent()) {
            return new ResponseEntity<>(parkingEmployeeModel.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(parkingEmployeeModel.get(), HttpStatus.NOT_FOUND);

        }
    }
    //Calling in Service class using update Employee details in the Rest API
    @PutMapping
    public String updateEmployeeId(@RequestBody ParkingEmployeeModel parkingEmployeeModel){
        Optional<ParkingEmployeeModel>_parkingEmployeeModel=parkingEmployeeService.update(parkingEmployeeModel);
        if(_parkingEmployeeModel.isEmpty()){
            return "The Employee data does not updated";
        }
        else{
            return "The Employee data Successfully Updated";
        }
    }
    //Calling in the Service class using delete Employee details in the Rest API
    @DeleteMapping("/{employee_id}")
    public String deleteEmployeeId(@PathVariable("employee_id")int employee_id) {
        return parkingEmployeeService.delete(employee_id);
    }

}









