package org.day3.bootcamp;

import org.day3.bootcamp.enums.Flight;
import org.day3.bootcamp.enums.FlightStatus;
import org.day3.bootcamp.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonTest {

    @Test
    public void shouldReturnFlightBoardedIfCarIsParked(){

        Car car = new Car();
        Flight flight = new Flight();

        Person person = new Person(car, flight, Role.DRIVER);
        Parking parking = new Parking(10);

        person.parkTheCar(parking);

        assertEquals(FlightStatus.BOARDED, person.getFlightStatus());
    }

    @Test
    public void shouldReturnFlightMissedIfCarIsNotParked(){

        Car car = new Car();
        Flight flight = new Flight();

        Person person = new Person(car, flight, Role.DRIVER);
        Parking parking = new Parking(10);

//        person.parkTheCar(parking);
        assertNotEquals(FlightStatus.BOARDED, person.getFlightStatus());
    }
}
