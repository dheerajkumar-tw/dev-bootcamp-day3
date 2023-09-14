package org.day3.bootcamp;

import org.day3.bootcamp.enums.EventType;

public interface NotificationSystem {

    public void subscribe(ParkingLotObserver parkingLotObserver);
    public void unsubscribe(ParkingLotObserver parkingLotObserver);
    public void notifyObservers(EventType eventType);
}
