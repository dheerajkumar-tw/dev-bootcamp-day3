package org.day3.bootcamp;

import org.day3.bootcamp.exceptions.NoParkingSlotAvailableException;
import org.day3.bootcamp.exceptions.NoSuchVehicleParkedException;
import org.day3.bootcamp.markerInterface.ParkableObject;

import java.util.HashSet;

public class ParkingLot {

    private Integer availableSlots;
    private final HashSet<ParkableObject> parkedVehicles = new HashSet<>();

    public ParkingLot(Integer availableSlots) {
        this.availableSlots = availableSlots;
    }

    public void parkVehicle(ParkableObject parkableObject) throws NoParkingSlotAvailableException {

        if(availableSlots>0){
            availableSlots = availableSlots-1;
            parkedVehicles.add(parkableObject);
            return;
        }
        throw new NoParkingSlotAvailableException();
    }

    public boolean unparkVehicle(ParkableObject parkableObject) throws NoSuchVehicleParkedException {

        if(parkedVehicles.contains(parkableObject)){
            parkedVehicles.remove(parkableObject);
            availableSlots++;
            return true;
        }
        throw new NoSuchVehicleParkedException();
    }


    public boolean checkVehicleParkingStatus(ParkableObject parkableObject) {
        return parkedVehicles.contains(parkableObject);
    }
}
