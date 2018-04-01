package com.parkinglot;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Action {

    public Map<String, Method> actionsMap;

    public Action() {
        actionsMap = new HashMap<String, Method>();
        try {
            setActionsMap();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void setActionsMap() throws NoSuchMethodException {
        actionsMap.put("create_parking_lot", Parking.class.getMethod("createParkingLot", String.class));
        actionsMap.put("park", Parking.class.getMethod("park", String.class, String.class));
        actionsMap.put("status", Parking.class.getMethod("status"));
        actionsMap.put("slot_numbers_for_cars_with_colour", Parking.class.getMethod("getSlotNumbersWithColor", String.class));
        actionsMap.put("registration_numbers_for_cars_with_colour", Parking.class.getMethod("getRegNoWithColor", String.class));
        actionsMap.put("slot_number_for_registration_number", Parking.class.getMethod("getSlotNumberWithRegistration", String.class));
        actionsMap.put("leave", Parking.class.getMethod("leave", String.class));
    }




}
