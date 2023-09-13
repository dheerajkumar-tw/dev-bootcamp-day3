package org.day3.bootcamp.supportingEntities;

import org.day3.bootcamp.supportingEntities.enums.CarStatus;

public class Car {
    private CarStatus carStatus;

    public Car(){

    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }
}
