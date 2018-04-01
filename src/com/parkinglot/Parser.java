package com.parkinglot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Parser {

    Action actions;
    static Parking parking;

    public Parser() {
        actions = new Action();
        parking = new Parking();
    }

    public void parseInput(String input) {
        String[] input_arr = input.split(" ");
        switch (input_arr.length) {
            case 1:
                try {
                    Method method = actions.actionsMap.get(input);
                    if (method != null ){
                        method.invoke(parking);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Method method = actions.actionsMap.get(input_arr[0]);
                    method.invoke(parking, input_arr[1]);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    Method method = actions.actionsMap.get(input_arr[0]);
                    if (method != null) {
                        method.invoke(parking, input_arr[1], input_arr[2]);
                    } else {
                        System.out.println("Perintah " + input_arr[0] + " tidak ada");
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Default Input");
        }
    }

}

