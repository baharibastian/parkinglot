package com.parkinglot;

import java.util.*;

public class Parking {

    ArrayList<Integer> parkingSpace;
    int sizeParkingSlot = 0;
    Map<String, Car> park;
    Map<String, String> park2;

    public void createParkingLot(String slotParking) {
        try {
            this.sizeParkingSlot = Integer.parseInt(slotParking);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.parkingSpace = new ArrayList<Integer>() {};
        sizeParkingSlot = Integer.parseInt(slotParking);
        for(int i=1;i<=sizeParkingSlot;i++) {
            parkingSpace.add(i);
        }
        this.park = new HashMap<String, Car>();
        this.park2 = new HashMap<String, String>();
        System.out.println("Created parking lot with "+ slotParking + " lots");
        System.out.println();
    }

    public void park(String noReg, String color) {
        if (this.park.size() == this.sizeParkingSlot) {
            System.out.println("parkir full gan");
        } else {
            Collections.sort(parkingSpace);
            String slot = parkingSpace.get(0).toString();
            Car car = new Car(noReg, color);
            this.park.put(slot, car);
            System.out.println("Allocated slot number: "+slot);
            parkingSpace.remove(0);
        }
    }

    public void status() {
        if (sizeParkingSlot == 0) {
            System.out.println("the parking slot is 0");
        } else if(this.park.size() > 0) {
            System.out.println("Slot No.\tRegistration Number.\tColor");
            Car car;
            for (int i=1; i<=this.sizeParkingSlot; i++) {
                String key = Integer.toString(i);
                if (this.park.containsKey(key)) {
                    car = this.park.get(key);
                    System.out.println(i + "\t" + car.regNo + "\t" + car.color);
                }
            }
        }
    }

    public void leave(String slot) {
        if (this.sizeParkingSlot == 0) {
            System.out.println("Sorry, parking lot is not created");
        } else if (this.park.size() > 0) {
            if (this.park.containsKey(slot)) {
                this.park.remove(slot);
                this.parkingSpace.add(Integer.parseInt(slot));
                System.out.println("Slot number " + slot + " is free");
            } else {
                System.out.println("Slot number " + slot + " already empty");
            }
        }
    }

    public void getSlotNumbersWithColor(String color) {
        if (sizeParkingSlot == 0) {
            System.out.println("the parking slot is 0");
        } else if(this.park.size() > 0) {
            ArrayList<Integer> slotList = new ArrayList<Integer>() {
            };
            Car car;
            for (int i = 1; i <= this.sizeParkingSlot; i++) {
                String key = Integer.toString(i);
                if (this.park.containsKey(key)) {
                    car = this.park.get(key);
                    if (car.color.equals(color)) {
                        slotList.add(Integer.parseInt(key));
                    }
                }
            }

            if (slotList.isEmpty()) {
                System.out.println("Not Found");
            } else {
                Collections.sort(slotList);
                for (int i = 1; i <= slotList.size(); i++) {
                    if (i == slotList.size()) {
                        System.out.print(slotList.get(i - 1));
                    } else {
                        System.out.print(slotList.get(i - 1) + ", ");
                    }
                }
                System.out.println();
            }
        }
    }

    public void getRegNoWithColor(String color) {
        if (this.sizeParkingSlot == 0) {
            System.out.println("Tempat Parkir lagi kosong");
        } else if(this.park.size() > 0) {
            ArrayList<String> slotList = new ArrayList<>() {};
            Car car;
            for (int i=1;i<=this.sizeParkingSlot;i++) {
                String key = Integer.toString(i);
                if (this.park.containsKey(key)) {
                    car = this.park.get(key);
                    if (car.color.equals(color)) {
                        slotList.add(car.regNo);
                    }
                }
            }
            Collections.sort(slotList);
            if (slotList.isEmpty()) {
                System.out.println("Not Found");
            } else {
                for (int i=1;i<=slotList.size();i++) {
                    if (i == slotList.size()) {
                        System.out.print(slotList.get(i-1));
                    } else {
                        System.out.print(slotList.get(i-1) + ", ");
                    }
                }
                System.out.println();
            }
        }
    }

    public void getSlotNumberWithRegistration(String noReg) {
        if (this.sizeParkingSlot == 0) {
            System.out.println("Tempat parkir lagi kosong");
        } else if(this.park.size() > 0) {
            ArrayList<Integer> slotList = new ArrayList<Integer>() {};
            Car car;
            for (int i=1; i<=this.sizeParkingSlot; i++) {
                String key = Integer.toString(i);
                if (this.park.containsKey(key)) {
                    car = this.park.get(key);
                    if (car.regNo.equals(noReg)) {
                        slotList.add(Integer.parseInt(key));
                    }
                }
            }

            if (slotList.isEmpty()) {
                System.out.println("Not Found");
            } else {
                Collections.sort(slotList);
                for (int i=1;i<=slotList.size();i++) {
                    if (i == slotList.size()) {
                        System.out.print(slotList.get(i-1));
                    } else {
                        System.out.print(slotList.get(i-1) + ", ");
                    }
                }
                System.out.println();
            }
        }
    }


}
