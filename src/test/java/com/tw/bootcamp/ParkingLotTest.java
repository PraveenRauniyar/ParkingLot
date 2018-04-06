package com.tw.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    private ParkingLot parkingLot;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot(2);

    }

    @Test
    public void shouldBeAbleToParkTheCar() throws CanNotParkTheCarException {
        Object car = parkingLot.park(new TestVehicle());
        assertNotNull(car);
    }

    @Test
    public void shouldBeAbleToCheckoutTheSameCarAsPerToken() throws CanNotParkTheCarException {
        TestVehicle car = new TestVehicle();
        Object tokenNO = parkingLot.park(car);
        assertThat(parkingLot.checkout(tokenNO),is(car));
    }

    @Test(expected = CanNotParkTheCarException.class)
    public void shouldNotBeAbleToCheckoutTheSameCarTwice() throws CanNotParkTheCarException {
        Object tokenNO = parkingLot.park(new TestVehicle());
        parkingLot.checkout(tokenNO);
        parkingLot.checkout(tokenNO);
    }

    @Test(expected = CanNotParkTheCarException.class)
    public void shouldNotBeAbleToParkedTheSameCarTwice() throws CanNotParkTheCarException {
        TestVehicle car = new TestVehicle();
        parkingLot.park(car);
        parkingLot.park(car);
    }

    @Test(expected = CanNotParkTheCarException.class)
    public void shouldNotBeAbleToParkCarWhenParkingLotFull() throws CanNotParkTheCarException {
        parkingLot.park(new TestVehicle());
        parkingLot.park(new TestVehicle());
        parkingLot.park(new TestVehicle());
    }



}
