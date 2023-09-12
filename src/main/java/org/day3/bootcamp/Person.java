package org.day3.bootcamp;

public class Person {
    private CarStatus carStatus;

    private PersonRole personRole;
    private FlightStatus flightStatus;

    public Person(CarStatus carStatus, FlightStatus flightStatus, PersonRole personRole) {
        this.carStatus = carStatus;
        this.flightStatus = flightStatus;
        this.personRole = personRole;
    }

    public boolean parkTheCar(Parking parking){

        if(this.personRole != PersonRole.DRIVER) return false;

        if(this.carStatus == CarStatus.PARKED) return true;

        if(parking.bookParkingSlot()){
            carStatus = CarStatus.PARKED;
            flightStatus = FlightStatus.CATCHED;
            return true;
        }
        carStatus = CarStatus.NOT_PARKED;
        flightStatus = FlightStatus.MISSED;
        return false;
    }

    public FlightStatus getFlightStatus(){
        return flightStatus;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

}
