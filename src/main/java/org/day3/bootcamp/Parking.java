package org.day3.bootcamp;

public class Parking {

    private Integer availableSlots;
    private final Integer maximumCapacity;

    public Parking(Integer availableSlots) {
        this.availableSlots = availableSlots;
        this.maximumCapacity = availableSlots;
    }

    public boolean bookParkingSlot(){
        if(availableSlots>0){
            availableSlots = availableSlots-1;
            return true;
        }
        return false;
    }

    public boolean releaseParkingSlot(){
        if(availableSlots < maximumCapacity){
            availableSlots++;
            return true;
        }
        return false;
    }
}
