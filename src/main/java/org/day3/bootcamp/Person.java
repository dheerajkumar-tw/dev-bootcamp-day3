package org.day3.bootcamp;

import org.day3.bootcamp.enums.CarStatus;
import org.day3.bootcamp.enums.Flight;
import org.day3.bootcamp.enums.FlightStatus;
import org.day3.bootcamp.enums.Role;

public class Person {
    private Car car;
    private Role personRole;
    private Flight flight;

    public Person(Car car, Flight flight, Role personRole) {
        this.car = car;
        this.personRole = personRole;
        this.flight = flight;
    }

    public boolean parkTheCar(Parking parking){

        if(this.personRole != Role.DRIVER) return false;

        if(this.car.getCarStatus() == CarStatus.PARKED) return true;

        if(parking.bookParkingSlot()){
            car.setCarStatus(CarStatus.PARKED);
            flight.setFlightStatus(FlightStatus.BOARDED);
            return true;
        }
        car.setCarStatus(CarStatus.NOT_PARKED);
        flight.setFlightStatus(FlightStatus.MISSED);
        return false;
    }

    public FlightStatus getFlightStatus(){
        return flight.getFlightStatus();
    }

}
