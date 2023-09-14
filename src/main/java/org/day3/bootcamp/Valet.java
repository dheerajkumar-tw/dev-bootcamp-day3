package org.day3.bootcamp;

import org.day3.bootcamp.exceptions.NoParkingSlotAvailableException;
import org.day3.bootcamp.markerInterface.Parkable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Valet {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public void addParkingLot(ParkingLot parkingLot){
        parkingLots.add(parkingLot);
    }

    public void park(Parkable vehicle) throws NoParkingSlotAvailableException {
        Optional<ParkingLot> availableParkingLotOpt = findFirstParkingLotWithFreeSpace();
        if(availableParkingLotOpt.isPresent()){
            availableParkingLotOpt.get().parkVehicle(vehicle);
            return;
        }
        throw new NoParkingSlotAvailableException();
    }

    private Optional<ParkingLot> findFirstParkingLotWithFreeSpace(){
        return parkingLots.stream().filter(parkingLot -> !parkingLot.isParkingFull()).findFirst();
    }

}
