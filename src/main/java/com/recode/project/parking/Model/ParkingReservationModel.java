package com.recode.project.parking.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class ParkingReservationModel {

    @Id
    //Column Of The reservation id
    @Column(name ="reservation_id")
    private long reservation_id;

    //Column of the Employee id
    @Column(name = "employee_id")
    private int employee_id;

    //Column of the Parking Lot id
    @Column(name = "parking_lot_id")
    private  int parking_lot_id;

    //Column in the Parking of the Reservation Slot
    @Column(name = "reserved_slot")
    private String reserved_slot;

    //Column in the parking of the Reservation date
    @Column(name = "reservation_date")
    private Date reservation_date;


    public Long getReservation_id() {
        return reservation_id;
    }


}
