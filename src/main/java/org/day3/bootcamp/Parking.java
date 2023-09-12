package org.day3.bootcamp;

public class Parking {

    private Integer availableSlots;

    public Parking(Integer availableSlots) {
        this.availableSlots = availableSlots;
    }

    public boolean bookParkingSlot(){
        if(availableSlots>0){
            availableSlots = availableSlots-1;
            return true;
        }
        return false;
    }
}
