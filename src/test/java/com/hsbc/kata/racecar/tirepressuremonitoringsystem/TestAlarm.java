package com.hsbc.kata.racecar.tirepressuremonitoringsystem;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAlarm {

    @Test
    public void foo() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }
}
