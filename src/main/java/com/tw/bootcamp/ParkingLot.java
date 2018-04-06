package com.tw.bootcamp;

import java.util.HashMap;

public class ParkingLot {

    private final HashMap<Object, Vehicle> parkingLot;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingLot = new HashMap<>();
    }

    public Object park(Vehicle car) throws CanNotParkTheCarException {
        hasCarAlreadyParked(car);
        if(parkingLot.containsValue(car)) {
            throw new CanNotParkTheCarException("Car has already Parked");
        }
        if (isFull()){
            throw new CanNotParkTheCarException("No space available");
        }
        Object tokenNo = new Object();
        parkingLot.put(tokenNo,car);
        return tokenNo;
    }
    protected boolean hasCarAlreadyParked(Vehicle car) throws CanNotParkTheCarException {
        if(parkingLot.containsValue(car)) {
            throw new CanNotParkTheCarException("Car has already Parked");
        }
        return false;
    }

    public Vehicle checkout(Object tokenNo) throws CanNotParkTheCarException {
            if(hasCar(tokenNo)) {
                return parkingLot.remove(tokenNo);
            }
            throw new CanNotParkTheCarException("Car not found");
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "parkingLot=" + parkingLot +
                '}';
    }


    protected boolean hasCar(Object carNumber){
        return parkingLot.containsKey(carNumber);
    }

    protected boolean isFull() {
        return parkingLot.size()==capacity;
    }
}
