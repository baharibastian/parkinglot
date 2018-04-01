package com.parkinglot;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ParserTest {
    Parser inputParser = new Parser();
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
    public void parseInput() throws Exception {
        inputParser.parseInput("hello");
        assertEquals("Invalidinput", outContent.toString().trim().replace(" ", ""));
        inputParser.parseInput("status");
        assertEquals("Invalidinput\nSorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
    }
}
