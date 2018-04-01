package com.parkinglot;

import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {
    Action actions = new Action();

    @Test
    public void checkAction() throws Exception {
        assertFalse(actions.actionsMap.isEmpty());
        assertTrue(actions.actionsMap.containsKey("create_parking_lot"));
        assertFalse(actions.actionsMap.containsKey("testaction"));
    }
}
