package org.day3.bootcamp;

import org.day3.bootcamp.enums.EventType;
import org.day3.bootcamp.exceptions.NoParkingSlotAvailableException;
import org.day3.bootcamp.exceptions.NoSuchVehicleParkedException;
import org.day3.bootcamp.markerInterface.Parkable;

import java.util.HashSet;

public class ParkingLot {

    private Integer availableSlots;
    private final HashSet<Parkable> parkedVehicles = new HashSet<>();
    private Boolean isParkingFull;
    private NotificationSystem notificationSystem;

    public ParkingLot(Integer availableSlots, NotificationSystem notificationSystem) {
        this.availableSlots = availableSlots;
        this.isParkingFull = false;
        this.notificationSystem = notificationSystem;
    }

    public void parkVehicle(Parkable parkableObject) throws NoParkingSlotAvailableException {

        if(availableSlots>0){
            parkedVehicles.add(parkableObject);
            availableSlots = availableSlots-1;
            updateParkingStatus(availableSlots);
            return;
        }
        throw new NoParkingSlotAvailableException();
    }

    public boolean unparkVehicle(Parkable parkableObject) throws NoSuchVehicleParkedException {

        if(parkedVehicles.contains(parkableObject)){
            parkedVehicles.remove(parkableObject);
            availableSlots++;
            updateParkingStatus(availableSlots);
            return true;
        }
        throw new NoSuchVehicleParkedException();
    }


    public boolean checkVehicleParkingStatus(Parkable parkableObject) {
        return parkedVehicles.contains(parkableObject);
    }

    private void updateParkingStatus(Integer availableSlots){
        if(availableSlots==0){
            isParkingFull = true;
            notificationSystem.notifyObservers(EventType.PARKING_IS_FULL);
            return;
        }
        if(isParkingFull && availableSlots>0){
            isParkingFull =false;
            notificationSystem.notifyObservers(EventType.PARKING_IS_AVAILABLE);
        }
    }

    public boolean isParkingFull(){
        return isParkingFull;
    }
}
