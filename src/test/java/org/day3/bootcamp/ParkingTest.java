package org.day3.bootcamp;

import org.day3.bootcamp.supportingEntities.Car;
import org.day3.bootcamp.supportingEntities.Flight;
import org.day3.bootcamp.supportingEntities.Person;
import org.day3.bootcamp.supportingEntities.enums.FlightStatus;
import org.day3.bootcamp.supportingEntities.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingTest {

    @Test
    public void shouldReturnTrueIfCarIsParked(){

        Parking parking = new Parking(1);
        assertTrue(parking.bookParkingSlot());
    }

    @Test
    public void shouldReturnFalseIfCarIsNotParked(){

        Parking parking = new Parking(1);
        parking.bookParkingSlot();
        assertFalse(parking.bookParkingSlot());
    }

    @Test
    public void shouldReturnTrueIfMoreThan1CarAreParked(){

        Parking parking = new Parking(2);
        parking.bookParkingSlot();
        assertTrue(parking.bookParkingSlot());
    }

    @Test
    public void shouldReturnTrueIfAnotherCarIsParkedAfterReleasingACarFromParking(){

        Parking parking = new Parking(1);
        parking.bookParkingSlot();
        parking.releaseParkingSlot();
        assertTrue(parking.bookParkingSlot());
    }


}
