package com.hsbc.kata.racecar.telemetrysystem;

public class TelemetryDiagnosticControls {
    private final String DiagnosticChannelConnectionString = "*111#";

    private final TelemetryClient telemetryClient;

    public TelemetryDiagnosticControls(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }


    public String checkTransmission() throws Exception {

        telemetryClient.disconnect();

        for (int i = 3; i > 0; i--) {
            boolean connect = telemetryClient.connect(DiagnosticChannelConnectionString);
            System.out.println(connect);
            if (connect) {
                String s = telemetryClient.sendMessage(TelemetryClient.DIAGNOSTIC_MESSAGE);
                System.out.println(s);
                return s;
            } else {
            }
        }

        throw new Exception("Unable to connect.");
    }
}
