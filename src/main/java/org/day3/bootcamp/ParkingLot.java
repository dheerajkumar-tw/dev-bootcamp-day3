package org.day3.bootcamp;

import org.day3.bootcamp.exceptions.NoParkingSlotAvailableException;
import org.day3.bootcamp.exceptions.NoSuchVehicleParkedException;
import org.day3.bootcamp.markerInterface.Parkable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParkingLot {

    private Integer availableSlots;
    private final HashSet<Parkable> parkedVehicles = new HashSet<>();

    private List<ParkingLotObserver> parkingLotObserverList = new ArrayList<>();

    private Boolean parkingFull;

    public ParkingLot(Integer availableSlots) {
        this.availableSlots = availableSlots;
        this.parkingFull = false;
    }

    public void associateObserver(ParkingLotObserver parkingLotObserver){
        parkingLotObserverList.add(parkingLotObserver);
    }

    public void parkVehicle(Parkable parkableObject) throws NoParkingSlotAvailableException {

        if(availableSlots>0){
            parkedVehicles.add(parkableObject);
            availableSlots = availableSlots-1;
            notifyIfParkingIsFull(availableSlots);
            return;
        }
        throw new NoParkingSlotAvailableException();
    }

    public boolean unparkVehicle(Parkable parkableObject) throws NoSuchVehicleParkedException {

        if(parkedVehicles.contains(parkableObject)){
            parkedVehicles.remove(parkableObject);
            availableSlots++;
            notifyIfParkingIsFull(availableSlots);
            return true;
        }
        throw new NoSuchVehicleParkedException();
    }


    public boolean checkVehicleParkingStatus(Parkable parkableObject) {
        return parkedVehicles.contains(parkableObject);
    }

    private void notifyIfParkingIsFull(Integer availableSlots){
        if(availableSlots==0){
            notifyAllObserverThatParkingIsFull();
            return;
        }

        if(parkingFull && availableSlots>0){
            //TODO: Put some messgae in MQ, to send notification for Full Parking
            parkingFull =false;
        }
    }

    public void notifyAllObserverThatParkingIsFull(){
        parkingLotObserverList.forEach(ParkingLotObserver::parkingFull);
    }
}
