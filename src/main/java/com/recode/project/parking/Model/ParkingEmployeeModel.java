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
@Table(name="employee")
public class ParkingEmployeeModel {

    @Id
    //Column Of The Employee id
    @Column(name="employee_id")
    private long employeeId;

    //Column Of The Employee name
    @Column(name="name")
    private  String name;

    //Column Of The Employee Department
    @Column(name = "department")
    private String department;

    //Column Of The Employee Contact no
    @Column(name = "contact_no")
    private String contact_no;

    //Column Of The Employee Email id
    @Column(name = "email_id")
    private String email_id;

    //Column Of The Employee Vehicle Name
    @Column(name = "vehicle_name")
    private String vehicle_name;

    //Column Of The Employee Vehicle Plate No
    @Column(name = "vehicle_plate_no")
    private String vehicle_plate_no;

    //Column Of The Employee Access Type
    @Column(name = "access_type")
    private String access_type;

    //Column Of The Temporary Dates
    @Column(name = "dates")
    private Date dates;

    //Column Of The Regular Access Of The Starting Date
    @Column(name = "start_date")
    private Date start_date;

    //Column Of The Regular Access Of The Ending Date
    @Column(name = "end_date")
    private Date end_date;




}
