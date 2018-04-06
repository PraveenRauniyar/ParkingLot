package com.tw.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AttendantTest {

    private Attendant attendant;

    @Before
    public void setUp() {
        attendant = new Attendant();
        attendant.add(new ParkingLot(1));
        attendant.add(new ParkingLot(1));

    }

    @Test
    public void attendantShouldBeAbleToParkACar() throws CanNotParkTheCarException {
        Object tokenNo = attendant.park(new TestVehicle());
        assertNotNull(tokenNo);
    }

    @Test
    public void shouldBeAbleToParkACarIfFirstLotIsFull() throws CanNotParkTheCarException {
        attendant.park(new TestVehicle());
        Object token = attendant.park(new TestVehicle());
        assertNotNull(token);
    }

    @Test(expected = CanNotParkTheCarException.class)
    public void shouldNotBeAbleToParkACarIfAllParkingLotFull() throws CanNotParkTheCarException {
        attendant.park(new TestVehicle());
        attendant.park(new TestVehicle());
        attendant.park(new TestVehicle());
    }

    @Test(expected = CanNotParkTheCarException.class)
    public void shouldNotBeAbleToParkTheAlreadyParkedCar() throws CanNotParkTheCarException {
        TestVehicle car = new TestVehicle();
        Object park = attendant.park(car);
        attendant.park(new TestVehicle());
        attendant.park(car);
    }

    @Test
    public void shouldBeAbleToParkACarAfterCheckoutIfLotIsFull() throws CanNotParkTheCarException {
        Object token1 = attendant.park(new TestVehicle());
        Object token2 = attendant.park(new TestVehicle());
        attendant.checkout(token1);
        attendant.park(new TestVehicle());
    }

    @Test(expected = CanNotParkTheCarException.class)
    public void shouldThrowExceptionForWrongTokenNo() throws CanNotParkTheCarException {
        Object token1 = attendant.park(new TestVehicle());
        Object token2 = attendant.park(new TestVehicle());
        attendant.checkout(new Object());
    }
}
