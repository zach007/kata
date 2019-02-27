package com.hsbc.kata.racecar.telemetrysystem

import spock.lang.Specification

class TelemetryDiagnosticControlsTest extends Specification {
    def telemetryClient = Mock(TelemetryClient)
    def telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient)

    def "CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response"() {
        setup:
        def result = "LAST TX rate................ 100 MBPS\r\n" + "HIGHEST TX rate............. 100 MBPS\r\n" + "LAST RX rate................ 100 MBPS\r\n" + "HIGHEST RX rate............. 100 MBPS\r\n" + "BIT RATE.................... 100000000\r\n" + "WORD LEN.................... 16\r\n" + "WORD/FRAME.................. 511\r\n" + "BITS/FRAME.................. 8192\r\n" + "MODULATION TYPE............. PCM/FM\r\n" + "TX Digital Los.............. 0.75\r\n" + "RX Digital Los.............. 0.10\r\n" + "BEP Test.................... -5\r\n" + "Local Rtrn Count............ 00\r\n" + "Remote Rtrn Count........... 00"
        telemetryClient.disconnect() >> false
        telemetryClient.connect(telemetryDiagnosticControls.getDiagnosticChannelConnectionString()) >> true
        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE) >> result
        telemetryClient.receive() >> result
        when:
        def message = telemetryDiagnosticControls.checkTransmission()
        then:
        message == result
        and:
        1 * telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE)
    }
}
