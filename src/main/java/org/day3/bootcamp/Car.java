package org.day3.bootcamp;

import org.day3.bootcamp.enums.CarStatus;

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
