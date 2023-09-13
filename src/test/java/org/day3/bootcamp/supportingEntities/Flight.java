package org.day3.bootcamp.supportingEntities;

import org.day3.bootcamp.supportingEntities.enums.FlightStatus;

public class Flight {
    private FlightStatus flightStatus;

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }
}
