package org.day3.bootcamp;

import org.day3.bootcamp.exceptions.NoParkingSlotAvailableException;
import org.day3.bootcamp.exceptions.NoSuchVehicleParkedException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingTest {

    @Test
    public void shouldAbleToParkVehicleIfParkingSlotAvailable() throws NoParkingSlotAvailableException {
        Car car1 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkVehicle(car1);
        assertTrue(parkingLot.checkVehicleParkingStatus(car1));
    }

    @Test
    public void shouldThrowExceptionWhileParkingVehicleIfParkingSlotNotAvailable() throws NoParkingSlotAvailableException {

        Car car1 = new Car();
        Car car2= new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkVehicle(car1);
        assertThrows(NoParkingSlotAvailableException.class,  () -> parkingLot.parkVehicle(car2));
    }

    @Test
    public void shouldAbleToParkMultipleVehiclesIfParkingSlotsAvailable() throws NoParkingSlotAvailableException {
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        assertTrue(parkingLot.checkVehicleParkingStatus(car2));
    }

    @Test
    public void shouldReturnTrueIfVehicleIsParkedInParkingLot() throws NoParkingSlotAvailableException {

        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parkVehicle(car);

        assertTrue(parkingLot.checkVehicleParkingStatus(car));
    }

    @Test
    public void shouldReturnFalseIfVehicleIsNotParkedInParkingLot() throws NoParkingSlotAvailableException {

        Car car1 = new Car();
        Car car2 = new Car();

        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parkVehicle(car1);

        assertFalse(parkingLot.checkVehicleParkingStatus(car2));
    }

    @Test
    public void shouldAbleToUnparkTheVehicleIfParked() throws NoSuchVehicleParkedException, NoParkingSlotAvailableException {

        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parkVehicle(car);

        assertTrue(parkingLot.unparkVehicle(car));
    }

    @Test
    public void shouldThrowExceptionWhileUnparkTheVehicleIfNotParked() {

        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(2);

        assertThrows(NoSuchVehicleParkedException.class, () -> parkingLot.unparkVehicle(car));
    }

    @Test
    public void should_notify_owner_and_trafficCop_when_parking_is_Full() throws NoParkingSlotAvailableException {

        Car car = new Car();

        ParkingOwner parkingOwner = Mockito.mock(ParkingOwner.class);
        TrafficCop trafficCop = Mockito.mock(TrafficCop.class);
        ParkingLot parkingLot = new ParkingLot(1);

        parkingLot.associateObserver(trafficCop);
        parkingLot.associateObserver(parkingOwner);

        parkingLot.parkVehicle(car);

        Mockito.verify(parkingOwner, Mockito.times(1)).parkingFull();
        Mockito.verify(trafficCop, Mockito.times(1)).parkingFull();
    }

    @Test
    public void should__not_notify_owner_and_trafficCop_when_parking_is_not_Full() throws NoParkingSlotAvailableException {

        Car car = new Car();

        ParkingOwner parkingOwner = Mockito.mock(ParkingOwner.class);
        TrafficCop trafficCop = Mockito.mock(TrafficCop.class);
        ParkingLot parkingLot = new ParkingLot(2);

        parkingLot.associateObserver(trafficCop);
        parkingLot.associateObserver(parkingOwner);

        parkingLot.parkVehicle(car);

        Mockito.verify(parkingOwner, Mockito.times(0)).parkingFull();
        Mockito.verify(trafficCop, Mockito.times(0)).parkingFull();
    }
}
