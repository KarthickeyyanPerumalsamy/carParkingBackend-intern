package com.recode.project.parking.repository;

import com.recode.project.parking.Model.ParkingEmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepositoryEmployee extends JpaRepository<ParkingEmployeeModel,Long > {

    // All CRUD database Methods
}
