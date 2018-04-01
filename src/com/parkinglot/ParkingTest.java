package com.parkinglot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParkingTest {
    Parking parking = new Parking();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void createParkingLot() throws Exception {
        parking.createParkingLot("6");
        assertEquals(6, parking.sizeParkingSlot);
        assertEquals(6, parking.parkingSpace.size());
        assertTrue("createdparkinglotwith6slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
    }

    @Test
    public void park() throws Exception {
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        assertEquals("noparkingslotshavebeencreated\n" +
                "\n" +
                "noparkingslotshavebeencreated", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        assertEquals(4, parking.parkingSpace.size());
    }

    @Test
    public void leave() throws Exception {
        parking.leave("2");
        assertEquals("noparkingslotshavebeencreated", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        parking.leave("4");
        assertEquals("noparkingslotshavebeencreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "Slotnumber4isalreadyempty", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void status() throws Exception {
        parking.status();
        assertEquals("noparkingslotshavebeencreated", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        parking.status();
        assertEquals("noparkingslotshavebeencreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "SlotNo.\tRegistrationNumber\tColor\n" +
                "1\tKA-01-HH-1234\tWhite\n" +
                "2\tKA-01-HH-9999\tWhite", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void getRegistrationNumbersFromColor() throws Exception {
        parking.getRegNoWithColor("White");
        assertEquals("noparkingslotshavebeencreated", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        parking.getRegNoWithColor("White");
        assertEquals("noparkingslotshavebeencreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "KA-01-HH-1234,KA-01-HH-9999", outContent.toString().trim().replace(" ", ""));
        parking.getRegNoWithColor("Red");
        assertEquals("noparkingslotshavebeencreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "KA-01-HH-1234,KA-01-HH-9999Notfound", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void getSlotNumbersFromColor() throws Exception {
        parking.getSlotNumbersWithColor("White");
        assertEquals("noparkingslotshavebeencreated", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        parking.getSlotNumbersWithColor("White");
        assertEquals("noparkingslotshavebeencreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "1,2", outContent.toString().trim().replace(" ", ""));
        parking.getSlotNumbersWithColor("Red");
        assertEquals("noparkingslotshavebeencreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "1,2\n" +
                "Notfound", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void getSlotNumberFromRegNo() throws Exception {
        parking.getSlotNumberWithRegistration("KA-01-HH-1234");
        assertEquals("noparkingslotshavebeencreated", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        parking.getSlotNumberWithRegistration("KA-01-HH-1234");
        assertEquals("noparkingslotshavebeencreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1", outContent.toString().trim().replace(" ", ""));
        parking.getSlotNumberWithRegistration("KA-01-HH-9999");
        assertEquals("noparkingslotshavebeencreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1\n" +
                "2", outContent.toString().trim().replace(" ", ""));
        parking.leave("1");
        parking.getSlotNumberWithRegistration("KA-01-HH-1234");
        assertEquals("noparkingslotshavebeencreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1\n" +
                "2\n" +
                "Slotnumber1isfree\n" +
                "\n" +
                "Notfound", outContent.toString().trim().replace(" ", ""));
    }

}
