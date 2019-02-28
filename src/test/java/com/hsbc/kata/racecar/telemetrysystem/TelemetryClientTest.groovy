package com.hsbc.kata.racecar.telemetrysystem

import spock.lang.Shared
import spock.lang.Specification

/*
todo write test case for the telemetryClient first
todo and then write test case for TelemetryDiagnosticControls , mock telemetryClient.
* */

class TelemetryClientTest extends Specification {
    def telemetryClient = new TelemetryClient()
    @Shared
    def finalResult = "LAST TX rate................ 100 MBPS\r\n" + "HIGHEST TX rate............. 100 MBPS\r\n" + "LAST RX rate................ 100 MBPS\r\n" + "HIGHEST RX rate............. 100 MBPS\r\n" + "BIT RATE.................... 100000000\r\n" + "WORD LEN.................... 16\r\n" + "WORD/FRAME.................. 511\r\n" + "BITS/FRAME.................. 8192\r\n" + "MODULATION TYPE............. PCM/FM\r\n" + "TX Digital Los.............. 0.75\r\n" + "RX Digital Los.............. 0.10\r\n" + "BEP Test.................... -5\r\n" + "Local Rtrn Count............ 00\r\n" + "Remote Rtrn Count........... 00";

    def "should throw error when connectionString is null or empty"() {
        when:
        telemetryClient.connect(connectionString)
        then:
        thrown IllegalArgumentException
        where:
        connectionString | _
        null             | _
        ""               | _
    }

    //todo how to test a random number generation
    def "should return false when disconnect"() {
        when:
        telemetryClient.disconnect()
        then:
        telemetryClient.onlineStatus == false
    }

    def "should return boolean when connectionString is not null or empty"() {
        when:
        telemetryClient.connect("why this happen")
        then:
        telemetryClient.onlineStatus == true
    }


    def "should return message when send 'AT#UD' "() {
        when:
        def result = telemetryClient.sendMessage("AT#UD")
        then:
        result.length() > 0
    }

    def "should return empty message when not send 'AT#UD'"() {
        when:
        def result = telemetryClient.sendMessage("other parameter")
        then:
        result == ""
    }

    def "should return number when diagnosticMessageResult is null or empty"() {
        when:
        def result = telemetryClient.sendMessage(diagnosticMessageResult)
        then:
        result.matches("[0-9]+")
        and:
        result.length() > 0
        where:
        diagnosticMessageResult | _
        null                    | _
        ""                      | _
    }

    def "should return finalMessage when diagnosticMessageResult is 'AT#UD'"() {
        when:
        def diagnosticMessageResult = "AT#UD"
        def result = telemetryClient.sendMessage(diagnosticMessageResult)
        then:
        result == finalResult
    }

    def "should return '' when diagnosticMessageResult is not null or empty"() {
        when:
        def diagnosticMessageResult = "other parameter"
        def result = telemetryClient.sendMessage(diagnosticMessageResult)
        then:
        result == ""
    }
}
