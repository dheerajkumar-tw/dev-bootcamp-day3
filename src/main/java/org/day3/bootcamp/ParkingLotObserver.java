package org.day3.bootcamp;

import org.day3.bootcamp.enums.EventType;

public interface ParkingLotObserver {

    public void notify(EventType eventType);
}
