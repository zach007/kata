package com.hsbc.kata.racecar.telemetrysystem;

public class TelemetryDiagnosticControls {
    private final TelemetryClient telemetryClient;
    private final String DiagnosticChannelConnectionString = "*111#";

    public TelemetryDiagnosticControls(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    public String getDiagnosticChannelConnectionString() {
        return DiagnosticChannelConnectionString;
    }


    public String checkTransmission() throws Exception {
        telemetryClient.disconnect();

        int retryLeft = 3;
        boolean isConnectSuccess = telemetryClient.connect(DiagnosticChannelConnectionString);
        while (isConnectSuccess == false && retryLeft > 0) {
            telemetryClient.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (isConnectSuccess == false) {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        return telemetryClient.receive();
    }
}
