package com.recode.project.parking.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parkinglot")
public class ParkingParkingLotModel {
    @Id
    //Column Of The Parking Lot id
    @Column(name = "parking_lot_id")
    private long parking_lot_id;

    //Column Of The Parking Lot
    @Column(name = "parking_lot")
    private String parking_lot;

    //Column Of The Parking Slot No
    @Column(name = "parking_slot_no")
    private String parking_slot_no;

    //Column Of The Block Code
    @Column(name = "block_code")
    private int block_code;

    //Column Of The Block Name
    @Column(name = "block_name")
    private String block_name;

    //Column in The Block of the Floor Number
    @Column(name = "floor_number")
    private String floor_number;

    //Column Of The Location
    @Column(name = "location")
    private String location;

    //Column in the Parking of the Capacity Slot
    @Column(name = "capacity")
    private int capacity;

    //Column in the Parking of the Available Spaces Slot
    @Column(name = "available_spaces")
    private int available_spaces;

    //Column in the Parking of the Covered Slots
    @Column(name = "covered")
    private int covered;

    //Column in the Parking of the Reserved Slots
    @Column(name = "reserved")
    private int reserved;


}
