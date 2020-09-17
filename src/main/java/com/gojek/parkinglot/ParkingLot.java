package com.gojek.parkinglot;

import java.util.*;

public class ParkingLot {
    int MAX_SIZE = 0;
    private class Car {
        String regNo;
        public Car(String regNo) {
            this.regNo = regNo;
        }
    }
    // Available slots list
    ArrayList<Integer> availableSlotList;
    // Map of Slot, Car
    Map<String, Car> map1;
    // Map of RegNo, Slot
    Map<String, String> map2;


    public void createParkingLot(String lotCount) {
        try {
            this.MAX_SIZE = Integer.parseInt(lotCount);
        } catch (Exception e) {
            System.out.println("Invalid lot count");
            System.out.println();
        }
        this.availableSlotList = new ArrayList<Integer>() {};
        for (int i=1; i<= this.MAX_SIZE; i++) {
            availableSlotList.add(i);
        }
        this.map1 = new HashMap<String, Car>();
        this.map2 = new HashMap<String, String>();
        System.out.println("Created parking lot with " + lotCount + " slots");
        System.out.println();
    }
    public void park(String regNo) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() == this.MAX_SIZE) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } else {
            Collections.sort(availableSlotList);
            String slot = availableSlotList.get(0).toString();
            Car car = new Car(regNo);
            this.map1.put(slot, car);
            this.map2.put(regNo, slot);
            
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            availableSlotList.remove(0);
        }
    }
    public void leave(String regNo, String parkDur) {
        parkBill = 10;
        if (parkDur > 2){
            parkSurplus = parkDur - 2;
            parkBill = 10 + parkSurplus*10;
        }
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() > 0) {
            Car carToLeave = this.map1.get(slotNo);
            if (carToLeave != null) {
                this.map1.remove(slotNo);
                this.map2.remove(carToLeave.regNo);
                if (regNoList.contains(carToLeave.regNo)) {
                    regNoList.remove(carToLeave.regNo);
                } else {
                    System.out.println("Registration number " + regNo + "not found")
                }
                // Add the Lot No. back to available slot list.
                this.availableSlotList.add(Integer.parseInt(slotNo));
                System.out.println("Registration number " + regNo + " with Slot Number " + slotNo + " is free with Charge " + parkBill);
                System.out.println();
            } else {
                System.out.println("Slot number " + slotNo + " is already empty");
                System.out.println();
            }
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    public void status() {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration No.");
            Car car;
            for (int i = 1; i <= this.MAX_SIZE; i++) {
                String key = Integer.toString(i);
                if (this.map1.containsKey(key)) {
                    car = this.map1.get(key);
                    System.out.println(i + "\t" + car.regNo);
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
}
