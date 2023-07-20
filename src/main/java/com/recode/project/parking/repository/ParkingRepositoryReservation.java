package com.recode.project.parking.repository;

import com.recode.project.parking.Model.ParkingReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepositoryReservation extends JpaRepository<ParkingReservationModel,Long> {

    //All CRUD Operation database
}


