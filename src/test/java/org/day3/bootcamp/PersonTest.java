package org.day3.bootcamp;

import org.day3.bootcamp.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void shouldReturnCatchedFlightWhenCarIsParked(){

        Person person = new Person(CarStatus.RUNNING, FlightStatus.NOTYETSTARTED, PersonRole.DRIVER);
        Parking parking = new Parking(10);

        person.parkTheCar(parking);

        assertEquals(FlightStatus.CATCHED, person.getFlightStatus());

    }
}
