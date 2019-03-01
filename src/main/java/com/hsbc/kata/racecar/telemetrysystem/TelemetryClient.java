package com.hsbc.kata.racecar.telemetrysystem;

import java.util.Random;

public class TelemetryClient {
    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";
    private final Random connectionEventsSimulator = new Random(42);
    public static final String DIAGNOSTIC_MESSAGE_RESULT =
            "LAST TX rate................ 100 MBPS\r\n"
                    + "HIGHEST TX rate............. 100 MBPS\r\n"
                    + "LAST RX rate................ 100 MBPS\r\n"
                    + "HIGHEST RX rate............. 100 MBPS\r\n"
                    + "BIT RATE.................... 100000000\r\n"
                    + "WORD LEN.................... 16\r\n"
                    + "WORD/FRAME.................. 511\r\n"
                    + "BITS/FRAME.................. 8192\r\n"
                    + "MODULATION TYPE............. PCM/FM\r\n"
                    + "TX Digital Los.............. 0.75\r\n"
                    + "RX Digital Los.............. 0.10\r\n"
                    + "BEP Test.................... -5\r\n"
                    + "Local Rtrn Count............ 00\r\n"
                    + "Remote Rtrn Count........... 00";


    public boolean connect(String telemetryServerConnectionString) {
        illegalArgumentException(telemetryServerConnectionString);

        // simulate the operation on a real modem
        boolean success = connectionEventsSimulator.nextInt(10) <= 8;

        return success;
    }

    private void illegalArgumentException(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean disconnect() {
        return false;
    }


    public String sendMessage(String message) {
        if (message == null || "".equals(message)) {
            return numberMessage();
        } else if (message == DIAGNOSTIC_MESSAGE) {
            return DIAGNOSTIC_MESSAGE_RESULT;
        } else {
            return "";
        }
    }

    private String numberMessage() {
        String message = "";
        int messageLength = connectionEventsSimulator.nextInt(50) + 60;
        for (int i = messageLength; i >= 0; --i) {
            message += (char) connectionEventsSimulator.nextInt(40) + 86;
        }
        return message;
    }
}

