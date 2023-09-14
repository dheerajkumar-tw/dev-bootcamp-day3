package org.day3.bootcamp;

import org.day3.bootcamp.exceptions.NoParkingSlotAvailableException;
import org.day3.bootcamp.supportingEntities.ParkingOwner;
import org.day3.bootcamp.supportingEntities.TrafficCop;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValletTest {

    NotificationSystem notificationSystem = new NotificationSystemImpl();
    TrafficCop trafficCop = Mockito.mock(TrafficCop.class);
    ParkingOwner owner  =Mockito.mock(ParkingOwner.class);

    {
        notificationSystem.subscribe(trafficCop);
        notificationSystem.subscribe(owner);
    }
    @Test
    public void should_able_to_park_vehicle_in_first_parking_lot_with_free_space_available() throws NoParkingSlotAvailableException {
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1, notificationSystem);
        ParkingLot parkingLot2 = new ParkingLot(1, notificationSystem);

        Valet valet = new Valet();

        valet.addParkingLot(parkingLot1);
        valet.addParkingLot(parkingLot2);

        valet.park(car1);
        valet.park(car2);

        assertTrue(parkingLot1.checkVehicleParkingStatus(car1));
        assertTrue(parkingLot2.checkVehicleParkingStatus(car2));

    }

    //TODO: check unpark
    @Test
    public void should_throw_exception_when_unpark_a_vehicle_which_is_not_parked() throws NoParkingSlotAvailableException {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(1, notificationSystem);
        ParkingLot parkingLot2 = new ParkingLot(1, notificationSystem);

        Valet valet = new Valet();

        valet.addParkingLot(parkingLot1);
        valet.addParkingLot(parkingLot2);

        valet.park(car1);
        valet.park(car2);

        assertThrow(parkingLot1.checkVehicleParkingStatus(car3));
        assertTrue(parkingLot2.checkVehicleParkingStatus(car2));

    }
}
