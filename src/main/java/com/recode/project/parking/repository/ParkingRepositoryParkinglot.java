package com.recode.project.parking.repository;

import com.recode.project.parking.Model.ParkingParkingLotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepositoryParkinglot extends JpaRepository<ParkingParkingLotModel,Long> {

// All CRUD Operation Database
}

