package org.day3.bootcamp;

import org.day3.bootcamp.enums.EventType;

import java.util.HashSet;
import java .util.Set;

public class NotificationSystemImpl implements NotificationSystem{

    private final Set<ParkingLotObserver> observers = new HashSet<>();

    public void subscribe(ParkingLotObserver observer){
        observers.add(observer);
    }

    public void unsubscribe(ParkingLotObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(EventType eventType){
        observers.forEach(observer -> observer.notify(eventType));
    }

}
