package com.hsbc.kata.racecar.telemetrysystem

import spock.lang.Specification

class TelemetryDiagnosticControlsTest extends Specification {
    TelemetryClient telemetryClient = Mock()
    def telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient)

    def "CheckTransmission should send a diagnostic message and receive a status message response"() {
        when:
        def result = telemetryDiagnosticControls.checkTransmission()
        then:
        result == "what"
        and:
        1 * telemetryClient.disconnect() >> false
        1 * telemetryClient.connect(telemetryDiagnosticControls.DiagnosticChannelConnectionString) >> true
        1 * telemetryClient.sendMessage(telemetryClient.DIAGNOSTIC_MESSAGE) >> "what"
    }

    def "CheckTransmission should throws exception"() {
        when:
        telemetryDiagnosticControls.checkTransmission()
        then:
        def e = thrown(Exception)
        e.message == "Unable to connect."
        and:
        1 * telemetryClient.disconnect() >> false
        3 * telemetryClient.connect(telemetryDiagnosticControls.DiagnosticChannelConnectionString) >> false
        0 * telemetryClient.sendMessage(telemetryClient.DIAGNOSTIC_MESSAGE)
    }
}
