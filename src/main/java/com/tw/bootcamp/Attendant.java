package com.tw.bootcamp;

import java.util.ArrayList;

public class Attendant {
    private ArrayList<ParkingLot> parkings;

    public Attendant() {
        parkings = new ArrayList<>();
    }



    public void add(ParkingLot parkingLot) {
        parkings.add(parkingLot);
    }

    public Object park(Vehicle car) throws CanNotParkTheCarException {
        for (ParkingLot parkingLot:parkings){
            parkingLot.hasCarAlreadyParked(car);
            if(!parkingLot.isFull()){
                return parkingLot.park(car);
            }
        }
        throw new CanNotParkTheCarException("All Parking lot full");
    }

    public Vehicle checkout(Object token) throws CanNotParkTheCarException {
        for (ParkingLot parkingLot:parkings){
            if(parkingLot.hasCar(token)){
                return parkingLot.checkout(token);
            }
        }
        throw new CanNotParkTheCarException("Car not found");
    }
}

