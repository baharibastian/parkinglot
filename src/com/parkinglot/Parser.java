package com.parkinglot;

import java.io.*;
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
                    } else {
                        System.out.println("Invalid input");
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
                    if (method != null) {
                        method.invoke(parking, input_arr[1]);
                    } else {
                        System.out.println("Invalid input");
                    }

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
                        System.out.println("Invalid input");
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public void parseFileInput(String filePath) {
        // Assuming input to be a valid file path.
        File inputFile = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    parseInput(line.trim());
                }
            } catch (IOException ex) {
                System.out.println("Error in reading the input file.");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the path specified.");
            e.printStackTrace();
        }
    }

}

